package pageObject;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObj extends BasePage {
	private WebDriver driver;
	
	public HomePageObj(WebDriver driver) {
		this.driver = driver ;
	}
	
	public void clickToRegisterLink(){
		waitForElementClickAble(driver, HomePageUI.REGISTER_BTN);
		clickToElementByXpath(driver, HomePageUI.REGISTER_BTN);
		
	}

	public void clickToLoginLink() {
		waitForElementClickAble(driver, HomePageUI.LOGIN_BTN);
		clickToElementByXpath(driver, HomePageUI.LOGIN_BTN);
		
	}

	public boolean myAccountIsDisplayed() {
		waitForElementClickAble(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean logOutLinkIsDisplayed() {
		waitForElementClickAble(driver, HomePageUI.LOG_OUT_LINK);
		return isElementDisplay(driver, HomePageUI.LOG_OUT_LINK);
	}




}
