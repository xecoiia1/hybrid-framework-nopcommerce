package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import pageObject.nopCommerce.portal.AddressPageObj;
import pageObject.nopCommerce.portal.CustomerInforPageObj;
import pageObject.nopCommerce.portal.HomePageObj;
import pageObject.nopCommerce.portal.LoginPageObj;
import pageObject.nopCommerce.portal.MyProductReviewPageObj;
import pageObject.nopCommerce.portal.PageGeneratorManager;
import pageObject.nopCommerce.portal.RegisterPageObj;
import pageObject.nopCommerce.portal.RewardPointPageObj;

public class Level_08_Switch_Role extends BaseTest  {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getHomePage(driver);
	
	email = "thanhnguyen@mail.com";
	passWord = "123456";	
  }
  
  @Test
  public void Role_01_User() {
	  loginPage = homePage.clickToLoginLink();
	  
	  //Login as user role
	  homePage = loginPage.loginAsUser(email, passWord);
	  	  
	  Assert.assertTrue(homePage.myAccountIsDisplayed());
	  Assert.assertTrue(homePage.logOutLinkIsDisplayed());
  }
  
  @Test
  public void Role_02_Admin() {	  
	  homePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
	  
	  
	  
  }  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
//  //Jquery check textcontent
//  var element = $$("div.validation-summary-errors")[0];
//  element.textContent;
 private WebDriver driver;
 private HomePageObj homePage;
 private LoginPageObj loginPage;
 private String email, passWord;
}