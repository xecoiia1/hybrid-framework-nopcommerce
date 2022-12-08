package commonJquery;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjUploadFiles.HomePageObj;
import pageObject.nopCommerce.admin.AdminLoginPageObj;
import pageObject.nopCommerce.user.UserAddressPageObj;
import pageObject.nopCommerce.user.UserCustomerInforPageObj;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserMyProductReviewPageObj;
import pageObject.nopCommerce.user.UserRewardPointPageObj;
import pageUI.Jquery.uploadFile.BasePageJQueryUI;
import pageUI.nopCommerce.user.BasePageUI;
import pageUI.nopCommerce.user.CustomerInforPageUI;
import pageUI.nopCommerce.user.HomePageUI;

//Common class
public class BasePageJquery {
	
	// Che giấu đi việc khởi tạo của 1 đối tượng
	public static BasePageJquery getBasePageObj() {
		return new BasePageJquery();
	}
	
	// Hàm này mở 1 URL
	public void openPageURL(WebDriver driver, String pageURL) {
		driver.get(pageURL);
	}
	
	//Hàm này get pageTitle
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	//Hàm này get pageURL
	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	//Hàm này get pageSourceCode
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	//Các hàm navigate page
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	//Hàm đợi Alert xuất hiện
	public Alert waitForAlertDisplay(WebDriver driver) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		return explixitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	// Accept Alert
	public void acceptAlert(WebDriver driver) {
	    waitForAlertDisplay(driver).accept();
	}
	
	//Switch to Alert
	public void swithToAlert(WebDriver driver) {
		waitForAlertDisplay(driver);
		driver.switchTo().alert().accept();
	}
	
	//Cancel Alert
	public void canceltAlert(WebDriver driver) {
	    waitForAlertDisplay(driver).dismiss();
	}
	
	//Get Alert Text
	public String getAlertText(WebDriver driver) {
	    return waitForAlertDisplay(driver).getText();
	}
	
