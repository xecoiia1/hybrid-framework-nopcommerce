package pageObject.nopCommerce.portal;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	
	
	public static HomePageObj getHomePage(WebDriver driver) {
		return new HomePageObj(driver);
	}
	
	public static LoginPageObj getLoginPage(WebDriver driver) {
		return new LoginPageObj(driver);
	}
	
	public static RegisterPageObj getRegisterPage(WebDriver driver) {
		return new RegisterPageObj(driver);
	}
		
	public static CustomerInforPageObj getCustomerInfor(WebDriver driver) {
		return new CustomerInforPageObj(driver);
	}
	
	public static AddressPageObj getAddressPage(WebDriver driver) {
		return new AddressPageObj(driver);
	}
	
	public static RewardPointPageObj getRewardPage(WebDriver driver) {
		return new RewardPointPageObj(driver);
	}
	
	public static MyProductReviewPageObj getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObj(driver);
	}

	public static CustomerInforPageObj getMyAccountPage(WebDriver driver) {
		return new CustomerInforPageObj(driver);
	}




	
	
}
