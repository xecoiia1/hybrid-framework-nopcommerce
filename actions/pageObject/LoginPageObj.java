package pageObject;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObj {
	private WebDriver driver;

	public LoginPageObj(WebDriver driver) {
		this.driver = driver;
	}

	public String getErrorMesAtEmailTextBox() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickToLoginBtn() {
		wai(driver, LoginPageUI.LOGIN_BTN);
		clickToElementByXpath(driver, LoginPageUI.LOGIN_BTN);
		
	}

}

