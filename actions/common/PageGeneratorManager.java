package common;

import org.openqa.selenium.WebDriver;

import pageObject.nopCommerce.user.UserAddressPageObj;
import pageObject.nopCommerce.user.UserCustomerInforPageObj;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserLoginPageObj;
import pageObject.nopCommerce.user.UserMyProductReviewPageObj;
import pageObject.nopCommerce.user.UserRegisterPageObj;
import pageObject.nopCommerce.user.UserRewardPointPageObj;


public class PageGeneratorManager {
	
	
	public static UserHomePageObj getHomePage(WebDriver driver) {
		return new UserHomePageObj(driver);
	}
	
	public static UserLoginPageObj getLoginPage(WebDriver driver) {
		return new UserLoginPageObj(driver);
	}
	
	public static UserRegisterPageObj getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObj(driver);
	}
		
	public static UserCustomerInforPageObj getCustomerInfor(WebDriver driver) {
		return new UserCustomerInforPageObj(driver);
	}
	
	public static UserAddressPageObj getAddressPage(WebDriver driver) {
		return new UserAddressPageObj(driver);
	}
	
	public static UserRewardPointPageObj getRewardPage(WebDriver driver) {
		return new UserRewardPointPageObj(driver);
	}
	
	public static UserMyProductReviewPageObj getMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObj(driver);
	}

	public static UserCustomerInforPageObj getMyAccountPage(WebDriver driver) {
		return new UserCustomerInforPageObj(driver);
	}




	
	
}
