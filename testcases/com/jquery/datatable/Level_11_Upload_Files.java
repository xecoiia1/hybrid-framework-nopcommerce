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

public class Level_11_Upload_Files extends BaseTestJquery  {
	
	String indonesiaFileName = "Indonesia.jpg";
	String thaiLandFileName = "Thai_Lan.jpg";
	String vietnamFileName = "Viet_Nam.jpg";
	String mitchellFileName = "mitchell-orr-Ztfns5iC_xs-unsplash.jpg";
	String[] multiFiles = {indonesiaFileName, thaiLandFileName, vietnamFileName, mitchellFileName};

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) throws BrowserNotSupport {
	driver = getBrowserDriver(browserName, appUrl);
	
	homePage = pageObjUploadFiles.PageGeneratorManagerJQuery.getHomePage(driver);
	
  }
  
  @Test
  public void Upload_01_One_File_Per_Time() {
	// Step1 : Load Single File
	homePage.uploadMultiFiles(driver, indonesiaFileName);
	
	// Step2: Verify single file loaded success
	Assert.assertTrue(homePage.isFileLoadedByName(indonesiaFileName));
	
	// Step3: Click to Start button
	homePage.clickToStartButton();
	
	// Step4: Verify single file link uploaded success
	Assert.assertTrue(homePage.isFileLinksUpLoadedByName(indonesiaFileName));
	
	// Step5: Verify single file image uploaded success
	Assert.assertTrue(homePage.isFileImageUpLoadedByName(indonesiaFileName));
  }
  
  @Test
  public void Upload_02_Multi_Files_Per_Time() {
	 homePage.refreshPage(driver);
	// Step1 : Load Multi File
	homePage.uploadMultiFiles(driver, multiFiles);
		
	// Step2: Verify single file loaded success
	// indonesiaFileName, thaiLandFileName, vietnamFileName, mitchellFileName
	Assert.assertTrue(homePage.isFileLoadedByName(indonesiaFileName));
	Assert.assertTrue(homePage.isFileLoadedByName(thaiLandFileName));
	Assert.assertTrue(homePage.isFileLoadedByName(vietnamFileName));
	Assert.assertTrue(homePage.isFileLoadedByName(mitchellFileName));
		
	// Step3: Click to Start button
	homePage.clickToStartButton();
		
	// Step4: Verify single file link uploaded success
	Assert.assertTrue(homePage.isFileLinksUpLoadedByName(indonesiaFileName));
	Assert.assertTrue(homePage.isFileLinksUpLoadedByName(thaiLandFileName));
	Assert.assertTrue(homePage.isFileLinksUpLoadedByName(vietnamFileName));
	Assert.assertTrue(homePage.isFileLinksUpLoadedByName(mitchellFileName));
		
	// Step5: Verify single file image uploaded success
	Assert.assertTrue(homePage.isFileImageUpLoadedByName(indonesiaFileName));
	Assert.assertTrue(homePage.isFileImageUpLoadedByName(thaiLandFileName));
	Assert.assertTrue(homePage.isFileImageUpLoadedByName(vietnamFileName));
	Assert.assertTrue(homePage.isFileImageUpLoadedByName(mitchellFileName));
	  
		
  }
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
//  //Jquery check textcontent
//  var element = $$("div.validation-summary-errors")[0];
//  element.textContent;
 private WebDriver driver;
 private pageObjUploadFiles.HomePageObj homePage;

}