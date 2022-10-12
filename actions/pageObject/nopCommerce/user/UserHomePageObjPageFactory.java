package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;
import common.BasePageFactory;
import pageUI.nopCommerce.user.HomePageUI;

import org.openqa.selenium.WebDriver;

public class UserHomePageObjPageFactory extends BasePageFactory {
	private WebDriver driver;
	
	public UserHomePageObjPageFactory(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	

	
	//PageUI
	@FindBy(how = How.XPATH, using = "//a[@class= 'ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[@class = 'ico-login']")
	private WebElement loginLink;
	 
	@FindBy(xpath = "//a[@class = 'ico-account']")
	private WebElement myAccountLink;
	
	@FindBy(xpath = "//a[@class = 'ico-logout']")
	private WebElement logoutLink;;


	//PageObject/ Action
	public void clickToRegisterLink() {
		waitForElementClickAble(driver, registerLink);
		clickToElement(driver, registerLink);
	}
	
	public void clickToLoginLink() {
		waitForElementClickAble(driver, loginLink);
		clickToElement(driver, loginLink);
	}
	
	public void clickToMyAccountLink() {
		waitForElementClickAble(driver, myAccountLink);
		clickToElement(driver, myAccountLink);
	}
	
	public boolean myAccountIsDisplayed() {
		waitForElementClickAble(driver, myAccountLink);
		return isElementDisplay(driver, myAccountLink);
	}

	public boolean logOutLinkIsDisplayed() {
		waitForElementClickAble(driver, logoutLink);
		return isElementDisplay(driver, logoutLink);

	}
}
