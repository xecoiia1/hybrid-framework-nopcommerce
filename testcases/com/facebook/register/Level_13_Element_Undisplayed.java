package com.facebook.register;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonJquery.BaseTestJquery;
import exception.BrowserNotSupport;
import pageObject.facebook.LoginPageObj;


public class Level_13_Element_Undisplayed extends BaseTestJquery  {
	

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) throws BrowserNotSupport {
	driver = getBrowserDriver(browserName, appUrl);
	
	loginPage = pageObject.facebook.PageGeneratorManager.getLoginPage(driver);
  }
  
  @Test
  public void TC_01_Verify_Element_Displayed() {
	loginPage.clickToCreateNewAccountButton();
	
	// Nếu 1 hàm chỉ mong đợi để verify element displayed thôi - kết hợp cả wait + isDisplayed
	// waitForElementVisible
	// isElementDisplayed
    // Verify True - mong đợi Confirm Email displayed
	 loginPage.enterToEmailaddressTextBox("t12345567@gmail.com");
	 loginPage.sleepInSecond(3);
	 verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
	 
  }
  
  @Test
  public void TC_02_Verify_Element_Undisplayed_In_DOM() {
	  //Nếu như mình mong đợi 1 hàm vừa verify displayed/ undisplayed thì không được kết hợp wait
	  	  
	 // Verify False - mong đợi Confirm Email Undisplayed 
	 loginPage.enterToEmailaddressTextBox("");
	 loginPage.sleepInSecond(3);
	 //verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
	 verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
  }
  
  @Test
  public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
	  loginPage.clickCloseIconAtRegisterForm();
	  loginPage.sleepInSecond(3);   
	  
	  // Hàm isDisplayed không kiểm tra 1 element không có trong DOM
	  // Khi close cái form register đi thì Confirm Email không còn trong DOM nữa
	  
	  //verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
	  
	  verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	  
  }
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
//  //Jquery check textcontent
//  var element = $$("div.validation-summary-errors")[0];
//  element.textContent;
 private WebDriver driver;
 private LoginPageObj loginPage;

}