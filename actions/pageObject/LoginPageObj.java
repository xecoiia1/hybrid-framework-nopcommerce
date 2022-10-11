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

	public HomePageObj clickToLoginBtn() {
		waitForElementClickAble(driver, LoginPageUI.LOGIN_BTN);
		clickToElementByXpath(driver, LoginPageUI.LOGIN_BTN);
		return PageGeneratorManager.getHomePage(driver);
		
	}

	public void inputInvalidEmail(String invalidEmail) {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElementByXpath(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);
		
	}
	
	public String getInvalidErrorMesAtEmailTextBox() {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_ERROR_MES);
		return getTextOfElement(driver, LoginPageUI.EMAIL_ERROR_MES);
	}

	public void inputNotFoundEmail(String notFoundEmail) {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElementByXpath(driver, LoginPageUI.EMAIL_TEXTBOX, notFoundEmail);
		
	}

	public String getErrorNotFoundEmail() {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_NOT_FOUND_MES);
		return getTextOfElement(driver, LoginPageUI.EMAIL_NOT_FOUND_MES);
	}

	public void inputPassWordTextBox(String Password) {
		waitForAllElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElementByXpath(driver, LoginPageUI.PASSWORD_TEXTBOX, Password);
		
	}
}

