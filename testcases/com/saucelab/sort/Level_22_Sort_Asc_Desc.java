package com.saucelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.PageGeneratorManager;
import commonJquery.BaseTestJquery;
import exception.BrowserNotSupport;
import pageObjJquery.PageGeneratorManagerJQuery;
import pageObject.nopCommerce.user.UserAddressPageObj;
import pageObject.nopCommerce.user.UserCustomerInforPageObj;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserLoginPageObj;
import pageObject.nopCommerce.user.UserMyProductReviewPageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;
import pageObject.nopCommerce.user.UserRewardPointPageObj;
import pageObject.sauceLab.LoginPageObj;
import pageObject.sauceLab.ProductPageObj;

public class Level_22_Sort_Asc_Desc extends BaseTestJquery  {

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String sauceLabURL)  {
	driver = getBrowserDriver(browserName, sauceLabURL );
	loginPage = pageObject.sauceLab.PageGeneratorManager.getLoginPage(driver);
	
	loginPage.enterToUserNameTextBox("standard_user");
	loginPage.enterToPassWordTextBox("secret_sauce");
	productPage = loginPage.clickLoginBtn();

  }
  
  @Test
  public void Sort_01_Name() {
	productPage.selectItemInProductSortDropdown("Name (A to Z)");
	
	Assert.assertTrue(productPage.isProductNameSortByAscending());
	
	productPage.selectItemInProductSortDropdown("Name (Z to A)");
	
	Assert.assertTrue(productPage.isProductNameSortByDescending());
 }
  @Test
  public void Sort_02_Price() {
	productPage.selectItemInProductSortDropdown("Price (low to high)");
	
	Assert.assertTrue(productPage.isProductPriceSortByAscending());
	
	productPage.selectItemInProductSortDropdown("Price (high to low)");
	
	Assert.assertTrue(productPage.isProductPriceSortByDescending());
  }
  
  @Test
  public void User_03_My_Account() {
		
  }
  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  closeBrowserAndDriver();
  }
  
//  //Jquery check textcontent
//  var element = $$("div.validation-summary-errors")[0];
//  element.textContent;
 private WebDriver driver;

 private LoginPageObj loginPage;
 private ProductPageObj productPage;
}