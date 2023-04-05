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
		waitForElementVisible(driver, AdminPostSeachPageUI.SEARCH_TEXTBOX);
		sendkeysToElementByXpath(driver, AdminPostSeachPageUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickToSearchPostsButton() {
		waitForElementClickAble(driver, AdminPostSeachPageUI.SEARCH_POSTS_BUTTON);
		clickToElementByXpath(driver, AdminPostSeachPageUI.SEARCH_POSTS_BUTTON);
	}

	public boolean isPostSearchTableDisplayed(String headerID, String cellValue) {
		int headerIndex = getElementSize(driver, AdminPostSeachPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID) + 1;
		waitForElementVisible(driver, AdminPostSeachPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		return isElementDisplay(driver, AdminPostSeachPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
	}

}
