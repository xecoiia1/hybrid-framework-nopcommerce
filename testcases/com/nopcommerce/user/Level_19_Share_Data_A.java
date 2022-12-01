package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

public class Level_19_Share_Data_A extends BaseTestJquery  {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws BrowserNotSupport {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getUserHomePage(driver);
	
	email = Common_01_Register_End_User.email;
	
	password = Common_01_Register_End_User.password;
	
    log.info("Login - Step 01: Navigate to Login Button");
	loginPage = homePage.clickToLoginLink();
	
	log.info("Login - Step 02: Input to Email Textbox '" + email +"'" );
	loginPage.inputEmail(email);
	
	log.info("Login - Step 03:  Input Password TextBox '" + password +"'" );
	loginPage.inputPassWordTextBox(password);
	
	log.info("Login - Step 04:  Click to Login Button");
	homePage = loginPage.clickToLoginBtn();
	
	
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