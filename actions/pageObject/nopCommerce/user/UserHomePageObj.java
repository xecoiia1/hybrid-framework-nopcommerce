package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import common.BasePage;
import common.PageGeneratorManager;
import commonJquery.BasePageJquery;
import io.qameta.allure.Step;
import pageUI.nopCommerce.user.HomePageUI;

import org.openqa.selenium.WebDriver;

public class UserHomePageObj extends BasePageJquery {
	private WebDriver driver;
	
	public UserHomePageObj(WebDriver driver) {
		this.driver = driver ;
	}
	
	@Step("Navigate to Register Page")
	public UserRegisterPageObj clickToRegisterLink(){
		System.out.println(HomePageUI.REGISTER_BTN);
		waitForElementClickAble(driver, HomePageUI.REGISTER_BTN);
		clickToElementByXpath(driver, HomePageUI.REGISTER_BTN);
		return PageGeneratorManager.getUserRegisterPage(driver);
		}
	@Step("Navigate to Login Page")
	public UserLoginPageObj clickToLoginLink() {
		waitForElementClickAble(driver, HomePageUI.LOGIN_BTN);
		clickToElementByXpath(driver, HomePageUI.LOGIN_BTN);
		return PageGeneratorManager.getUserLoginPage(driver);
		
	}
	@Step("Verify My Account Page is Displayed")
	public boolean myAccountIsDisplayed() {
		waitForElementClickAble(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
	@Step("Verify Logout Page is Displayed")
	public boolean logOutLinkIsDisplayed() {
		waitForElementClickAble(driver, HomePageUI.LOG_OUT_LINK);
		return isElementDisplay(driver, HomePageUI.LOG_OUT_LINK);
	}
	
	@Step("Navigate to MyAccount Page")
	public UserCustomerInforPageObj clickToMyAccoutLink() {
		waitForElementClickAble(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElementByXpath(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserMyAccountPage(driver);
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[@class= 'ico-register']")
	private WebElement registerLink;
	
	@FindBy(using = "//a[@class = 'ico-login']")
	private WebElement loginLink;

	private WebElement myAccountLink;;
}
