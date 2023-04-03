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
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;
import pageUIs.wordpress.AdminPostSeachPageUI;



public class Post_01_Create_Read_Update_Delete extends BaseTestJquery  {
	
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
	public void beforeClass(String browserName, String adminURL, String endUserURL) {
		
	  log.info("Precondition - Step 01: Open Browser and adminUrl");
	  
	  this.adminURL = adminURL;
	  
	  this.endUserURL = endUserURL;
	
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
  public void Post_01_Create_New_Post() {
	  log.info("Create_Post - Step 01: Click to 'Posts' menu Link");
	  adminPostSeachPage= adminDashboardPage.clickToPostMenuLink();
	  
	  log.info("Create_Post - Step 02: Get 'Search Post' Page URL");
	  searchPostUrl = adminPostSeachPage.getPageURL(driver);
	  
	  log.info("Create_Post - Step 02: Click to 'Add New' button");
	  adminPostAddNewPage = adminPostSeachPage.clickToAddNewBtn();
	  
	  log.info("Create_Post - Step 03: Enter to post title"); 
	  adminPostAddNewPage.enterToPostTitle(postTitle);
	  
	  log.info("Create_Post - Step 04: Enter to body");
	  adminPostAddNewPage.enterToPostBody(postBody);
	  
	  log.info("Create_Post - Step 05: Click to 'Publish' button");
	  adminPostAddNewPage.clickToPublishBtn();
	  
	  log.info("Create_Post - Step 07: Click to 'Publish Verify'button"); 
	  adminPostAddNewPage.clicktoPublishBtnConfirm();
	  
	  log.info("Create_Post - Step 08: Verify 'Post published' message is displayed"); 
	  verifyTrue(adminPostAddNewPage.isPostPublishMessDisplayed("Post published."));
 }
  @Test
  public void Post_02_Search_And_View_Post() {
	  log.info("Search_Post - Step 01: Open 'Search Post' page");
	  adminPostSeachPage =  adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
	  
	  log.info("Search_Post - Step 02: Enter to searh textbox");
	  adminPostSeachPage.enterToSearchTextBox(postTitle);
	  
	  log.info("Search_Post - Step 03: Click to 'Search Posts' button");
	  adminPostSeachPage.clickToSearchPostsButton();
	  
	  log.info("Search_Post - Step 04: Verify Search Table contain '" + postTitle + "'" );
	  verifyTrue(adminPostSeachPage.isPostSearchTableDisplayed("Title",postTitle));
	  log.info("Search_Post - Step 05: Verify Search Table contain  '" + authorName + "'" );
	  verifyTrue(adminPostSeachPage.isPostSearchTableDisplayed("Author" ,authorName));
	  
	  log.info("Search_Post - Step 06: Open End User site");
	  userHomePage = adminPostSeachPage.openEndUserSite(this.endUserURL);
	  
	  log.info("Search_Post - Step 07: Verify Post Title displayed at Home Page");
	  verifyTrue(userHomePage.isPostInforDisplayed(postTitle));
	  verifyTrue(userHomePage.isPostInforDisplayed(postBody));
	  verifyTrue(userHomePage.isPostInforDisplayed(authorName));
	  verifyTrue(userHomePage.isPostInforDisplayed(currentDay));
	  
	  log.info("Search_Post - Step 08: Click to Post Title");
	  userHomePage.clicktoPostTitlte(postTitle);
	  
	  log.info("Search_Post - Step 09: Verify Post infor displayed at Post detail page");
	  verifyTrue(userPostDetailPage.isPostInforDisplayed(postTitle));
	  verifyTrue(userPostDetailPage.isPostInforDisplayed(postBody));
	  verifyTrue(userPostDetailPage.isPostInforDisplayed(authorName));
	  verifyTrue(userPostDetailPage.isPostInforDisplayed(authorName));
	  
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
  UserHomePO userHomePage;
  UserPostDetailPO userPostDetailPage;
}