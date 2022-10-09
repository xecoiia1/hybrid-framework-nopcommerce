package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;
import common.BasePageFactory;
import pageUI.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObjPageFactory extends BasePageFactory {
	private WebDriver driver;
	
	public HomePageObjPageFactory(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	

	
	//PageUI
	@FindBy(how = How.XPATH, using = "//a[@class= 'ico-register']")
	private WebElement registerLink;
	
	@FindBy(using = "//a[@class = 'ico-login']")
	private WebElement loginLink;
	 
	@FindBy(using = "//a[@class = 'ico-account']")
	private WebElement myAccountLink;;


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


}
