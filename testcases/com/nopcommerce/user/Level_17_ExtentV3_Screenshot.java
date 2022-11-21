//package com.nopcommerce.user;
//
//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import common.BaseTest;
//import common.PageGeneratorManager;
//import commonJquery.BaseTestJquery;
//import exception.BrowserNotSupport;
//import pageObject.nopCommerce.user.UserAddressPageObj;
//import pageObject.nopCommerce.user.UserCustomerInforPageObj;
//import pageObject.nopCommerce.user.UserHomePageObj;
//import pageObject.nopCommerce.user.UserLoginPageObj;
//import pageObject.nopCommerce.user.UserMyProductReviewPageObj;
//import pageObject.nopCommerce.user.UserRegisterPageObj;
//import pageObject.nopCommerce.user.UserRewardPointPageObj;
//import reportConfig.ExtentManager;
//
//public class Level_16_ExtentV2_Screenshot extends BaseTestJquery  {
//
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) throws BrowserNotSupport {
//	driver = getBrowserDriver(browserName);
//	homePage = PageGeneratorManager.getUserHomePage(driver);
//	
//	firstName = "Thanh";
//	lastName = "Nguyen";
//	email = "abc" + generateRandom() + "@mail.com";
//	passWord = "123456";	
//  }
//  
//  @Test
//  public void User_01_Register(Method method) {
//	  	ExtentManager.startTest(method.getName(), "User_01_Register");
//	  	ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Click to Register link");
//		registerPage = homePage.clickToRegisterLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Input FirstName to required field '" + firstName +"'" );
//		registerPage.inputToFirstnameTextBox(firstName);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Input LastName to required field '" + lastName +"'" );
//		registerPage.inputToLastnameTextBox(lastName);
//		
//		log.info("Register - Step 04: Input Email to required field '" + email +"'" );
//		registerPage.inputToEmailTextBox(email);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Input Password to required field '" + passWord +"'" );
//		registerPage.inputToPasswordTextBox(passWord);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Input Confirm Password to required field '" + passWord +"'" );
//		registerPage.inputToConfirmPasswordTextBox(passWord);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to Register Button");
//		registerPage.clickToRegisterBtn();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify Register Success Message");
//		Assert.assertEquals(registerPage.getSuccessRegisterSucces(), "Your registration completed");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 09: Click to Logout Button");
//		homePage = registerPage.clickToLogoutBtn();
//		ExtentManager.endTest();
// }
//  @Test
//  public void User_02_Login(Method method) {
//	  ExtentManager.startTest(method.getName(), "User_02_Login");
//	    ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to Login Button");
//		loginPage = homePage.clickToLoginLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Input Not Found Email to Email Textbox '" + email +"'" );
//		loginPage.inputEmail(email);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03:  Input Password TextBox '" + passWord +"'" );
//		loginPage.inputPassWordTextBox(passWord);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04:  Click to Login Button");
//		homePage = loginPage.clickToLoginBtn();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05:  Verify Login Success");
//		Assert.assertTrue(homePage.myAccountIsDisplayed());
//		Assert.assertTrue(homePage.logOutLinkIsDisplayed());
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to MyAccoutLink");
//		customerInforPage = homePage.clickToMyAccoutLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify Login Success");
//		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
//		ExtentManager.endTest();
//  }
//  @AfterClass
//  public void afterClass() {
//	  driver.quit();
//  }
//  
////  //Jquery check textcontent
////  var element = $$("div.validation-summary-errors")[0];
////  element.textContent;
// private WebDriver driver;
// private UserHomePageObj homePage;
// private UserRegisterPageObj registerPage;
// private UserLoginPageObj loginPage;
// private UserAddressPageObj addressPage;
// private UserRewardPointPageObj rewardPage;
// private UserMyProductReviewPageObj myProductPage;
// private UserCustomerInforPageObj customerInforPage;
// private String firstName, lastName, email, passWord;
//}