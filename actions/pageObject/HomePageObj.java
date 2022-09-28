package pageObject;

import org.openqa.selenium.WebDriver;


public class HomePageObj extends BasePage {
	private WebDriver driver;

	public void clickToRegisterLink(){
		waitForElementClickAble(driver, HomePageUI.REGISTER_BTN);
		clickToElementByXpath(driver, HomePageUI.REGISTER_BTN);
		
	}



}