	//Sendkey to Alert
	public void sendkeyTotAlert(WebDriver driver, String textValue) {
	    waitForAlertDisplay(driver).sendKeys(textValue);
	}
	
	
	// Các hàm của Window
	public void swithToWindowID (WebDriver driver, String parentID) {
		Set <String> allGUID = driver.getWindowHandles();
		for(String id: allGUID) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
			}
		}
	}
	
	public void swithToWindowByTitle (WebDriver driver, String expectedTitle) {
		Set <String> allGUID = driver.getWindowHandles();
		for (String id : allGUID) {
			driver.switchTo().window(id);
			
			String currentPage = driver.getTitle();
			
			if(currentPage.equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent (WebDriver driver, String parentID) {
		Set <String> allGUID = driver.getWindowHandles();
		for (String id : allGUID) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	//Các hàm Element
	
	private By getByXpath(String locatorType) {
		return By.xpath(locatorType);
	}
	
	public By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=")||locatorType.startsWith("ID=")||locatorType.startsWith("Id=")) {
			 by = By.id(locatorType.substring(3));
		}else if(locatorType.startsWith("class=")||locatorType.startsWith("CLASS=")||locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		}else if(locatorType.startsWith("name=")||locatorType.startsWith("NAME=")||locatorType.startsWith("Name=")){
			by = By.name(locatorType.substring(5));
		}else if(locatorType.startsWith("css=")||locatorType.startsWith("CSS=")||locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		}else if(locatorType.startsWith("xpath=")||locatorType.startsWith("XPATH=")||locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		}else {
			throw new RuntimeException("Locator is not supported");
		}
		
		return by;
	}
	
	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}
	
	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}
		
	public void clickToElementByXpath(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}
	
	//Dynamic Locator
	private String getDynamicXpath(String locatorType, String...dynamicValues) {
		if(locatorType.startsWith("xpath=")||locatorType.startsWith("XPATH=")||locatorType.startsWith("Xpath=")) {
		locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;
	}
	
	//Dynamic Locator
	public void clickToElement(WebDriver driver, String locatorType, String...dynamicValues) {
		 getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}
	
	public void sendkeysToElementByXpath(WebDriver driver, String locatorType, String textValue ) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void sendkeysToElementByXpath(WebDriver driver, String locatorType, String textValue, String...dynamicValues ) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}
	
	public String getTextOfElement(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}
	
	public String getTextOfElement(WebDriver driver, String locatorType, String...dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}
    
	public void selectItemDefaulDropDown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}
	
	public void selectItemDefaulDropDown(WebDriver driver, String locatorType, String textItem, String...dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}
	
	
	public String getSelectedItem(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}
	
	public Boolean isDropDownMulti(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}
	
	public void selectitemCustomDropDown(WebDriver driver, String parentLocator , String childLocator, String expectedTextItem) {
		
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);

		clickToElementByXpath(driver, parentLocator);
		
		//explixitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));
		
		List<WebElement> allDropDownItems = explixitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
		
		for (WebElement item: allDropDownItems) {
				    if (item.getText().trim().equals(expectedTextItem)) {
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
					sleepInSecond(3);
					item.click();
					break;
				}
		}
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
}

	public String getElementAttribute(WebDriver driver, String locatorType, String name) {
		return getWebElement(driver, locatorType).getAttribute(name);
	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String name, String...dynamicLocator) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicLocator)).getAttribute(name);
	}
	
	public String getElementCssValue(WebDriver driver, String locatorType, String cssValue) {
		return getWebElement(driver, locatorType).getCssValue(cssValue);
	}

	public String getoHexColorFromRgba(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}
	
	public int getElementSize(WebDriver driver, String locatorType, String...dynamicLocator) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicLocator)).size();
	}

	public void checkToDefaultCheckBoxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToDefaultCheckBoxRadio(WebDriver driver, String locatorType, String...dynamicLocator) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicLocator));
		if(!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToDefaultCheckBoxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public void unCheckToDefaultCheckBoxRadio(WebDriver driver, String locatorType, String...dynamicLocator) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicLocator));
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public Boolean isElementDisplay(WebDriver driver, String locatorType) {
		try {
			// Nếu tìm thấy Element:
			// Case 1: Displayed: Trả về True
			// Case 2: Undisplayed: Trả về False
			return getWebElement(driver, locatorType).isDisplayed();
		} catch (NoSuchElementException e) {
			// Case 3: Undisplayed: Trả về false
			return false;
		}
	}
	
	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, shortTimeOut);
		List<WebElement> elements = getListWebElement(driver, locator);
		overrideGlobalTimeout(driver, longTimeOut);
		
		//Case: Element không có trong DOM
		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			return true;
		//Case: Element Có trong DOM nhưng hiển thị/ không hiển thị	
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM");
			return true;
		} else {
			System.out.println("Element in DOM and displayed");
			return false;
		}
	}
	
	public Boolean isElementUnDisplay(WebDriver driver, String locatorType) {
		boolean status = true;
		if(getWebElement(driver, locatorType).isDisplayed()) {
			status = false;
		}
		return status;
	}
	
	public Boolean isElementDisplay(WebDriver driver, String locatorType, String...dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}
	
	public Boolean isElementEnable(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}
	
	public Boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}
	
	public void switchToFrame(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	
	public void switchToDefaultContent(WebDriver driver, String locatorType) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action =new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action =new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String...dynamicValues) {
		Actions action =new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}
	
	//Add các hàm của JavaExecutor
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explixitWait.until(jQueryLoad) && explixitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isImageLoaded(WebDriver driver, String locatorType, String...dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return status;	
	}
	
	//Add các hàm Wait
	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForAllElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
	    explixitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}
	
	public void waitForAllElementInvisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
	    explixitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForElementClickAble(WebDriver driver, String locatorType) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	public void waitForElementClickAble(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForElementUndisplayed(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeOut);
		overrideGlobalTimeout(driver, shortTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideGlobalTimeout(driver, longTimeOut);
	}
	
	//Tối ưu ở Level 07_Switch_Page
	
	public void openPagesAtMyAccountByPageName(WebDriver driver, String pageName) {

		waitForElementClickAble(driver, BasePageUI.DYNAMIC_MY_ACCOUNT_PAGE, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_MY_ACCOUNT_PAGE, pageName);

	}
	
	//Hàm upload File/Multi Files 	
	public void uploadMultiFiles(WebDriver driver, String...filesName) {
			// Đường dẫn của thư mục Upload File
			String filePath = GlobalConstants.UPLOAD_FILE;
			
			// Đường dẫn của tất cả các file
			String fullFileName = "";
			for (String file: filesName) {
				fullFileName = fullFileName + filePath + file + "\n";
			}
			fullFileName = fullFileName.trim();
			getWebElement(driver, BasePageJQueryUI.UPLOAD_FILE).sendKeys(fullFileName);
	}
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}
	
	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	
	/** Input to dynamic TextBox by ID
	 * @param driver
	 * @param textboxID
	 * @param value
	 */
	public void inputToTextBoxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeysToElementByXpath(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
		
	}
	
	/** Input to dynamic Button by Text
	 * @param driver
	 * @param buttonText
	 */
	public void clickToButtonByText(WebDriver driver, String buttonText) {
		waitForElementClickAble(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		
	}
	
	/** Select item value dropdown by Name Attribute
	 * @param driver
	 * @param dropdownAttributeName
	 * @param itemValue
	 */
	public void selectToDropDownByName(WebDriver driver, String dropdownAttributeName, String itemValue) {
		waitForElementClickAble(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
		selectItemDefaulDropDown(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, itemValue, dropdownAttributeName);
		
	}
	
	/** Click to Dynamic Radio Button by Label Name
	 * @param driver
	 * @param checkBoxLabelName
	 */
	public void clickToRadioButtonByLabel(WebDriver driver, String radioButtonLabelName) {
		waitForElementClickAble(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
		checkToDefaultCheckBoxRadio(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
	}
	
	/** Click to Dynamic CheckBox by Label Name
	 * @param driver
	 * @param checkBoxLabelName
	 */
	public void clickToCheckBoxByLabel(WebDriver driver, String checkBoxLabelName) {
		waitForElementClickAble(driver, BasePageUI.DYNAMIC_CHECKBOX_BY_LABEL, checkBoxLabelName);
		checkToDefaultCheckBoxRadio(driver, BasePageUI.DYNAMIC_CHECKBOX_BY_LABEL, checkBoxLabelName);
	}
	
	/** Get value in TextBox by TextBoxID
	 * @param driver
	 * @param textboxID
	 * @return
	 */
	public String getTextboxValueByID(WebDriver driver, String textboxID) {
		waitForAllElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}
	
	private long longTimeOut = GlobalConstants.LONG_TIMEOUT;
	
	private long shortTimeOut = GlobalConstants.SHORT_TIMEOUT;













}

