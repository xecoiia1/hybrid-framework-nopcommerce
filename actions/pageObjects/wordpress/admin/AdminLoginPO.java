package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;

public class AdminLoginPO extends BasePageJquery {
	
	WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

}
