package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;
import pageUIs.wordpress.admin.AdminPostSeachPageUI;

public class AdminPostSearchPO extends BasePageJquery {
	
	WebDriver driver;
	
	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewBtn() {
		waitForElementClickAble(driver, AdminPostSeachPageUI.ADD_NEW_BTN);
		clickToButtonByText(driver, AdminPostSeachPageUI.ADD_NEW_BTN);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

}
