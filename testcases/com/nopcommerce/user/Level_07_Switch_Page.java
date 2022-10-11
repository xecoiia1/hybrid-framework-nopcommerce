package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.HomePageObj;
import pageObject.LoginPageObj;
import pageObject.MyAccountPageObj;
import pageObject.PageGeneratorManager;
import pageObject.RegisterPageObj;
import pageUI.HomePageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

// Sử dụng extend để kế thừa các hàm từ BasePage mà không cần khai báo
public class Level_07_Switch_Page extends BaseTest  {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	
	firstName = "Thanh";
	lastName = "Nguyen";
	existingEmail = "abc" + generateRandom() + "@mail.com";
	invalidEmail ="adb@adc@dd";
	notFoundEmail = "Blag@gmail.com";
	passWord = "123456";
	
	homePage = PageGeneratorManager.getHomePage(driver);
	
	System.out.println("Precondition_01 - Step 01: Click to Register link");
	registerPage = homePage.clickToRegisterLink();
	  
    System.out.println("Precondition_01 - Step 02: Input Text to required field");
	registerPage.inputToFirstnameTextBox(firstName);
	registerPage.inputToLastnameTextBox(lastName);
	registerPage.inputToEmailTextBox(existingEmail);
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
  public void User_01_Register() {
		System.out.println("Precondition_01 - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		  
	    System.out.println("Precondition_01 - Step 02: Input Text to required field");
		registerPage.inputToFirstnameTextBox(firstName);
		registerPage.inputToLastnameTextBox(lastName);
		registerPage.inputToEmailTextBox(existingEmail);
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
	  loginPage.inputNotFoundEmail(existingEmail);
	  
	  System.out.println("Login_06 - Step 03: Input Password TextBox");
	  loginPage.inputPassWordTextBox(passWord);
	  
	  System.out.println("Login_06 - Step 04: Click to Login Button");
	  homePage = loginPage.clickToLoginBtn();
	  
	  System.out.println("Login_06 - Step 05: Verify Login Success");
	  
	  Assert.assertTrue(homePage.myAccountIsDisplayed());
	  Assert.assertTrue(homePage.logOutLinkIsDisplayed());
  }
  
  @Test
  public void User_03_My_Account() {
	  
  }
  
  @Test
  public void User_04_Switch_Page() {
	 
  }
  


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
//  //Jquery check textcontent
//  var element = $$("div.validation-summary-errors")[0];
//  element.textContent;
 private WebDriver driver;
 private HomePageObj homePage;
 private RegisterPageObj registerPage;
 private LoginPageObj loginPage;
 private MyAccountPageObj myAccountPage;
 private String projectPath = System.getProperty("user.dir");
 private String firstName, lastName, existingEmail, invalidEmail, notFoundEmail, passWord;
}