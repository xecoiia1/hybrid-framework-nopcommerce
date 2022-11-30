package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;


import common.PageGeneratorManager;
import commonJquery.BaseTestJquery;
import exception.BrowserNotSupport;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.nopCommerce.user.UserCustomerInforPageObj;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserLoginPageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;

public class Level_18_Allure extends BaseTestJquery  {

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
  
  @Description("Register To System")
  @Severity(SeverityLevel.NORMAL)
  @Test
  public void User_01_Register() {

		registerPage = homePage.clickToRegisterLink();
		

		registerPage.inputToFirstnameTextBox(firstName);
		
	
		registerPage.inputToLastnameTextBox(lastName);
		
		
		registerPage.inputToEmailTextBox(email);
		

		registerPage.inputToPasswordTextBox(passWord);
		

		registerPage.inputToConfirmPasswordTextBox(passWord);
		

		registerPage.clickToRegisterBtn();
		

		Assert.assertEquals(registerPage.getSuccessRegisterSucces(), "Your registration completed");
		

		homePage = registerPage.clickToLogoutBtn();
		
 }
  @Description("Login To System")
  @Severity(SeverityLevel.NORMAL)
  @Test
  public void User_02_Login() {

	  	loginPage = homePage.clickToLoginLink();
		

		loginPage.inputEmail(email);
		

		loginPage.inputPassWordTextBox(passWord);
		

		homePage = loginPage.clickToLoginBtn();
		

		Assert.assertTrue(homePage.myAccountIsDisplayed());
		Assert.assertTrue(homePage.logOutLinkIsDisplayed());
		

		customerInforPage = homePage.clickToMyAccoutLink();
		

		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());

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
 private UserCustomerInforPageObj customerInforPage;
 private String firstName, lastName, email, passWord;
}