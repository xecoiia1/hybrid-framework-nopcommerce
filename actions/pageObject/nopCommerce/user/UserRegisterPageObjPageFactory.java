package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePageFactory;



public class UserRegisterPageObjPageFactory extends BasePageFactory {

	private WebDriver driver;
	
	public UserRegisterPageObjPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//UI
	@CacheLookup
	@FindBy(id = "FirstName")
	private WebElement firstNameTextBox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextBox;
	
	@FindBy(id = "Email")
	private WebElement emailTextBox;
	
	@FindBy(id = "Password")
	private WebElement pwdTextBox;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPwdTextBox;
	
	@FindBy(id = "register-button")
	private WebElement registerBtn;
	
	@FindBy(id = "FirstName-error")
	private WebElement firstNameErrorMes;
	
	@FindBy(id = "LastName-error")
	private WebElement lastNameErrorMes;
	
	@FindBy(id = "Email-error")
	private WebElement emailErrorMes;
	
	@FindBy(id = "Password-error")
	private WebElement pwdErrorMes;
	
	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPwdErrorMes;
		
	@FindBy(id = "Email-error")
	private WebElement wrongEmailMes;
	
	@FindBy(xpath = "//div[@class = 'result']")
	private WebElement registerSuccessMes;
	
	@FindBy(xpath = "//a[@class= 'ico-logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//div[contains(@class, 'message-error')]//li")
	private WebElement emailExitsErrorMes;
	
	@FindBy(id = "Password-error")
	private WebElement pwdWrongRuleMes;
	
	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPwdNotMathMes;
	
	//Action
	public void clickToRegisterBtn() {
		waitForElementClickAble(driver, registerBtn);
		clickToElement(driver, registerBtn);
	}

	public void inputToFirstnameTextBox(String firtName) {
		waitForElementVisible(driver, firstNameTextBox);
		sendkeysToElement(driver, firstNameTextBox, firtName);
	}

	public void inputToLastnameTextBox(String lastName) {
		waitForElementVisible(driver, lastNameTextBox);
		sendkeysToElement(driver, lastNameTextBox, lastName);
		
	}

	public void inputToEmailTextBox(String emailAdd) {
		waitForElementVisible(driver, emailTextBox);
		sendkeysToElement(driver, emailTextBox, emailAdd);
		
	}

	public void inputToPasswordTextBox(String passWord) {
		waitForElementVisible(driver, pwdTextBox);
		sendkeysToElement(driver, pwdTextBox, passWord);
		
	}

	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(driver, confirmPwdTextBox);
		sendkeysToElement(driver, confirmPwdTextBox, confirmPassword);
		
	}
	
	public String getConfirmPasswordNotMatchMessage() {
		waitForElementVisible(driver, confirmPwdNotMathMes);
		return getTextOfElement(driver, confirmPwdNotMathMes);
	}

	public String getPasswordWrongRuleMessage() {
		waitForElementVisible(driver, pwdWrongRuleMes);
		return getTextOfElement(driver, pwdWrongRuleMes);
	}

	public String getEmailExitstsMessage() {
		waitForElementVisible(driver, emailExitsErrorMes);
		return getTextOfElement(driver, emailExitsErrorMes);
	}

	public void clickToLogoutBtn() {
		waitForElementClickAble(driver, logoutBtn);
		clickToElement(driver, logoutBtn);
		
	}

	public String getSuccessRegisterSucces() {
		waitForElementVisible(driver, registerSuccessMes);
		return getTextOfElement(driver, registerSuccessMes);
	}

	public String getErrorMessageWrongAtEmailTestBox() {
		waitForElementVisible(driver, wrongEmailMes);
		return getTextOfElement(driver, wrongEmailMes);
	}

	public String getErrorMessageAtFirstNameTestBox() {
		waitForElementVisible(driver, firstNameErrorMes);
		return getTextOfElement(driver, firstNameErrorMes);
	}

	public String getErrorMessageAtLastNameTestBox() {
		waitForElementVisible(driver, lastNameErrorMes);
		return getTextOfElement(driver, lastNameErrorMes);
	}

	public String getErrorMessageAtEmailTestBox() {
		waitForElementVisible(driver, emailErrorMes);
		return getTextOfElement(driver, emailErrorMes);
	}

	public String getErrorMessageAtPasswordTestBox() {
		waitForElementVisible(driver, pwdErrorMes);
		return getTextOfElement(driver, pwdErrorMes);
	}

	public String getErrorMessageAtConfirmPasswordTestBox() {
		waitForElementVisible(driver, confirmPwdErrorMes);
		return getTextOfElement(driver, confirmPwdErrorMes);
	}

}
