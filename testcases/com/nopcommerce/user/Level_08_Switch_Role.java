package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import common.PageGeneratorManager;
import exception.BrowserNotSupport;
import pageObject.nopCommerce.admin.AdminDashboardPageObj;
import pageObject.nopCommerce.admin.AdminLoginPageObj;
import pageObject.nopCommerce.user.UserAddressPageObj;
import pageObject.nopCommerce.user.UserCustomerInforPageObj;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserLoginPageObj;
import pageObject.nopCommerce.user.UserMyProductReviewPageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;
import pageObject.nopCommerce.user.UserRewardPointPageObj;

public class Level_08_Switch_Role extends BaseTest  {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws BrowserNotSupport {
	driver = getBrowserDriver(browserName);
	userHomePage = PageGeneratorManager.getUserHomePage(driver);
	
	userEmail = "thanhnguyen@gmail.com";
	userPassword = "123456";
	adminEmail = "admin@yourstore.com";
	adminPassword = "admin";
  }
  
  @Test
  public void Role_01_User_To_Admin() {
	  userLoginPage = userHomePage.clickToLoginLink();
	  
	  //Login as user role
	  userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);
	  	  
	  Assert.assertTrue(userHomePage.myAccountIsDisplayed());
	  Assert.assertTrue(userHomePage.logOutLinkIsDisplayed());
	  
	  //HomePage -> My Account Page
	  userMyAccPage = userHomePage.clickToMyAccoutLink();
	  
	  //My Account -> HomePage
	  userHomePage = userMyAccPage.clickToLogoutBtnUser(driver);
	  
	  //HomePage -> Open admin page -> Login Page(Admin)
	  userHomePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
	  adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	  
	  //Login as Admin role
	  adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
	  
	  Assert.assertTrue(adminDashboardPage.isDashBoardDisplayed());
	  
	  //Dashboard Page -> click Logout -> Login Page(Admin)
	  adminLoginPage = adminDashboardPage.clickToLogoutBtnAdmin(driver);
  }
  
  @Test
  public void Role_02_Admin_To_User() {	
	  //LoginPage(Admin) -> HomePage(User)
	  adminLoginPage.openPageURL(driver, GlobalConstants.PORTAL_PAGE_URL);
	  
	  userHomePage = PageGeneratorManager.getUserHomePage(driver);
	  
	  //HomePage(User) -> LoginPage(User)
	  userLoginPage = userHomePage.clickToLoginLink();
	  
	  //Login as user role
	  userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);
	  
	  Assert.assertTrue(userHomePage.myAccountIsDisplayed());
	  Assert.assertTrue(userHomePage.logOutLinkIsDisplayed());
  }  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
//  //Jquery check textcontent
//  var element = $$("div.validation-summary-errors")[0];
//  element.textContent;
 private WebDriver driver;
 private UserHomePageObj userHomePage;
 private UserLoginPageObj userLoginPage;
 private UserCustomerInforPageObj userMyAccPage;
 private AdminLoginPageObj adminLoginPage;
 private AdminDashboardPageObj adminDashboardPage;
 private String userEmail, userPassword , adminEmail, adminPassword;
 
}