package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;

public class UserPostDetailPO extends BasePageJquery {
	WebDriver driver;
	
	public UserPostDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayed(String postTitle) {
		// TODO Auto-generated method stub
		return false;
	}
	
}