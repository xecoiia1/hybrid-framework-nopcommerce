package pageObjJquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import commonJquery.BasePageJquery;
import pageUI.Jquery.HomePageUI;

public class HomePageObj extends BasePageJquery {
	WebDriver driver;

	public HomePageObj(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingPageByPageNumber(String pageNumber) {
		waitForElementClickAble(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeysToElementByXpath(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
		
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplay(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public void getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		
		List<String> allRowValue = new ArrayList<String>();
		
		//Duyệt qua tất cả page number
		for (int index = 0; index < totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION__BY_INDEX, String.valueOf(index));
			sleepInSecond(1);
			
			List<WebElement> allRowValueEachPage = getListElementByXpath(driver, HomePageUI.ALL_ROW_EACH_PAGE);
		}
		
	}
	
	
}
