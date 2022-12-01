package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import commonJquery.BasePageJquery;
import io.qameta.allure.Step;
import pageUI.nopCommerce.user.LoginPageUI;
import pageUI.nopCommerce.user.RegisterPageUI;

import org.openqa.selenium.WebDriver;

public class UserLoginPageObj extends BasePageJquery {
	private WebDriver driver;

	public UserLoginPageObj(WebDriver driver) {
		this.driver = driver;
	}

	public String getErrorMesAtEmailTextBox() {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_ERROR_MES);
		return getTextOfElement(driver, LoginPageUI.EMAIL_ERROR_MES);
	}
	@Step("Navigate to Login Page")
	public UserHomePageObj clickToLoginBtn() {
		waitForElementClickAble(driver, LoginPageUI.LOGIN_BTN);
		clickToElementByXpath(driver, LoginPageUI.LOGIN_BTN);
		return PageGeneratorManager.getUserHomePage(driver);
		
	}

	public void inputInvalidEmail(String invalidEmail) {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElementByXpath(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);
		
	}
	@Step("Enter to Email textbox with value is {0}")
	public void inputEmail(String email) {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElementByXpath(driver, LoginPageUI.EMAIL_TEXTBOX, email);
		
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
	@Step("Enter to Password textbox with value is {0}")
	public void inputPassWordTextBox(String Password) {
		waitForAllElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElementByXpath(driver, LoginPageUI.PASSWORD_TEXTBOX, Password);
		
	}

	public UserHomePageObj loginAsUser(String email, String password) {
		inputEmail(email);
		inputPassWordTextBox(password);
		return clickToLoginBtn();
		
	}
}

