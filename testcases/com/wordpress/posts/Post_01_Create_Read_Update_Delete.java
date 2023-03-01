package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonJquery.BaseTestJquery;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostSearchPO;
import pageObjects.wordpress.admin.PageGeneratorManager;
import pageUIs.wordpress.admin.AdminPostSeachPageUI;



public class Post_01_Create_Read_Update_Delete extends BaseTestJquery  {
	
	String adminUser = "automationfc";
	String adminPassword = "automationfc";
	String searchPostUrl;
	String postTitleValue = "";
	String postBodyValue = "";
	
	@Parameters({"browser", "adminUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		
	  log.info("Precondition - Step 01: Open Browser and adminUrl");
	
	  driver = getBrowserDriverAppURL(browserName, adminUrl);
	
	  adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	
	  log.info("Precondition - Step 02: Enter to Username textbox with value: " + adminUser);
	  
	  adminLoginPage.enterUsernameTextBox(adminUser);
	
	  log.info("Precondition - Step 03: Enter to Password textbox with value: " + adminPassword);
	  
	  adminLoginPage.enterPasswordTextBox(adminPassword);
	 
	  log.info("Precondition - Step 04: Click to Login button ");
	  
	  adminDashboardPage = adminLoginPage.clickToLoginBtn();
	
  }
  
  @Test
  public void Post_01_Create_New_Post() {
	  log.info("Create_Post - Step 01: Click to 'Posts' menu Link");
	  
	  adminPostSeachPage= adminDashboardPage.clickToPostMenuLink();
	  
	  log.info("Create_Post - Step 02: Get 'Search Post' Page URL");
	  searchPostUrl = adminPostSeachPage.getPageURL(driver);
	  
	  log.info("Create_Post - Step 02: Click to 'Add New' button");
	  adminPostAddNewPage = adminPostSeachPage.clickToAddNewBtn();
	  
	  log.info("Create_Post - Step 03: Enter to post title"); 
	  
	  adminPostAddNewPage.enterToPostTitle(postTitleValue);
	  
	  log.info("Create_Post - Step 04: Enter to body");
	  
	  adminPostAddNewPage.enterToPostBody(postBodyValue);
	  
	  log.info("Create_Post - Step 05: Click to 'Publish' button");
	  
	  adminPostAddNewPage.clickToPublishBtn();
	  
	  log.info("Create_Post - Step 06: Verify 'Post published' message is displayed"); 
	  
	  adminPostAddNewPage.isPostPublishMessDisplayed("Post published.");
 }
  @Test
  public void Post_02_Search_Post() {
	  log.info("Search_Post - Step 01: Open 'Search Post' page");
	  
	  adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
	  
	  adminPostSeachPage = PageGeneratorManager.getAdminPostSeachPage(driver);
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
  
  WebDriver driver;
  AdminLoginPO adminLoginPage;
  AdminDashboardPO adminDashboardPage;
  AdminPostSearchPO adminPostSeachPage;
  AdminPostAddNewPO adminPostAddNewPage;
}