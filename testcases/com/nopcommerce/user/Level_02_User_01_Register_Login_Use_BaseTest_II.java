package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_User_01_Register_Login_Use_BaseTest_II {
  WebDriver driver;
  String projectPath = System.getProperty("user.dir");
  BasePage basePage;
  String emailAdd;

  @BeforeClass
  public void beforeClass() {
	System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	
	driver = new FirefoxDriver();
	
	// Che giấu đi việc khởi tạo của 1 đối tượng
	basePage = BasePage.getBasePageObj();
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.get("https://demo.nopcommerce.com/");
	
	emailAdd = "abc" + generateRandom() + "@mail.com";
  }
  
  @Test
  public void TC_01_Register_Empty_Data() {
	  basePage.waitForElementClickAble(driver, "//a[@class= 'ico-register']");
	  basePage.clickToElementByXpath(driver, "//a[@class= 'ico-register']");
	  
	  basePage.waitForElementClickAble(driver, "//button[@id= 'register-button']");
	  basePage.clickToElementByXpath(driver, "//button[@id= 'register-button']");
	  
	  basePage.getTextOfElement(driver, "//span[@id = 'FirstName-error']");
	  
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id = 'FirstName-error']"), "First name is required.");
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id = 'LastName-error']"), "Last name is required.");
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id = 'Email-error']"), "Email is required.");
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id = 'Password-error']"), "Password is required.");
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id = 'ConfirmPassword-error']"), "Password is required.");
	  
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  
	  basePage.waitForElementClickAble(driver, "//a[@class= 'ico-register']");
	  basePage.clickToElementByXpath(driver, "//a[@class= 'ico-register']");
	 
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'FirstName']", "Thanh");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'LastName']", "Nguyen");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'Email']", "blahbla");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'Password']", "123456");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'ConfirmPassword']", "123456");
	  
	  basePage.waitForElementClickAble(driver, "//button[@id= 'register-button']");
	  basePage.clickToElementByXpath(driver, "//button[@id= 'register-button']");
	  
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id = 'Email-error']"), "Wrong email");
  }
  
  @Test
  public void TC_03_Register_Success() {
	  basePage.waitForElementClickAble(driver, "//a[@class= 'ico-register']");
	  basePage.clickToElementByXpath(driver, "//a[@class= 'ico-register']");
	  
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'FirstName']", "Thanh");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'LastName']", "Nguyen");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'Email']", emailAdd);
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'Password']", "123456");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'ConfirmPassword']", "123456");
	  
	  basePage.waitForElementClickAble(driver, "//button[@id= 'register-button']");
	  basePage.clickToElementByXpath(driver, "//button[@id= 'register-button']");
	  
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//div[@class = 'result']"), "Your registration completed");
	  
	  basePage.waitForElementClickAble(driver, "//a[@class= 'ico-logout']");
	  basePage.clickToElementByXpath(driver, "//a[@class= 'ico-logout']");
  }
  
  @Test
  public void TC_04_Register_Existing_Email() {
	  basePage.waitForElementClickAble(driver, "//a[@class= 'ico-register']");
	  basePage.clickToElementByXpath(driver, "//a[@class= 'ico-register']");
	  
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'FirstName']", "Thanh");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'LastName']", "Nguyen");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'Email']", emailAdd);
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'Password']", "123456");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'ConfirmPassword']", "123456");
	  
	  basePage.waitForElementClickAble(driver, "//button[@id= 'register-button']");
	  basePage.clickToElementByXpath(driver, "//button[@id= 'register-button']");
	  
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//div[contains(@class, 'message-error')]//li"), "The specified email already exists");
  }
  
  @Test
  public void TC_05_Register_Password_Less_Than_6_Chars() {
	  basePage.waitForElementClickAble(driver, "//a[@class= 'ico-register']");
	  basePage.clickToElementByXpath(driver, "//a[@class= 'ico-register']");
	  
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'FirstName']", "Thanh");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'LastName']", "Nguyen");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'Email']", emailAdd);
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'Password']", "123");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'ConfirmPassword']", "123");
	  
	  basePage.waitForElementClickAble(driver, "//button[@id= 'register-button']");
	  basePage.clickToElementByXpath(driver, "//button[@id= 'register-button']");
	  
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id = 'Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
  }
  
  @Test
  public void TC_06_Register_Invalid_Confirm_Password(){
	  basePage.waitForElementClickAble(driver, "//a[@class= 'ico-register']");
	  basePage.clickToElementByXpath(driver, "//a[@class= 'ico-register']");
	  
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'FirstName']", "Thanh");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'LastName']", "Nguyen");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'Email']", emailAdd);
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'Password']", "123456");
	  basePage.sendkeysToElementByXpath(driver, "//input[@id = 'ConfirmPassword']", "123567");
	  
	  basePage.waitForElementClickAble(driver, "//button[@id= 'register-button']");
	  basePage.clickToElementByXpath(driver, "//button[@id= 'register-button']");
	  
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id = 'ConfirmPassword-error']"), "The password and confirmation password do not match.");
	  
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
}