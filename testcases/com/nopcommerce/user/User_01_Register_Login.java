package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login {
  WebDriver driver;
  String projectPath = System.getProperty("user.dir");

  @BeforeClass
  public void beforeClass() {
	System.getProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	driver = new FirefoxDriver();
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.get("https://demo.nopcommerce.com/");
  }
  
  @Test
  public void TC_01_Register_Empty_Data() {
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
  }
  
  @Test
  public void TC_03_Register_Success() {
  }
  
  @Test
  public void TC_04_Register_Existing_Email() {
  }
  
  @Test
  public void TC_05_Register_Password_Less_Than_6_Chars() {
  }
  
  @Test
  public void TC_06_Register_Invalid_Confirm_Password(){
  }

  @AfterClass
  public void afterClass() {
  }

}
