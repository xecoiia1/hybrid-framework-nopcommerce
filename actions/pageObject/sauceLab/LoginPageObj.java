package pageObject.sauceLab;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;
import pageUI.sauceLab.LoginPageUI;

public class LoginPageObj extends BasePageJquery {
	
	WebDriver driver;
	
	public LoginPageObj(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTextBox(String userName) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendkeysToElementByXpath(driver, LoginPageUI.USERNAME_TEXTBOX, userName);
	}

	public void enterToPassWordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElementByXpath(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public ProductPageObj clickLoginBtn() {
		waitForElementClickAble(driver, LoginPageUI.LOGIN_BTN);
		clickToElementByXpath(driver, LoginPageUI.LOGIN_BTN);
		return PageGeneratorManager.getProductPage(driver);
	}
}
