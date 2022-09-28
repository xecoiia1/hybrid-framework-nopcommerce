package pageObject;

import common.BasePage;

import pageUI.RegisterPageUI;

import org.openqa.selenium.WebDriver;



public class RegisterPageObj extends BasePage {

	private WebDriver driver;
	
	public RegisterPageObj(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterBtn() {
		waitForElementClickAble(driver, RegisterPageUI.REGISTER_BTN);
		clickToElementByXpath(driver, RegisterPageUI.REGISTER_BTN);
	}

	public void inputToFirstnameTextBox(String firtName) {
		waitForAllElementVisible(driver, RegisterPageUI.FISRT_NAME_TEXTBOX);
		sendkeysToElementByXpath(driver, RegisterPageUI.FISRT_NAME_TEXTBOX, firtName);
	}

	public void inputToLastnameTextBox(String lastName) {
		waitForAllElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeysToElementByXpath(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	public void inputToEmailTextBox(String emailAdd) {
		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeysToElementByXpath(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAdd);
		
	}

	public void inputToPasswordTextBox(String passWord) {
		waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeysToElementByXpath(driver, RegisterPageUI.PASSWORD_TEXTBOX, passWord);
		
	}

	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeysToElementByXpath(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}
	
	public String getConfirmPasswordNotMatchMessage() {
		waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_NOT_MATCH_MES);
		return getTextOfElement(driver, RegisterPageUI.CONFIRM_PASSWORD_NOT_MATCH_MES);
	}

	public String getPasswordWrongRuleMessage() {
		waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_WRONG_RULE_MES);
		return getTextOfElement(driver, RegisterPageUI.PASSWORD_WRONG_RULE_MES);
	}

	public String getEmailExitstsMessage() {
		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_EXIST_ERROR_MES);
		return getTextOfElement(driver, RegisterPageUI.EMAIL_EXIST_ERROR_MES);
	}

	public void clickToLogoutBtn() {
		waitForElementClickAble(driver, RegisterPageUI.LOGOUT_BTN);
		clickToElementByXpath(driver, RegisterPageUI.LOGOUT_BTN);
		
	}

	public String getSuccessRegisterSucces() {
		waitForAllElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MES);
		return getTextOfElement(driver, RegisterPageUI.REGISTER_SUCCESS_MES);
	}

	public String getErrorMessageWrongAtEmailTestBox() {
		waitForAllElementVisible(driver, RegisterPageUI.WRONG_EMAIL_MES);
		return getTextOfElement(driver, RegisterPageUI.WRONG_EMAIL_MES);
	}

	public String getErrorMessageAtFirstNameTestBox() {
		waitForAllElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MES);
		return getTextOfElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MES);
	}

	public String getErrorMessageAtLastNameTestBox() {
		waitForAllElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MES);
		return getTextOfElement(driver, RegisterPageUI.LAST_NAME_ERROR_MES);
	}

	public String getErrorMessageAtEmailTestBox() {
		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MES);
		return getTextOfElement(driver, RegisterPageUI.EMAIL_ERROR_MES);
	}

	public String getErrorMessageAtPasswordTestBox() {
		waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MES);
		return getTextOfElement(driver, RegisterPageUI.PASSWORD_ERROR_MES);
	}

	public String getErrorMessageAtConfirmPasswordTestBox() {
		waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MES);
		return getTextOfElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MES);
	}

}
