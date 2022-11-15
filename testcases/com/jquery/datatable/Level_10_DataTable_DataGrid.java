package com.jquery.datatable;

import static org.testng.Assert.assertTrue;

import java.util.List;

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
import pageUI.Jquery.HomePageUI;

public class Level_10_DataTable_DataGrid extends BaseTestJquery  {
	HomePageObj homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) throws BrowserNotSupport {
	driver = getBrowserDriver(browserName, appUrl);	
	homePage = PageGeneratorManagerJQuery.getHomePage(driver);
  }
  
  
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
    
 
  public void Table_02_Enter_Header_Textbox() {
	  	homePage.refreshPage(driver);
	  	homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
	  	homePage.enterToHeaderTextboxByLabel("Females", "338282");
	  	homePage.enterToHeaderTextboxByLabel("Males", "349238");
	  	homePage.enterToHeaderTextboxByLabel("Total", "687522");
	  	homePage.sleepInSecond(3);
  }
  
  
  public void Table_03_Enter_Header_Textbox() {
	  //Đọc dữ liệu trong file tx
	  //Lưu vào 1 List<String> = ExpectedValues = expectedAllCountryValues
	  
	  actualAllCountryValues = homePage.getValueEachRowAtAllPage();
	  
	  Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	 
  }
  @Test
  public void Table_04_Action_At_Any_Row() {
	  
	  homePage.clickToLoadButton();
	  // Value để nhập dữ liệu
	  // Row number, column index
	  
	   homePage.enterToTextboxAtRowNumberByColumnName("Album", "1", "Michael 97");
	   homePage.enterToTextboxAtRowNumberByColumnName("Artist", "2", "Taylor");
	   homePage.enterToTextboxAtRowNumberByColumnName("Year", "3", "2000");
	   homePage.enterToTextboxAtRowNumberByColumnName("Price", "4", "15");
	   
	   homePage.selectDropdownByColumnNameAtRowNumber("Origin", "5", "Hong Kong");
	   homePage.selectDropdownByColumnNameAtRowNumber("Origin", "4", "Japan");
	   homePage.selectDropdownByColumnNameAtRowNumber("Origin", "3", "Taiwan");
	   
	   homePage.checkToCheckBoxByColumnNameAtRowNumber("With Poster?","3");
	   homePage.checkToCheckBoxByColumnNameAtRowNumber("With Poster?","5");
	   homePage.unCheckToCheckBoxByColumnNameAtRowNumber("With Poster?","1");
	   homePage.unCheckToCheckBoxByColumnNameAtRowNumber("With Poster?","2");
	   homePage.unCheckToCheckBoxByColumnNameAtRowNumber("With Poster?","4");
	   
	   homePage.clickToButtonByRowNumber("1", "Remove Current Row");
	   
	   homePage.clickToButtonByRowNumber("1", "Insert Row Above");
	   
	   homePage.clickToButtonByRowNumber("3", "Move Up");
	   
	   homePage.clickToButtonByRowNumber("5", "Remove Current Row");
	   
	   homePage.clickToButtonByRowNumber("4", "Remove Current Row");
	   
	   homePage.clickToButtonByRowNumber("3", "Remove Current Row");
	   
	   homePage.clickToButtonByRowNumber("2", "Remove Current Row");
	   
	   homePage.clickToButtonByRowNumber("1", "Remove Current Row");
	   
	   
	   homePage.sleepInSecond(20);
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