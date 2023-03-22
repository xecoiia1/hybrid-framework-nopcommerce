package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commonJquery.BasePageJquery;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePageJquery {
	WebDriver driver;
	
	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToPostTitle(String postTitleValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_TITLE_TEXTBOX);
		sendkeysToElementByXpath(driver, AdminPostAddNewPageUI.POST_TITLE_TEXTBOX, postTitleValue);
	}

	public void enterToPostBody(String postBodyValue) {
		waitForElementClickAble(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX_BUTTON);
		clickToElementByXpath(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX_BUTTON);
		sleepInSecond(2);
		sendkeysToElementByXpath(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX, postBodyValue);		
	}

	public void clickToPublishBtn() {
		waitForElementClickAble(driver, AdminPostAddNewPageUI.PUBLISH_BTN);
		clickToElementByXpath(driver, AdminPostAddNewPageUI.PUBLISH_BTN);
	}
	
	public void clicktoPublishBtnConfirm() {
		waitForElementClickAble(driver, AdminPostAddNewPageUI.PUBLISH_CONFIRM_BTN);
		clickToElementByXpath(driver, AdminPostAddNewPageUI.PUBLISH_CONFIRM_BTN);
	}

	public boolean isPostPublishMessDisplayed(String postPublishedMessage) {
		waitForAllElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
		return isElementDisplay(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageURL(driver, searchPostUrl);
		return PageGeneratorManager.getAdminPostSeachPage(driver);
	}

}
