package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;
import pageUIs.wordpress.AdminLoginPageUI;

public class AdminLoginPO extends BasePageJquery {
	
	WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsernameTextBox(String adminUser) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		sendkeysToElementByXpath(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUser);
		
	}

	public void enterPasswordTextBox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElementByXpath(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
		
	}

	public AdminDashboardPO clickToLoginBtn() {
		waitForElementClickAble(driver, AdminLoginPageUI.LOGIN_BTN);
		clickToElementByXpath(driver, AdminLoginPageUI.LOGIN_BTN);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

}
