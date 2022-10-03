package com.nopcommerce.user;

import org.testng.annotations.Test;

import pageObject.HomePageObj;
import pageObject.LoginPageObj;
import pageObject.RegisterPageObj;
import pageUI.HomePageUI;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

// Sử dụng extend để kế thừa các hàm từ BasePage mà không cần khai báo
public class Level_03_User_02_Login_Use_Page_Obj  {

  @BeforeClass
  public void beforeClass() {
	System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://demo.nopcommerce.com/");
	
	firstName = "Thanh";
	lastName = "Nguyen";
	existingEmail = "abc" + generateRandom() + "@mail.com";
	invalidEmail ="adb@adc@dd";
	notFoundEmail = "Blag@gmail.com";
	passWord = "123456";
	
	registerPage = new RegisterPageObj(driver);
	
	System.out.println("Precondition_01 - Step 01: Click to Register link");
	homePage.clickToRegisterLink();
	  
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
	registerPage.clickToLogoutBtn();
	
	homePage = new HomePageObj(driver);
  }
  
  @Test
  public void Login_01_Empty_Data() {
	  System.out.println("Login_01 - Step 01: Click to Login Link");
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObj(driver);
	  
	  System.out.println("Login_01 - Step 02: Click to Login Button");
	  loginPage.clickToLoginBtn();
	  
	  System.out.println("Login_01 - Step 03: Verify Email Text Error");
	  Assert.assertEquals(loginPage.getErrorMesAtEmailTextBox(), "Please enter your email");
  }
  
  @Test
  public void Login_02_Invalid_Email() {
	  System.out.println("Login_02 - Step 01: Click to Login Link");
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObj(driver);
	  
	  System.out.println("Login_02 - Step 02: Input Invalid Email to Email Textbox");
	  loginPage.inputInvalidEmail(invalidEmail);
	  
	  System.out.println("Login_02 - Step 03: Click to Login Button");
	  loginPage.clickToLoginBtn();
	  
	  System.out.println("Login_02 - Step 04: Verify Email Text Error");
	  Assert.assertEquals(loginPage.getErrorMesAtEmailTextBox(), "Wrong email");
  }
  
  @Test
  public void Login_03_Not_Found_Email() {
	  System.out.println("Login_02 - Step 01: Click to Login Link");
	  homePage.clickToLoginLink();
  }
  
  @Test
  public void Login_04_Existing_Email() {

  }
  
  @Test
  public void Login_05_Password_Less_Than_6_Chars() {

  }
  
  @Test
  public void Login_06_Invalid_Confirm_Password(){

	  
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
 private HomePageObj homePage;
 private RegisterPageObj registerPage;
 private LoginPageObj loginPage;
 private String projectPath = System.getProperty("user.dir");
 private String firstName, lastName, existingEmail, invalidEmail, notFoundEmail, passWord;
}