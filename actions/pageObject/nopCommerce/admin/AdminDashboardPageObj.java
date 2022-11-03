package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.nopCommerce.admin.AdminDashboardPageUI;
import pageUI.nopCommerce.admin.AdminLoginPageUI;

public class AdminDashboardPageObj extends BasePage {
	private WebDriver driver;
	
	public AdminDashboardPageObj(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDashBoardDisplayed() {
		return isElementDisplay(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}

	public AdminLoginPageObj clickToLogoutBtnAdmin(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
