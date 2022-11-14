package com.facebook.register;

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
import pageObject.facebook.LoginPageObj;
import pageUI.Jquery.HomePageUI;

public class Level_13_Element_Undisplayed extends BaseTestJquery  {
	

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) throws BrowserNotSupport {
	driver = getBrowserDriver(browserName, appUrl);
	
	loginPage = pageObject.facebook.PageGeneratorManager.getLoginPage(driver);
  }
  
  @Test
  public void TC_01_Verify_Element_Displayed() {
	loginPage.clickToCreateNewAccountButton();
	
	verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
  }
  
  @Test
  public void TC_02_Verify_Element_Undisplayed_In_DOM() {

  }
  
  @Test
  public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {

  }
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
//  //Jquery check textcontent
//  var element = $$("div.validation-summary-errors")[0];
//  element.textContent;
 private WebDriver driver;
 private LoginPageObj loginPage;

}