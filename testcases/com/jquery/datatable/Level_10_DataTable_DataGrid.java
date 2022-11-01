package com.jquery.datatable;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import commonJquery.BaseTestJquery;
import exception.BrowserNotSupport;
import pageObjJquery.HomePageObj;
import pageObjJquery.PageGeneratorManagerJQuery;
import pageObject.nopCommerce.user.UserAddressPageObj;
import pageObject.nopCommerce.user.UserCustomerInforPageObj;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserLoginPageObj;
import pageObject.nopCommerce.user.UserMyProductReviewPageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;
import pageObject.nopCommerce.user.UserRewardPointPageObj;

public class Level_10_DataTable_DataGrid extends BaseTestJquery  {
	HomePageObj homePage;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) throws BrowserNotSupport {
	driver = getBrowserDriver(browserName, appUrl);	
	homePage = PageGeneratorManagerJQuery.getHomePage(driver);
  }
  
  @Test
  public void Table_01_Paging() {
		homePage.openPagingPageByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		
		homePage.openPagingPageByPageNumber("15");
		Assert.assertTrue(homePage.isPageNumberActived("15"));
		
		homePage.openPagingPageByPageNumber("18");
		Assert.assertTrue(homePage.isPageNumberActived("18"));
		
		homePage.openPagingPageByPageNumber("19");
		Assert.assertTrue(homePage.isPageNumberActived("19"));
  }
    
  @Test
  public void Table_02_Enter_Header_Textbox() {
	  	homePage.refreshPage(driver);
	  	homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
	  	homePage.enterToHeaderTextboxByLabel("Females", "338282");
	  	homePage.enterToHeaderTextboxByLabel("Males", "349238");
	  	homePage.enterToHeaderTextboxByLabel("Total", "687522");
	  	homePage.sleepInSecond(3);
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
//  //Jquery check textcontent
//  var element = $$("div.validation-summary-errors")[0];
//  element.textContent;
 private WebDriver driver;

}