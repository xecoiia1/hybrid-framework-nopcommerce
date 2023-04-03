package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;

public class UserHomePO extends BasePageJquery {
	WebDriver driver;
	
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayed(String postTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clicktoPostTitlte(String postTitle) {
		// TODO Auto-generated method stub
		
	}
	
}
