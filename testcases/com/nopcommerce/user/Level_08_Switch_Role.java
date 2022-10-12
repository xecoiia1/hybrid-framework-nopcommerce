package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObject.AddressPageObj;
import pageObject.CustomerInforPageObj;
import pageObject.HomePageObj;
import pageObject.LoginPageObj;
import pageObject.MyProductReviewPageObj;
import pageObject.PageGeneratorManager;
import pageObject.RegisterPageObj;
import pageObject.RewardPointPageObj;

public class Level_08_Switch_Role extends BaseTest  {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getHomePage(driver);
	
	email = "thanhnguyen@mail.com";
	passWord = "123456";	
  }
  
  @Test
  public void Role_01_User() {
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
  public void Role_02_Admin() {	  

	  
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
 private LoginPageObj loginPage;
 private String email, passWord;
}