package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BasePage;
import pageObject.HomePageObj;
import pageObject.RegisterPageObj;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

// Sử dụng extend để kế thừa các hàm từ BasePage mà không cần khai báo
public class Level_03_User_01_Register_Login_Use_Page_Obj extends BasePage {
  WebDriver driver;
  String projectPath = System.getProperty("user.dir");
  String emailAdd;

  @BeforeClass
  public void beforeClass() {
	System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	
	driver = new FirefoxDriver();
		
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.get("https://demo.nopcommerce.com/");
	
	emailAdd = "abc" + generateRandom() + "@mail.com";
  }
  
  @Test
  public void TC_01_Register_Empty_Data() {
	  waitForElementClickAble(driver, "//a[@class= 'ico-register']");
	  clickToElementByXpath(driver, "//a[@class= 'ico-register']");
	  System.out.println("Home Page-Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  waitForElementClickAble(driver, "//button[@id= 'register-button']");
	  clickToElementByXpath(driver, "//button[@id= 'register-button']");
	  System.out.println("Register Page-Step 02: Click to Register Button");
	  registerPage.clickToRegisterBtn();
	  
	  
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id = 'FirstName-error']"), "First name is required.");
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id = 'LastName-error']"), "Last name is required.");
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id = 'Email-error']"), "Email is required.");
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id = 'Password-error']"), "Password is required.");
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id = 'ConfirmPassword-error']"), "Password is required.");
	  System.out.println("Register Page-Step 03: Verify Error Message");
	  Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTestBox, "First name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtLastNameTestBox, "Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTestBox, "Email is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTestBox, "Password is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTestBox, "Password is required.");
	  
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  
	  waitForElementClickAble(driver, "//a[@class= 'ico-register']");
	  clickToElementByXpath(driver, "//a[@class= 'ico-register']");
	  System.out.println("Home Page-Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	 
	  sendkeysToElementByXpath(driver, "//input[@id = 'FirstName']", "Thanh");
	  sendkeysToElementByXpath(driver, "//input[@id = 'LastName']", "Nguyen");
	  sendkeysToElementByXpath(driver, "//input[@id = 'Email']", "blahbla");
	  sendkeysToElementByXpath(driver, "//input[@id = 'Password']", "123456");
	  sendkeysToElementByXpath(driver, "//input[@id = 'ConfirmPassword']", "123456");
	  System.out.println("Register Page-Step 02: Input Text to required field");
	  registerPage.inputToFirstnameTextBox("Thanh");
	  registerPage.inputToLastnameTextBox("Nguyen");
	  registerPage.inputToEmailTextBox("blahbla");
	  registerPage.inputToPasswordTextBox("123456");
	  registerPage.inputToConfirmPasswordTextBox("123456");
	  
	  waitForElementClickAble(driver, "//button[@id= 'register-button']");
	  clickToElementByXpath(driver, "//button[@id= 'register-button']");
	  System.out.println("Register Page-Step 03: Click to Register Button");
	  registerPage.clickToRegisterBtn();
	  
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id = 'Email-error']"), "Wrong email");
	  System.out.println("Register Page-Step 04: Verify Error Message");
	  Assert.assertEquals(registerPage.getErrorMessageWrongAtEmailTestBox, "Wrong email");
  }
  
  @Test
  public void TC_03_Register_Success() {
	  waitForElementClickAble(driver, "//a[@class= 'ico-register']");
	  clickToElementByXpath(driver, "//a[@class= 'ico-register']");
	  System.out.println("Home Page-Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  sendkeysToElementByXpath(driver, "//input[@id = 'FirstName']", "Thanh");
	  sendkeysToElementByXpath(driver, "//input[@id = 'LastName']", "Nguyen");
	  sendkeysToElementByXpath(driver, "//input[@id = 'Email']", emailAdd);
	  sendkeysToElementByXpath(driver, "//input[@id = 'Password']", "123456");
	  sendkeysToElementByXpath(driver, "//input[@id = 'ConfirmPassword']", "123456");
	  System.out.println("Register Page-Step 02: Input Text to required field");
	  registerPage.inputToFirstnameTextBox("Thanh");
	  registerPage.inputToLastnameTextBox("Nguyen");
	  registerPage.inputToEmailTextBox(emailAdd);
	  registerPage.inputToPasswordTextBox("123456");
	  registerPage.inputToConfirmPasswordTextBox("123456");
	  
	  waitForElementClickAble(driver, "//button[@id= 'register-button']");
	  clickToElementByXpath(driver, "//button[@id= 'register-button']");
	  System.out.println("Register Page-Step 03: Click to Register Button");
	  registerPage.clickToRegisterBtn();
	  
	  Assert.assertEquals(getTextOfElement(driver, "//div[@class = 'result']"), "Your registration completed");
	  System.out.println("Register Page-Step 04: Verify Register Success Message");
	  Assert.assertEquals(registerPage.getSuccessRegisterSucces, "Your registration completed");
	  
	  waitForElementClickAble(driver, "//a[@class= 'ico-logout']");
	  clickToElementByXpath(driver, "//a[@class= 'ico-logout']");
	  System.out.println("Register Page-Step 05: Click to Logout Button");
	  registerPage.clickToLogoutBtn();
  }
  
  @Test
  public void TC_04_Register_Existing_Email() {
	  waitForElementClickAble(driver, "//a[@class= 'ico-register']");
	  clickToElementByXpath(driver, "//a[@class= 'ico-register']");
	  System.out.println("Home Page-Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  sendkeysToElementByXpath(driver, "//input[@id = 'FirstName']", "Thanh");
	  sendkeysToElementByXpath(driver, "//input[@id = 'LastName']", "Nguyen");
	  sendkeysToElementByXpath(driver, "//input[@id = 'Email']", emailAdd);
	  sendkeysToElementByXpath(driver, "//input[@id = 'Password']", "123456");
	  sendkeysToElementByXpath(driver, "//input[@id = 'ConfirmPassword']", "123456");
	  System.out.println("Register Page-Step 02: Input Text to required field");
	  registerPage.inputToFirstnameTextBox("Thanh");
	  registerPage.inputToLastnameTextBox("Nguyen");
	  registerPage.inputToEmailTextBox(emailAdd);
	  registerPage.inputToPasswordTextBox("123456");
	  registerPage.inputToConfirmPasswordTextBox("123456");
	  
	  waitForElementClickAble(driver, "//button[@id= 'register-button']");
	  clickToElementByXpath(driver, "//button[@id= 'register-button']");
	  System.out.println("Register Page-Step 03: Click to Register Button");
	  registerPage.clickToRegisterBtn();
	  
	  Assert.assertEquals(getTextOfElement(driver, "//div[contains(@class, 'message-error')]//li"), "The specified email already exists");
	  System.out.println("Register Page-Step 04: Verify Email Exist Message");
	  Assert.assertEquals(registerPage.getEmailExitstsMessage, "The specified email already exists");
  }
  
  @Test
  public void TC_05_Register_Password_Less_Than_6_Chars() {
	  waitForElementClickAble(driver, "//a[@class= 'ico-register']");
	  clickToElementByXpath(driver, "//a[@class= 'ico-register']");
	  System.out.println("Home Page-Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  sendkeysToElementByXpath(driver, "//input[@id = 'FirstName']", "Thanh");
	  sendkeysToElementByXpath(driver, "//input[@id = 'LastName']", "Nguyen");
	  sendkeysToElementByXpath(driver, "//input[@id = 'Email']", emailAdd);
	  sendkeysToElementByXpath(driver, "//input[@id = 'Password']", "123");
	  sendkeysToElementByXpath(driver, "//input[@id = 'ConfirmPassword']", "123");
	  System.out.println("Register Page-Step 02: Input Text to required field");
	  registerPage.inputToFirstnameTextBox("Thanh");
	  registerPage.inputToLastnameTextBox("Nguyen");
	  registerPage.inputToEmailTextBox(emailAdd);
	  registerPage.inputToPasswordTextBox("123");
	  registerPage.inputToConfirmPasswordTextBox("123");
	  
	  waitForElementClickAble(driver, "//button[@id= 'register-button']");
	  clickToElementByXpath(driver, "//button[@id= 'register-button']");
	  System.out.println("Register Page-Step 03: Click to Register Button");
	  registerPage.clickToRegisterBtn();
	  
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id = 'Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
	  System.out.println("Register Page-Step 04: Verify Password Wrong Rule Message");
	  Assert.assertEquals(registerPage.getPasswordWrongRuleMessage, "Password must meet the following rules:\\nmust have at least 6 characters");
  }
  
  @Test
  public void TC_06_Register_Invalid_Confirm_Password(){
	  waitForElementClickAble(driver, "//a[@class= 'ico-register']");
	  clickToElementByXpath(driver, "//a[@class= 'ico-register']");
	  System.out.println("Home Page-Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  sendkeysToElementByXpath(driver, "//input[@id = 'FirstName']", "Thanh");
	  sendkeysToElementByXpath(driver, "//input[@id = 'LastName']", "Nguyen");
	  sendkeysToElementByXpath(driver, "//input[@id = 'Email']", emailAdd);
	  sendkeysToElementByXpath(driver, "//input[@id = 'Password']", "123456");
	  sendkeysToElementByXpath(driver, "//input[@id = 'ConfirmPassword']", "123567");
	  System.out.println("Register Page-Step 02: Input Text to required field");
	  registerPage.inputToFirstnameTextBox("Thanh");
	  registerPage.inputToLastnameTextBox("Nguyen");
	  registerPage.inputToEmailTextBox(emailAdd);
	  registerPage.inputToPasswordTextBox("123456");
	  registerPage.inputToConfirmPasswordTextBox("123567");
	  
	  waitForElementClickAble(driver, "//button[@id= 'register-button']");
	  clickToElementByXpath(driver, "//button[@id= 'register-button']");
	  System.out.println("Register Page-Step 03: Click to Register Button");
	  registerPage.clickToRegisterBtn();
	  
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id = 'ConfirmPassword-error']"), "The password and confirmation password do not match.");
	  System.out.println("Register Page-Step 04: Verify Confirm Password Not Match Message");
	  Assert.assertEquals(registerPage.getConfirmPasswordNotMatchMessage, "The password and confirmation password do not match.");
	  
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
  
  HomePageObj homePage;
  RegisterPageObj registerPage;
}