package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;
import pageUIs.wordpress.AdminPostSeachPageUI;

public class AdminPostSearchPO extends BasePageJquery {
	
	WebDriver driver;
	
	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewBtn() {
		waitForElementClickAble(driver, AdminPostSeachPageUI.ADD_NEW_BTN);
		clickToElementByXpath(driver, AdminPostSeachPageUI.ADD_NEW_BTN);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void enterToSearchTextBox(String postTitle) {
		// TODO Auto-generated method stub
		
	}

	public void clickToSearchPostsButton() {
		// TODO Auto-generated method stub
		
	}

	public boolean isPostSearchTableDisplayed(String string, String postTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserHomePO openEndUserSite(String endUserURL) {
		// TODO Auto-generated method stub
		return null;
	}

}
