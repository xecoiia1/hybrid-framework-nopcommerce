package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import common.BasePage;
import common.PageGeneratorManager;
import pageUI.HomePageUI;
import org.openqa.selenium.WebDriver;

public class UserHomePageObj extends BasePage {
	private WebDriver driver;
	
	public UserHomePageObj(WebDriver driver) {
		this.driver = driver ;
	}
	
	public UserRegisterPageObj clickToRegisterLink(){
		waitForElementClickAble(driver, HomePageUI.REGISTER_BTN);
		clickToElementByXpath(driver, HomePageUI.REGISTER_BTN);
		return PageGeneratorManager.getRegisterPage(driver);
		}

	public UserLoginPageObj clickToLoginLink() {
		waitForElementClickAble(driver, HomePageUI.LOGIN_BTN);
		clickToElementByXpath(driver, HomePageUI.LOGIN_BTN);
		return PageGeneratorManager.getLoginPage(driver);
		
	}

	public boolean myAccountIsDisplayed() {
		waitForElementClickAble(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean logOutLinkIsDisplayed() {
		waitForElementClickAble(driver, HomePageUI.LOG_OUT_LINK);
		return isElementDisplay(driver, HomePageUI.LOG_OUT_LINK);
	}
	
	public UserCustomerInforPageObj clickToMyAccoutLink() {
		waitForElementClickAble(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElementByXpath(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[@class= 'ico-register']")
	private WebElement registerLink;
	
	@FindBy(using = "//a[@class = 'ico-login']")
	private WebElement loginLink;

	private WebElement myAccountLink;;
}
