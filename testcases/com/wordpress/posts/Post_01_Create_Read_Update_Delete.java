package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonJquery.BaseTestJquery;
import exception.BrowserNotSupport;


public class Post_01_Create_Read_Update_Delete extends BaseTestJquery  {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws BrowserNotSupport {
	driver = getBrowserDriver(browserName);
	
  }
  
  @Test
  public void Post_01_Create_New_Post() {
	  log.info("");

 }
  @Test
  public void Post_02_Search_Post() {

  }
  
  @Test
  public void Post_03_View_Post() {

  } 
  @Test
  public void Post_04_Edit_Post() {
	  
  }
  
  @Test
  public void Post_05_Delete_Post() {
	  
  }
  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  closeBrowserAndDriver();
  }
  


}