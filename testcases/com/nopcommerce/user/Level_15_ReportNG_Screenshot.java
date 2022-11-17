package com.nopcommerce.user;

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
import pageObject.nopCommerce.user.UserAddressPageObj;
import pageObject.nopCommerce.user.UserCustomerInforPageObj;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserLoginPageObj;
import pageObject.nopCommerce.user.UserMyProductReviewPageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;
import pageObject.nopCommerce.user.UserRewardPointPageObj;

public class Level_15_ReportNG_Screenshot extends BaseTestJquery  {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws BrowserNotSupport {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getUserHomePage(driver);
	
	firstName = "Thanh";
	lastName = "Nguyen";
	email = "abc" + generateRandom() + "@mail.com";
	passWord = "123456";	
  }
  
  @Test
  public void User_01_Register() {
	  	log.info("Register - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 02: Input FirstName to required field '" + firstName +"'" );
		registerPage.inputToFirstnameTextBox(firstName);
		
		log.info("Register - Step 03: Input LastName to required field '" + lastName +"'" );
		registerPage.inputToLastnameTextBox(lastName);
		
		log.info("Register - Step 04: Input Email to required field '" + email +"'" );
		registerPage.inputToEmailTextBox(email);
		
		log.info("Register - Step 05: Input Password to required field '" + passWord +"'" );
		registerPage.inputToPasswordTextBox(passWord);
		
		log.info("Register - Step 06: Input Confirm Password to required field '" + passWord +"'" );
		registerPage.inputToConfirmPasswordTextBox(passWord);
		
		log.info("Register - Step 07: Click to Register Button");
		registerPage.clickToRegisterBtn();
		
		log.info("Register - Step 08: Verify Register Success Message");
		Assert.assertEquals(registerPage.getSuccessRegisterSucces(), "Your registration completed");
		
		log.info("Register - Step 09: Click to Logout Button");
		homePage = registerPage.clickToLogoutBtn();
 }
  @Test
  public void User_02_Login() {
	    log.info("Login - Step 01: Navigate to Login Button");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Input Not Found Email to Email Textbox '" + email +"'" );
		loginPage.inputEmail(email);
		
		log.info("Login - Step 03:  Input Password TextBox '" + passWord +"'" );
		loginPage.inputPassWordTextBox(passWord);
		
		log.info("Login - Step 04:  Click to Login Button");
		homePage = loginPage.clickToLoginBtn();
		
		log.info("Login - Step 05:  Verify Login Success");
		Assert.assertTrue(homePage.myAccountIsDisplayed());
		Assert.assertTrue(homePage.logOutLinkIsDisplayed());
		
		log.info("Login - Step 06: Navigate to MyAccoutLink");
		customerInforPage = homePage.clickToMyAccoutLink();
		
		log.info("Login - Step 07: Verify Login Success");
		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
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