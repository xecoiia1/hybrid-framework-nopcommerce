package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import common.PageGeneratorManager;
import commonJquery.BaseTestJquery;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserLoginPageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;


public class Common_01_Cookies extends BaseTestJquery  {

  @Parameters("browser")
  @BeforeTest(description = "Create new common User for all class Test")
  public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Thanh";
		lastName = "Nguyen";
		email = "abc" + generateRandom() + "@mail.com";
		password = "123456";
	  	
	  	log.info("Pre-Condition - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Pre-Condition - Step 02: Input FirstName to required field '" + firstName +"'" );
		registerPage.inputToFirstnameTextBox(firstName);
		
		log.info("Pre-Condition - Step 03: Input LastName to required field '" + lastName +"'" );
		registerPage.inputToLastnameTextBox(lastName);
		
		log.info("Pre-Condition - Step 04: Input Email to required field '" + email +"'" );
		registerPage.inputToEmailTextBox(email);
		
		log.info("Pre-Condition - Step 05: Input Password to required field '" + password +"'" );
		registerPage.inputToPasswordTextBox(password);
		
		log.info("Pre-Condition - Step 06: Input Confirm Password to required field '" + password +"'" );
		registerPage.inputToConfirmPasswordTextBox(password);
		
		log.info("Pre-Condition - Step 07: Click to Register Button");
		registerPage.clickToRegisterBtn();
		
		log.info("Pre-Condition - Step 08: Verify Register Success Message");
		verifyEquals(registerPage.getSuccessRegisterSucces(), "Your registration completed");
		
		log.info("Pre-Condition - Step 09: Click to Logout Button");
		homePage = registerPage.clickToLogoutBtn();
		
		log.info("Pre-condition - Step 10: Navigate to Login Button");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Pre-condition - Step 11: Input to Email Textbox '" + email +"'" );
		loginPage.inputEmail(email);
		
		log.info("Pre-condition - Step 12:  Input Password TextBox '" + password +"'" );
		loginPage.inputPassWordTextBox(password);
		
		log.info("Pre-condition - Step 13:  Click to Login Button");
		homePage = loginPage.clickToLoginBtn();
		
		loggedCookies = homePage.getAllCookies(driver);
		
}
  
  
  @AfterTest
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
 private String firstName, lastName, email, password;
 public static Set<Cookie> loggedCookies;
}