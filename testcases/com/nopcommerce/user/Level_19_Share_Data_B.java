package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

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

public class Level_19_Share_Data_B extends BaseTestJquery  {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws BrowserNotSupport {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getUserHomePage(driver);
	
	firstName = "Thanh";
	lastName = "Nguyen";
	email = "abc" + generateRandom() + "@mail.com";
	passWord = "123456";
	
	log.info("Pre-condition - Step 01: Click to Register link");
	registerPage = homePage.clickToRegisterLink();
	
	log.info("Pre-condition - Step 02: Input FirstName to required field '" + firstName +"'" );
	registerPage.inputToFirstnameTextBox(firstName);
	
	log.info("Pre-condition - Step 03: Input LastName to required field '" + lastName +"'" );
	registerPage.inputToLastnameTextBox(lastName);
	
	log.info("Pre-condition - Step 04: Input Email to required field '" + email +"'" );
	registerPage.inputToEmailTextBox(email);
	
	log.info("Pre-condition - Step 05: Input Password to required field '" + passWord +"'" );
	registerPage.inputToPasswordTextBox(passWord);
	
	log.info("Pre-condition - Step 06: Input Confirm Password to required field '" + passWord +"'" );
	registerPage.inputToConfirmPasswordTextBox(passWord);
	
	log.info("Pre-condition - Step 07: Click to Register Button");
	registerPage.clickToRegisterBtn();
	
	log.info("Pre-condition - Step 08: Verify Register Success Message");
	verifyEquals(registerPage.getSuccessRegisterSucces(), "Your registration completed");
	
	log.info("Pre-condition - Step 09: Click to Logout Button");
	homePage = registerPage.clickToLogoutBtn();
	
	log.info("Pre-condition - Step 10: Navigate to Login Button");
	loginPage = homePage.clickToLoginLink();
	
	log.info("Pre-condition - Step 11: Input to Email Textbox '" + email +"'" );
	loginPage.inputEmail(email);
	
	log.info("Pre-condition - Step 12:  Input Password TextBox '" + passWord +"'" );
	loginPage.inputPassWordTextBox(passWord);
	
	log.info("Pre-condition - Step 13:  Click to Login Button");
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
  private UserRegisterPageObj registerPage;
  private UserLoginPageObj loginPage;
  private UserAddressPageObj addressPage;
  private UserRewardPointPageObj rewardPage;
  private UserMyProductReviewPageObj myProductPage;
  private UserCustomerInforPageObj customerInforPage;
  private String firstName, lastName, email, passWord;

}