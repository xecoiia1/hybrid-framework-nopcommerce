package javaBasic;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_09_String_Format {
	
	// 4 pages = 14 biến locator
	public static final String CUSTOMER_INFO_PAGE = "xpath=//div[@class='listbox']//a[text()='Customer info']";
	public static final String ADDRESS_PAGE = "xpath=//div[@class='listbox']//a[text()='Addresses']";
	public static final String REWARD_POINT_PAGE = "xpath=//div[@class='listbox']//a[text()='Reward points']";
	public static final String MY_PRODUCT_REVIEWS_PAGE = "xpath=//div[@class='listbox']//a[text()='My product reviews']";
	
	//1 biến cho cả 14 page hoặc n page
	public static final String DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME = "xpath=//div[@class='listbox']//a[text()='%s']";
	
	// 1 locator để đại điện cho các page (Header/Sidebar/Footer)
	public static final String DYNAMIC_LINK_BY_PAGE_NAME = "xpath=//div[@class='%s']//a[text()='%s']";
	
	//1 locator có tới 4, 5, 6 tham số động
	
		public static void main(String[] arg) {
			//clickToSideBarLink(CUSTOMER_INFO_PAGE);
			clickToSideBarLink(ADDRESS_PAGE);
			clickToSideBarLink(REWARD_POINT_PAGE);
			clickToSideBarLink(MY_PRODUCT_REVIEWS_PAGE);
			
			clickToSideBarLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Customer info");
			clickToSideBarLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Addresses");
			clickToSideBarLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Reward points");
			clickToSideBarLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "My product reviews");
			
			clickToSideBarLink(DYNAMIC_LINK_BY_PAGE_NAME, "listbox", "Reward points");
		}
		
//		public static void clickToSideBarLink(String locator) {
//			System.out.println("Click to" + locator);
//		}
//		
//		public static void clickToSideBarLink(String dynamicLocator, String pageName) {
//			String locator = dynamicLocator.format(dynamicLocator, pageName);
//			System.out.println("Click to" + locator);
//		}
//		
//		public static void clickToSideBarLink(String dynamicLocator, String areaName, String pageName) {
//			String locator = dynamicLocator.format(dynamicLocator, areaName, pageName);
//			System.out.println("Click to" + locator);
//		}
		
		public static void clickToSideBarLink(String dynamicLocator, String... params) {
			String locator = dynamicLocator.format(dynamicLocator,(Object[]) params);
			System.out.println("Click to" + locator);
		}

}


