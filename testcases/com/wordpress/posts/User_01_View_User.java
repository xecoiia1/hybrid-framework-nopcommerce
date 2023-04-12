package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonJquery.BaseTestJquery;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.AdminUserPO;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;
import pageUIs.wordpress.AdminPostSeachPageUI;



public class User_01_View_User extends BaseTestJquery  {
	
	String adminUser = "automationfc";
	String adminPassword = "automationfc";
	String searchPostUrl;
	int randomNumber = generateRandom();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Title " + randomNumber;
	String authorName = "automationfc";
	String adminURL, endUserURL;
	String currentDay = getCurrentDay();
	
	@Parameters({"browser", "adminURL", "userURL"})
	@BeforeClass
	public void beforeClass(String browserName, String adminURL, String userURL) {
		
	  log.info("Precondition - Step 01: Open Browser and adminUrl");
	  
	  this.adminURL = adminURL;
	  
	  this.endUserURL = userURL;
	
	  driver = getBrowserDriverAppURL(browserName, adminURL);
	
	  adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	  
	  log.info("Precondition - Step 02: Enter to Username textbox with value: " + adminUser);
	  adminLoginPage.enterUsernameTextBox(adminUser);
	  
	  log.info("Precondition - Step 03: Enter to Password textbox with value: " + adminPassword);
	  adminLoginPage.enterPasswordTextBox(adminPassword);
	  
	  log.info("Precondition - Step 04: Click to Login button ");
	  adminDashboardPage = adminLoginPage.clickToLoginBtn();
	
  }
	@Test
	public void TC_01_View_User() {
	  log.info("View_User - Step 01:Click to 'User' menu link");
	  adminUserPage = adminDashboardPage.clickToUserMenuLink();
	  
	  log.info("View_User - Step 02: Get all users from UI");
	  int totalNumberUserAtUI = adminUserPage.getUserNumberAtUI();
	  
	  log.info("View_User - Step 03: Get all users from DB");
	  int totalNumberUserAtDB = adminUserPage.getUserNumberAtDB();
	  
	  log.info("View_User - Step 04: Verify the User are matching");
	  verifyEquals(totalNumberUserAtUI, totalNumberUserAtDB);
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
  UserHomePO userHomePage;
  UserPostDetailPO userPostDetailPage;
  AdminUserPO adminUserPage;
}