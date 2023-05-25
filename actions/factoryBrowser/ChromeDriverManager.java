package factoryBrowser;

import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commonJquery.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements BrowserFactory {

	@Override
	public WebDriver BrowserFactory() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//Setting capability/ Options
		//options.addArguments("--disable-infobars");
		//Disable inforbar
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		//Disable notification
		options.addArguments("--disable-notifications");
		//Disable location
		options.addArguments("--disable-geolocation");
		
		//Save Data
		HashMap<String, Object> chromePref = new HashMap<String, Object>();
		chromePref.put("profile.default_content_settings.popups", 0);
		chromePref.put("download.default_directory", GlobalConstants.DOWNLOAD_FOLDER);
		options.setExperimentalOption("prefs", chromePref);
		
		//Run with incognito mode
		options.addArguments("--incognito");
		return new ChromeDriver(options);
	}

}
