package pageUI.nopCommerce.user;

public class BasePageUI {
	public static final String CUSTOMER_INFO_PAGE = "xpath=//div[@class='listbox']//a[text()='Customer info']";
	public static final String ADDRESS_PAGE = "xpath=//div[@class='listbox']//a[text()='Addresses']";
	public static final String REWARD_POINT_PAGE = "xpath=//div[contains(@class,'account-navigation')]//a[text() = 'Reward points']";
	public static final String MY_PRODUCT_REVIEWS_PAGE = "xpath=//div[@class='listbox']//a[text()='My product reviews']";
	
	
	public static final String LOGOUT_BTN_USER = "xpath=//a[@class = 'ico-logout']";
	public static final String LOGOUT_BTN_ADMIN = "xpath=//a[text()='Logout']";
	
	//Pattern Object
	public static final String DYNAMIC_MY_ACCOUNT_PAGE = "xpath=//div[contains(@class,'account-navigation')]//a[text() = '%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
}
