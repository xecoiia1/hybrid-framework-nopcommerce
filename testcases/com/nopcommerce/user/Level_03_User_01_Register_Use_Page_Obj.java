package com.nopcommerce.user;

import org.testng.annotations.Test;

import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserLoginPageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

// Sử dụng extend để kế thừa các hàm từ BasePage mà không cần khai báo
public class Level_03_User_01_Register_Use_Page_Obj  {

  @BeforeClass
  public void beforeClass() {
	System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://demo.nopcommerce.com/");
	
	firstName = "Thanh";
	lastName = "Nguyen";
	emailAdd = "abc" + generateRandom() + "@mail.com";
	passWord = "123456";
	
	homePage = new UserHomePageObj(driver);
	registerPage = new UserRegisterPageObj(driver);
  }
  
  @Test
  public void Register_01_Empty_Data() {
	  System.out.println("Register_01 - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register_01 - Step 02: Click to Register Button");
	  registerPage.clickToRegisterBtn();
	  
	  System.out.println("Register_01 - Step 03: Verify Error Message");
	  Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTestBox(), "First name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtLastNameTestBox(), "Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTestBox(), "Email is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTestBox(), "Password is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTestBox(), "Password is required.");
	  
  }
  
  @Test
  public void Register_02_Invalid_Email() {
	  System.out.println("Register_02 - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	 
	  System.out.println("Register_02 - Step 02: Input Text to required field");
	  registerPage.inputToFirstnameTextBox(firstName);
	  registerPage.inputToLastnameTextBox(lastName);
	  registerPage.inputToEmailTextBox("blahbla");
	  registerPage.inputToPasswordTextBox(passWord);
	  registerPage.inputToConfirmPasswordTextBox(passWord);
	  
	  System.out.println("Register_02 - Step 03: Click to Register Button");
	  registerPage.clickToRegisterBtn();
	  
	  System.out.println("Register_02 - Step 04: Verify Error Message");
	  Assert.assertEquals(registerPage.getErrorMessageWrongAtEmailTestBox(), "Wrong email");
  }
  
  @Test
  public void Register_03_Success_Register() {
	  System.out.println("Register_03 - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register_03 - Step 02: Input Text to required field");
	  registerPage.inputToFirstnameTextBox(firstName);
	  registerPage.inputToLastnameTextBox(lastName);
	  registerPage.inputToEmailTextBox(emailAdd);
	  registerPage.inputToPasswordTextBox(passWord);
	  registerPage.inputToConfirmPasswordTextBox(passWord);
	  
	  System.out.println("Register_03 - Step 03: Click to Register Button");
	  registerPage.clickToRegisterBtn();
	  
	  System.out.println("Register_03 - Step 04: Verify Register Success Message");
	  Assert.assertEquals(registerPage.getSuccessRegisterSucces(), "Your registration completed");
	  
	  System.out.println("Register_03 - Step 05: Click to Logout Button");
	  registerPage.clickToLogoutBtn();
  }
  
  @Test
  public void Register_04_Existing_Email() {
	  System.out.println("Register_04 - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register_04 - Step 02: Input Text to required field");
	  registerPage.inputToFirstnameTextBox(firstName);
	  registerPage.inputToLastnameTextBox(lastName);
	  registerPage.inputToEmailTextBox(emailAdd);
	  registerPage.inputToPasswordTextBox(passWord);
	  registerPage.inputToConfirmPasswordTextBox(passWord);
	  
	  System.out.println("Register_04 - Step 03: Click to Register Button");
	  registerPage.clickToRegisterBtn();
	  
	  System.out.println("Register_04 - Step 04: Verify Email Exist Message");
	  Assert.assertEquals(registerPage.getEmailExitstsMessage(), "The specified email already exists");
  }
  
  @Test
  public void Register_05_Password_Less_Than_6_Chars() {
	  System.out.println("Register_05 - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register_05 - Step 02: Input Text to required field");
	  registerPage.inputToFirstnameTextBox(firstName);
	  registerPage.inputToLastnameTextBox(lastName);
	  registerPage.inputToEmailTextBox(emailAdd);
	  registerPage.inputToPasswordTextBox("123");
	  registerPage.inputToConfirmPasswordTextBox("123");
	  
	  System.out.println("Register_05 - Step 03: Click to Register Button");
	  registerPage.clickToRegisterBtn();
	  
	  System.out.println("Register_05 - Step 04: Verify Password Wrong Rule Message");
	  Assert.assertEquals(registerPage.getPasswordWrongRuleMessage(), "Password must meet the following rules:\\nmust have at least 6 characters");
  }
  
  @Test
  public void Register_06_Invalid_Confirm_Password(){
	  System.out.println("Register_06 - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register_06 - Step 02: Input Text to required field");
	  registerPage.inputToFirstnameTextBox(firstName);
	  registerPage.inputToLastnameTextBox(lastName);
	  registerPage.inputToEmailTextBox(emailAdd);
	  registerPage.inputToPasswordTextBox(passWord);
	  registerPage.inputToConfirmPasswordTextBox(passWord + "123");
	  
	  System.out.println("Register_06 - Step 03: Click to Register Button");
	  registerPage.clickToRegisterBtn();
	  
	  System.out.println("Register_06 - Step 04: Verify Confirm Password Not Match Message");
	  Assert.assertEquals(registerPage.getConfirmPasswordNotMatchMessage(), "Password must meet the following rules:\\nmust have at least 6 characters");
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int generateRandom() {
	  Random rand = new Random();
	  return rand.nextInt(9999);
  }
//  //Jquery check textcontent
//  var element = $$("div.validation-summary-errors")[0];
//  element.textContent;
 private WebDriver driver;
 private UserHomePageObj homePage;
 private UserRegisterPageObj registerPage;
 private UserLoginPageObj loginPage;
 private String projectPath = System.getProperty("user.dir");
 private String firstName, lastName, emailAdd, passWord;
}