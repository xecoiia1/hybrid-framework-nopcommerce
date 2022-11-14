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

	public void enterToEmailaddressTextBox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeysToElementByXpath(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
		
	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplay(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickCloseIconAtRegisterForm() {
		waitForElementClickAble(driver, LoginPageUI.CLOSE_ICON);
		clickToElementByXpath(driver, LoginPageUI.CLOSE_ICON);
	}

	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}


	
	
}
