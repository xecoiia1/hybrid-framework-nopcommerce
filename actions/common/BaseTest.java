package common;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	
	protected WebDriver getBrowserDriver(String browserName) {
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
		driver.get(GlobalConstants.PORTAL_PAGE_URL);
		driver.manage().window().maximize();
		return driver;
	}
	
	  public int generateRandom() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	  }
}

