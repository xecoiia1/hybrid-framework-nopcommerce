package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;
import pageUI.facebook.LoginPageUI;

public class LoginPageObj extends BasePageJquery {
	WebDriver driver;

	public LoginPageObj(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickAble(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElementByXpath(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplay(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}


	
	
}
