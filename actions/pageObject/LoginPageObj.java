package pageObject;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.LoginPageUI;
import pageUI.RegisterPageUI;

import org.openqa.selenium.WebDriver;

public class LoginPageObj extends BasePage {
	private WebDriver driver;

	public LoginPageObj(WebDriver driver) {
		this.driver = driver;
	}

	public String getErrorMesAtEmailTextBox() {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_ERROR_MES);
		return getTextOfElement(driver, LoginPageUI.EMAIL_ERROR_MES);
	}

	public void clickToLoginBtn() {
		waitForElementClickAble(driver, LoginPageUI.LOGIN_BTN);
		clickToElementByXpath(driver, LoginPageUI.LOGIN_BTN);
		
	}

	public void inputInvalidEmail(String invalidEmail) {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElementByXpath(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);
		
	}
	
	public String getInvalidErrorMesAtEmailTextBox() {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_ERROR_MES);
		return getTextOfElement(driver, LoginPageUI.EMAIL_ERROR_MES);
	}
}

