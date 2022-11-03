package pageObjJquery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

//	public List<String> getValueEachRowAtAllPage() {
//		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
//		
//		List<String> allRowValueAllPage = new ArrayList<String>();
//		
//		//Dùng Set thì khi lưu vào sẽ chỉ lưu 1 giá trị, không lưu trùng
//		Set<String> allRowValueUniqueAllPage = new HashSet<String>();
//		
//		//Duyệt qua tất cả page number
//		for (int index = 1; index <= totalPage; index++) {
//			clickToElement(driver, HomePageUI.PAGINATION__BY_INDEX, String.valueOf(index));
//			//sleepInSecond(1);
//			
//			//Get text của all row mỗi page và đưa vào array List
//			List<WebElement> allRowValueEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
//			for (WebElement eachRow : allRowValueEachPage) {
//				allRowValueAllPage.add(eachRow.getText());
//			}
//		}
//		
//		//In tất cả các giá trị row ra 
//		for (String value : allRowValueAllPage) {
//			System.out.println("***************************");
//			System.out.println(value);
//		}
//		return allRowValueAllPage;
//		
//		
//	}
	

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size = " + totalPage);

		List<String> allRowValueAllPage = new ArrayList<String>();

		// Duyệt qua tất cả các page
		for (int i = 1; i <= totalPage; i++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, String.valueOf(i));

			List<WebElement> allRownElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			// Get text cua tat ca row mỗi page đưa vào ArrayList
			for (WebElement eachRow : allRownElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		// In tất cả giá trị row - tất cả các page
		for (String value : allRowValueAllPage) {
			System.out.println("-----------------------------------");
			System.out.println(value);
		}

		return allRowValueAllPage;
	}
	
	
}
