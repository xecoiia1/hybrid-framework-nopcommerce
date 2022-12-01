package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import common.PageGeneratorManager;
import commonJquery.BaseTestJquery;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;


public class Common_01_Register_End_User extends BaseTestJquery  {

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
		
		driver.quit();
 }
  
//  //Jquery check textcontent
//  var element = $$("div.validation-summary-errors")[0];
//  element.textContent;
 private WebDriver driver;
 private UserHomePageObj homePage;
 private UserRegisterPageObj registerPage;
 public static String email, password;
 private String firstName, lastName;
}