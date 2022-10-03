package com.nopcommerce.user;

import org.testng.annotations.Test;

import pageObject.HomePageObj;
import pageObject.RegisterPageObj;

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
	emailAdd = "abc" + generateRandom() + "@mail.com";
	passWord = "123456";
	

  }
  
  @Test
  public void Register_01_Empty_Data() {

  }
  
  @Test
  public void Register_02_Invalid_Email() {

  }
  
  @Test
  public void Register_03_Success_Register() {

  }
  
  @Test
  public void Register_04_Existing_Email() {

  }
  
  @Test
  public void Register_05_Password_Less_Than_6_Chars() {

  }
  
  @Test
  public void Register_06_Invalid_Confirm_Password(){

	  
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
 private String projectPath = System.getProperty("user.dir");
 private String firstName, lastName, emailAdd, passWord;
}