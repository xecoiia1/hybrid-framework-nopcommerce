package com.nopcommerce.user;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Cookies;
import com.nopcommerce.common.Common_01_Register_End_User;

import common.BaseTest;
import common.PageGeneratorManager;
import commonJquery.BaseTestJquery;
import exception.BrowserNotSupport;
import pageObject.nopCommerce.user.UserAddressPageObj;
import pageObject.nopCommerce.user.UserCustomerInforPageObj;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserLoginPageObj;
import pageObject.nopCommerce.user.UserMyProductReviewPageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;
import pageObject.nopCommerce.user.UserRewardPointPageObj;

public class Level_19_Share_Data_C extends BaseTestJquery  {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws BrowserNotSupport {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getUserHomePage(driver);
	
	email = Common_01_Register_End_User.email;
	
	password = Common_01_Register_End_User.password;
	
    log.info("Pre-Condition - Step 01: Navigate to Login Button");
	loginPage = homePage.clickToLoginLink();
	
	log.info("Pre-Condition - Step 02: Set Cookies and reload page");
	loginPage.setCookies(driver, Common_01_Cookies.loggedCookies);
	
	loginPage.refreshPage(driver);
	
	log.info("Pre-Condition - Step 03:  Verify Login Success");
	verifyTrue(homePage.myAccountIsDisplayed());
  }
  @Test
  public void Search_01_Empty_Data() {
	    
  }
  
  @Test
  public void Search_02_Relative_Product_Name() {
	    
  }
  
  @Test
  public void Search_03_Absolute_Product_Name() {
	    
  }
  
  @Test
  public void Search_04_Parent_Category() {
	    
  }
  
  @Test
  public void Search_05_Incorect_Manufactorer() {
	    
  }
  
  @Test
  public void Search_06_Corect_Manufactorer() {
	    
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
//  //Jquery check textcontent
//  var element = $$("div.validation-summary-errors")[0];
//  element.textContent;
 private WebDriver driver;
 private UserHomePageObj homePage;
 private UserLoginPageObj loginPage;
 private String email, password;

}