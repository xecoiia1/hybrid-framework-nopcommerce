package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import common.BasePage;
import pageUI.HomePageUI;
import pageUI.MyAccountPageUI;

import org.openqa.selenium.WebDriver;

public class MyAccountPageObj extends BasePage {
	private WebDriver driver;
	
	public MyAccountPageObj(WebDriver driver) {
		this.driver = driver ;
	}
		
	public void clickToNewLetter() {
		waitForElementClickAble(driver, MyAccountPageUI.NEWLETTER_CHECKBOX);
		clickToElementByXpath(driver, MyAccountPageUI.NEWLETTER_CHECKBOX);
	}
}
