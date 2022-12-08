package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.PageGeneratorManager;
import commonJquery.BaseTestJquery;
import exception.BrowserNotSupport;
import pageObjJquery.PageGeneratorManagerJQuery;
import pageObject.nopCommerce.user.UserAddressPageObj;
import pageObject.nopCommerce.user.UserCustomerInforPageObj;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserLoginPageObj;
import pageObject.nopCommerce.user.UserMyProductReviewPageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;
import pageObject.nopCommerce.user.UserRewardPointPageObj;

public class Level_21_Pattern_Object extends BaseTestJquery  {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws BrowserNotSupport {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getUserHomePage(driver);
	
	firstName = "Thanh";
	lastName = "Nguyen";
	email = "abc" + generateRandom() + "@mail.com";
	passWord = "123456";
	date = "10";
	month = "August";
	year = "1998";
  }
  
  @Test
  public void User_01_Register() {
	  	log.info("Register - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRadioButtonByLabel(driver, "Female");
		
		log.info("Register - Step 02: Input FirstName to required field '" + firstName +"'" );
		//registerPage.inputToFirstnameTextBox(firstName);
		registerPage.inputToTextBoxByID(driver, "FirstName", firstName);
		
		log.info("Register - Step 03: Input LastName to required field '" + lastName +"'" );
		//registerPage.inputToLastnameTextBox(lastName);
		registerPage.inputToTextBoxByID(driver, "LastName", lastName);
		
		registerPage.selectToDropDownByName(driver, "DateOfBirthDay", date);
		registerPage.selectToDropDownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectToDropDownByName(driver, "DateOfBirthYear", year);
		
		log.info("Register - Step 04: Input Email to required field '" + email +"'" );
		//registerPage.inputToEmailTextBox(email);
		registerPage.inputToTextBoxByID(driver, "Email", email);
		
		registerPage.clickToCheckBoxByLabel(driver, "Newsletter");
		
		log.info("Register - Step 05: Input Password to required field '" + passWord +"'" );
		//registerPage.inputToPasswordTextBox(passWord);
		registerPage.inputToTextBoxByID(driver, "Password", passWord);
		
		log.info("Register - Step 06: Input Confirm Password to required field '" + passWord +"'" );
		//registerPage.inputToConfirmPasswordTextBox(passWord);
		registerPage.inputToTextBoxByID(driver, "ConfirmPassword", passWord);
							
		log.info("Register - Step 07: Click to Register Button");
		//registerPage.clickToRegisterBtn();
		registerPage.clickToButtonByText(driver, "Register");
		
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
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
  }
  
  @Test
  public void User_03_My_Account() {
		log.info("My Account - Step 01: Navigate to MyAccoutLink");
		customerInforPage = homePage.clickToMyAccoutLink();
		
		log.info("My Account - Step 02: Verify Login Success");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
		
		log.info("My Account - Step 03: Verify FirstName value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), firstName);
		
		log.info("My Account - Step 04: Verify LastName value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), lastName);
		
		log.info("My Account - Step 05: Verify Email value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), email);
  }
  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  closeBrowserAndDriver();
  }
  
//  //Jquery check textcontent
//  var element = $$("div.validation-summary-errors")[0];
//  element.textContent;
 private WebDriver driver;
 private UserHomePageObj homePage;
 private UserRegisterPageObj registerPage;
 private UserLoginPageObj loginPage;
 private UserCustomerInforPageObj customerInforPage;
 private String firstName, lastName, email, passWord;
 private String date, month, year;
}