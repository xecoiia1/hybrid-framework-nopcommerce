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

public class Level_09_Dynamic_Locator extends BaseTest  {

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
  public void User_01_Register_Login() {
		System.out.println("Register_Login_01 - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		  
	    System.out.println("Register_Login_01 - Step 02: Input Text to required field");
		registerPage.inputToFirstnameTextBox(firstName);
		registerPage.inputToLastnameTextBox(lastName);
		registerPage.inputToEmailTextBox(email);
		registerPage.inputToPasswordTextBox(passWord);
		registerPage.inputToConfirmPasswordTextBox(passWord);
		  
		System.out.println("Register_Login_01 - Step 03: Click to Register Button");
		registerPage.clickToRegisterBtn();
		  
		System.out.println("Register_Login_01 - Step 04: Verify Register Success Message");
		Assert.assertEquals(registerPage.getSuccessRegisterSucces(), "Your registration completed");
		
		System.out.println("Register_Login_01 - Step 05: Click to Logout Button");
		homePage = registerPage.clickToLogoutBtn();
		
		loginPage = homePage.clickToLoginLink();
		  
		System.out.println("Register_Login_01 - Step 06: Input Not Found Email to Email Textbox");
		loginPage.inputEmail(email);
		  
		System.out.println("Register_Login_01 - Step 08: Input Password TextBox");
		loginPage.inputPassWordTextBox(passWord);
		  
		System.out.println("Register_Login_01 - Step 09: Click to Login Button");
		homePage = loginPage.clickToLoginBtn();
		  
		System.out.println("Register_Login_01 - Step 09: Verify Login Success");
		  
		Assert.assertTrue(homePage.myAccountIsDisplayed());
		Assert.assertTrue(homePage.logOutLinkIsDisplayed());
		  
		customerInforPage = homePage.clickToMyAccoutLink();
		  
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
  }
    
  @Test
  public void User_02_Switch_Page() {
	  addressPage = customerInforPage.openAddressPage(driver);
	  
	  rewardPage = addressPage.openRewardPage(driver);
	  
	  myProductPage = rewardPage.openMyProductReviewPage(driver);
	  
	  customerInforPage = myProductPage.openCustomerInforPage(driver);
	  
	  rewardPage = customerInforPage.openRewardPage(driver);
  }
  
  @Test
  public void User_03_Dynamic_Page_01() {	  
	  rewardPage = (UserRewardPointPageObj) myProductPage.openPagesAtMyAccountByName(driver, "Reward points");
	  
	  addressPage = (UserAddressPageObj) rewardPage.openPagesAtMyAccountByName(driver, "Addresses");
	  
	  customerInforPage = (UserCustomerInforPageObj) addressPage.openPagesAtMyAccountByName(driver, "Customer info");
	  
  }
  
  @Test
  public void User_04_Dynamic_Page_02() {	  
	  customerInforPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
	  myProductPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
	  
	  myProductPage.openPagesAtMyAccountByPageName(driver, "Reward points");
	  rewardPage = PageGeneratorManager.getUserRewardPage(driver);
	  
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