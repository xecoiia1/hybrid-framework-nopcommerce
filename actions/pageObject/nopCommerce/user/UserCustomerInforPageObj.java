package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import common.BasePage;
import pageUI.nopCommerce.user.CustomerInforPageUI;
import pageUI.nopCommerce.user.HomePageUI;

import org.openqa.selenium.WebDriver;

public class UserCustomerInforPageObj extends BasePage {
	private WebDriver driver;
	
	public UserCustomerInforPageObj(WebDriver driver) {
		this.driver = driver ;
	}
		
	public void clickToNewLetter() {
		waitForElementClickAble(driver, CustomerInforPageUI.NEWLETTER_CHECKBOX);
		clickToElementByXpath(driver, CustomerInforPageUI.NEWLETTER_CHECKBOX);
	}
	
	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplay(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}

	public UserAddressPageObj openAddressPage(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserRewardPointPageObj openRewardPage(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserHomePageObj clickToLogoutBtnUser(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}
}
