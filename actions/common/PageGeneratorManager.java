package common;

import org.openqa.selenium.WebDriver;

import pageObject.nopCommerce.admin.AdminDashboardPageObj;
import pageObject.nopCommerce.admin.AdminLoginPageObj;
import pageObject.nopCommerce.user.UserAddressPageObj;
import pageObject.nopCommerce.user.UserCustomerInforPageObj;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserLoginPageObj;
import pageObject.nopCommerce.user.UserMyProductReviewPageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;
import pageObject.nopCommerce.user.UserRewardPointPageObj;


public class PageGeneratorManager {
	
	
	public static UserHomePageObj getUserHomePage(WebDriver driver) {
		return new UserHomePageObj(driver);
	}
	
	public static UserLoginPageObj getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObj(driver);
	}
	
	public static UserRegisterPageObj getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObj(driver);
	}
		
	public static UserCustomerInforPageObj getUserCustomerInfor(WebDriver driver) {
		return new UserCustomerInforPageObj(driver);
	}
	
	public static UserAddressPageObj getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObj(driver);
	}
	
	public static UserRewardPointPageObj getUserRewardPage(WebDriver driver) {
		return new UserRewardPointPageObj(driver);
	}
	
	public static UserMyProductReviewPageObj getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObj(driver);
	}

	public static UserCustomerInforPageObj getUserMyAccountPage(WebDriver driver) {
		return new UserCustomerInforPageObj(driver);
	}
	
	public static AdminLoginPageObj getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObj(driver);
	}
	
	public static AdminDashboardPageObj getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObj(driver);
	}
	



	
	
}
