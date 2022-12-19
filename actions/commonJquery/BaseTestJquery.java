package commonJquery;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestJquery {
	private WebDriver driver;
	
	protected final Log log;
	
	protected BaseTestJquery() {
		log = LogFactory.getLog(getClass());
	}
	
	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReport();
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
			//Add Extension to FireFox
			FirefoxProfile profile = new FirefoxProfile();
			File translate  = new File(GlobalConstants.PROJECT_PATH + "\\browserExtension\\Google_Translate_Firefox.xpi");
			profile.addExtension(translate);
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			options.addPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
			driver = new FirefoxDriver(options);
		
		}else if (browserName.equals("h_firefox")){
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
		    driver = new FirefoxDriver(options);
		    
		}
		else if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.arg", "--disable-logging");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			
			//Add Extension to Chrome
			File file = new File(GlobalConstants.PROJECT_PATH + "\\browserExtension\\Google_Translate_Chrome.crx");
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(file);			
			driver = new ChromeDriver(options);
			
		}else if(browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
			
		}else if(browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new EdgeDriver();
		
		}else if(browserName.equals("ie")) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		
		}else if(browserName.equals("coccoc")) {
			//Cốc cốc driver sẽ dùng chrome driver nhưng là trừ đi 5 -6 version
			WebDriverManager.chromedriver().driverVersion("").setup();
			ChromeOptions options = new ChromeOptions();
			// Add file path của Cốc Cốc Browser vào
			if(GlobalConstants.OS_NAME.startsWith("Windows")) {
				options.setBinary("");
			}else {
				options.setBinary(".....");
			}
			driver = new ChromeDriver(options);
		
		}else {
			throw new BrowserNotSupport(browserName);
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(GlobalConstants.PORTAL_PAGE_URL);
		driver.manage().window().maximize();
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browserName.equals("h_firefox")){
			WebDriverManager.firefoxdriver().setup();
			
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
		    driver = new FirefoxDriver(options);
		    
		}else if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
			
		}else if(browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new EdgeDriver();
		}else if(browserName.equals("ie")) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		
		}else if(browserName.equals("coccoc")) {
			//Cốc cốc driver sẽ dùng chrome driver nhưng là trừ đi 5 -6 version
			WebDriverManager.chromedriver().driverVersion("").setup();
			ChromeOptions options = new ChromeOptions();
			// Add file path của Cốc Cốc Browser vào
			if(GlobalConstants.OS_NAME.startsWith("Windows")) {
				options.setBinary("");
			}else {
				options.setBinary(".....");
			}
			driver = new ChromeDriver(options);
		
		}else {
			throw new BrowserNotSupport(browserName);
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appUrl);
		driver.manage().window().maximize();
		return driver;
	}
	
	public boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			System.out.println(" -------------------------- PASSED -------------------------- ");
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			System.out.println(" -------------------------- FAILED -------------------------- ");
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			System.out.println(" -------------------------- PASSED -------------------------- ");
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			System.out.println(" -------------------------- FAILED -------------------------- ");
			pass = false;
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true; 
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	public void deleteAllureReport() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}
	
	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	  public int generateRandom() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	  }

}

