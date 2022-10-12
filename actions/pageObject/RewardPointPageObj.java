package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import common.BasePage;
import pageUI.HomePageUI;
import pageUI.CustomerInforPageUI;

import org.openqa.selenium.WebDriver;

public class RewardPointPageObj extends BasePage {
	private WebDriver driver;
	
	public RewardPointPageObj(WebDriver driver) {
		this.driver = driver ;
	}
}
