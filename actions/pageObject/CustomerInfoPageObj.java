package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import common.BasePage;
import pageUI.HomePageUI;
import pageUI.CustomerInfoPageUI;

import org.openqa.selenium.WebDriver;

public class CustomerInfoPageObj extends BasePage {
	private WebDriver driver;
	
	public CustomerInfoPageObj(WebDriver driver) {
		this.driver = driver ;
	}
		
	public void clickToNewLetter() {
		waitForElementClickAble(driver, CustomerInfoPageUI.NEWLETTER_CHECKBOX);
		clickToElementByXpath(driver, CustomerInfoPageUI.NEWLETTER_CHECKBOX);
	}
}
