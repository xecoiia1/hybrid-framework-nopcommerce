package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;
import common.BasePageFactory;
import pageUI.nopCommerce.user.LoginPageUI;
import pageUI.nopCommerce.user.RegisterPageUI;

import org.openqa.selenium.WebDriver;

public class UserLoginPageObjPageFactory extends BasePageFactory {
	private WebDriver driver;

	public UserLoginPageObjPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//UI
	@FindBy(xpath = "//button[@class = 'button-1 login-button']")
	private WebElement loginBtn;
	
	@FindBy(id = "Email")
	private WebElement emailTextBox;
	
	@FindBy(id = "Password")
	private WebElement pwdTextBox;
	
	@FindBy(xpath = "//span[@id = 'Email-error']")
	private WebElement emailErrorMes;
	
	@FindBy(xpath = "//div[@class = 'message-error validation-summary-errors']")
	private WebElement emailNotFoundText;
	
	//Actions
	public String getErrorMesAtEmailTextBox() {
		waitForElementVisible(driver, emailErrorMes);
		return getTextOfElement(driver, emailErrorMes);
	}

	public void clickToLoginBtn() {
		waitForElementClickAble(driver, loginBtn);
		clickToElement(driver, loginBtn);
		
	}

	public void inputInvalidEmail(String invalidEmail) {
		waitForElementVisible(driver, emailTextBox);
		sendkeysToElement(driver, emailTextBox, invalidEmail);
		
	}
	
	public String getInvalidErrorMesAtEmailTextBox() {
		waitForElementVisible(driver, emailErrorMes);
		return getTextOfElement(driver, emailErrorMes);
	}

	public void inputNotFoundEmail(String notFoundEmail) {
		waitForElementVisible(driver, emailTextBox);
		sendkeysToElement(driver, emailTextBox, notFoundEmail);
		
	}

	public String getErrorNotFoundEmail() {
		waitForElementVisible(driver, emailNotFoundText);
		return getTextOfElement(driver, emailNotFoundText);
	}

	public void inputPassWordTextBox(String Password) {
		waitForElementVisible(driver, pwdTextBox);
		sendkeysToElement(driver, pwdTextBox, Password);
		
	}
}

