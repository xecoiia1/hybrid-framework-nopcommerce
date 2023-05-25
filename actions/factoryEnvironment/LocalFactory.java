package factoryEnvironment;

import org.openqa.selenium.WebDriver;

public class LocalFactory  {
	private WebDriver driver;
	private String browserName;
	
	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() {
		return driver;
		
	}
}
