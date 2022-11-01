package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import exception.BrowserNotSupport;
import pageObject.nopCommerce.user.UserAddressPageObj;
import pageObject.nopCommerce.user.UserCustomerInforPageObj;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserLoginPageObj;
import pageObject.nopCommerce.user.UserMyProductReviewPageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;
import pageObject.nopCommerce.user.UserRewardPointPageObj;

public class Level_07_Switch_Page extends BaseTest  {

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
		System.out.println("Precondition_01 - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		  
	    System.out.println("Precondition_01 - Step 02: Input Text to required field");
		registerPage.inputToFirstnameTextBox(firstName);
		registerPage.inputToLastnameTextBox(lastName);
		registerPage.inputToEmailTextBox(email);
		registerPage.inputToPasswordTextBox(passWord);
		registerPage.inputToConfirmPasswordTextBox(passWord);
		  
		System.out.println("Precondition_01 - Step 03: Click to Register Button");
		registerPage.clickToRegisterBtn();
		  
		System.out.println("Precondition_01 - Step 04: Verify Register Success Message");
		Assert.assertEquals(registerPage.getSuccessRegisterSucces(), "Your registration completed");
		
		System.out.println("Precondition_01 - Step 05: Click to Logout Button");
		homePage = registerPage.clickToLogoutBtn();
  }
  
  @Test
  public void User_02_Login() {	  
	  loginPage = homePage.clickToLoginLink();
	  
	  System.out.println("Login_06 - Step 02: Input Not Found Email to Email Textbox");
	  loginPage.inputEmail(email);
	  
	  System.out.println("Login_06 - Step 03: Input Password TextBox");
	  loginPage.inputPassWordTextBox(passWord);
	  
	  System.out.println("Login_06 - Step 04: Click to Login Button");
	  homePage = loginPage.clickToLoginBtn();
	  
	  System.out.println("Login_06 - Step 05: Verify Login Success");
	  
	  Assert.assertTrue(homePage.myAccountIsDisplayed());
	  Assert.assertTrue(homePage.logOutLinkIsDisplayed());
	  
  }
  
  @Test
  public void User_03_Customer_Infor() {
	  customerInforPage = homePage.clickToMyAccoutLink();
	  
	  Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
  }
  
  @Test
  public void User_04_Switch_Page() {
	  addressPage = customerInforPage.openAddressPage(driver);
	  
	  rewardPage = addressPage.openRewardPage(driver);
	  
	  myProductPage = rewardPage.openMyProductReviewPage(driver);
	  
	  customerInforPage = myProductPage.openCustomerInforPage(driver);
	  
	  rewardPage = customerInforPage.openRewardPage(driver);
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