package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;

public class AdminDashboardPO extends BasePageJquery {
	
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}
}
