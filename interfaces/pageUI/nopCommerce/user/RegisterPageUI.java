package pageUI.nopCommerce.user;

public class RegisterPageUI {
	public static final String FISRT_NAME_TEXTBOX = "xpath=//input[@id = 'FirstName']";
	public static final String LAST_NAME_TEXTBOX = "xpath=//input[@id = 'LastName']";
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id = 'Email']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@id = 'Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "xpath=//input[@id = 'ConfirmPassword']";
	public static final String REGISTER_BTN = "xpath=//button[@id= 'register-button']";
	public static final String FIRST_NAME_ERROR_MES = "xpath=//span[@id = 'FirstName-error']";
	public static final String LAST_NAME_ERROR_MES = "xpath=//span[@id = 'LastName-error']";
	public static final String EMAIL_ERROR_MES = "xpath=//span[@id = 'Email-error']";
	public static final String PASSWORD_ERROR_MES = "xpath=//span[@id = 'Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MES = "xpath=//span[@id = 'ConfirmPassword-error']";
	public static final String WRONG_EMAIL_MES = "xpath=//span[@id = 'Email-error']";
	public static final String REGISTER_SUCCESS_MES = "xpath=//div[@class = 'result']";
	public static final String LOGOUT_BTN = "xpath=//a[@class= 'ico-logout']";
	public static final String EMAIL_EXIST_ERROR_MES = "xpath=//div[contains(@class, 'message-error')]//li";
	public static final String PASSWORD_WRONG_RULE_MES = "xpath=//span[@id = 'Password-error']";
	public static final String CONFIRM_PASSWORD_NOT_MATCH_MES = "xpath=//span[@id = 'ConfirmPassword-error']";
}
