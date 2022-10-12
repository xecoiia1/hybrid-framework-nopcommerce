package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUI.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObj extends BasePage {
	private WebDriver driver;
	
	public AdminLoginPageObj(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToUsernameTextBox(String adminEmail) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElementByXpath(driver, AdminLoginPageUI.EMAIL_TEXTBOX, adminEmail);
	}
	
	public void inputToPasswordTextBox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElementByXpath(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
	}
	
	public AdminDashboardPageObj clickToLoginButton() {
		waitForElementClickAble(driver, AdminLoginPageUI.LOGIN_BTN);
		clickToElementByXpath(driver, AdminLoginPageUI.LOGIN_BTN);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	public AdminDashboardPageObj loginAsAdmin(String adminEmail, String adminPassword) {
		inputToUsernameTextBox(adminEmail);
		inputToPasswordTextBox(adminPassword);
		return clickToLoginButton();
	}
}
