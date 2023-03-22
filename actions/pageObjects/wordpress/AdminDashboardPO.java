package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;
import pageUIs.wordpress.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePageJquery {
	
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostMenuLink() {
		waitForElementClickAble(driver, AdminDashboardPageUI.POST_MENU_LINK);
		clickToElementByXpath(driver, AdminDashboardPageUI.POST_MENU_LINK);
		return PageGeneratorManager.getAdminPostSeachPage(driver);
	}
}
