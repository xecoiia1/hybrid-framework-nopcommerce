package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements BrowserFactory {

	@Override
	public WebDriver BrowserFactory() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//Setting capability/ Options
		return new ChromeDriver(options);
	}

}
