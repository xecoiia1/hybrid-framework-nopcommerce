package pageObject;

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
	
	public static MyAccountPageObj getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObj(driver);
	}
	
}
