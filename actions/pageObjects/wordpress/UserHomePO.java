package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;

public class UserHomePO extends BasePageJquery {
	WebDriver driver;
	
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}
	
}
