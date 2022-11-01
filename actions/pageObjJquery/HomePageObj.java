package pageObjJquery;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.Jquery.HomePageUI;

public class HomePageObj extends BasePage {
	WebDriver driver;

	public HomePageObj(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingPageByPageNumber(String pageNumber) {
		waitForElementClickAble(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForAllElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeysToElementByXpath(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		
	}
	
	
}
