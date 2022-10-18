package common;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.nopCommerce.admin.AdminLoginPageObj;
import pageObject.nopCommerce.user.UserAddressPageObj;
import pageObject.nopCommerce.user.UserCustomerInforPageObj;
import pageObject.nopCommerce.user.UserHomePageObj;
import pageObject.nopCommerce.user.UserMyProductReviewPageObj;
import pageObject.nopCommerce.user.UserRewardPointPageObj;
import pageUI.nopCommerce.user.BasePageUI;
import pageUI.nopCommerce.user.CustomerInforPageUI;

//Common class
public class BasePage extends BasePageUI {
	
	// Che giấu đi việc khởi tạo của 1 đối tượng
	public static BasePage getBasePageObj() {
		return new BasePage();
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
	
	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=")||locatorType.startsWith("ID=")||locatorType.startsWith("Id=")) {
			 by = by.id(locatorType.substring(3));
		}else if(locatorType.startsWith("class=")||locatorType.startsWith("CLASS=")||locatorType.startsWith("Class=")) {
			by = by.id(locatorType.substring(6));
		}else if(locatorType.startsWith("name=")||locatorType.startsWith("NAME=")||locatorType.startsWith("Name=")){
			by = by.id(locatorType.substring(5));
		}else if(locatorType.startsWith("css=")||locatorType.startsWith("CSS=")||locatorType.startsWith("Css=")) {
			by = by.id(locatorType.substring(4));
		}else if(locatorType.startsWith("xpath=")||locatorType.startsWith("XPATH=")||locatorType.startsWith("Xpath=")) {
			by = by.id(locatorType.substring(6));
		}else {
			throw new RuntimeException("Locator is not supported");
		}
		
		return by;
	}
	
	private WebElement getElementByXpath(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}
	
	private List<WebElement> getListElementByXpath(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}
		
	public void clickToElementByXpath(WebDriver driver, String locatorType) {
		 getElementByXpath(driver, locatorType).click();
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
		 getElementByXpath(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}
	
	public void sendkeysToElementByXpath(WebDriver driver, String locatorType, String textValue ) {
		WebElement element = getElementByXpath(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void sendkeysToElementByXpath(WebDriver driver, String locatorType, String textValue, String...dynamicValues ) {
		WebElement element = getElementByXpath(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}
	
	public String getTextOfElement(WebDriver driver, String locatorType) {
		return getElementByXpath(driver, locatorType).getText();
	}
	
	public String getTextOfElement(WebDriver driver, String locatorType, String...dynamicValues) {
		return getElementByXpath(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}
    
	public void selectItemDefaulDropDown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getElementByXpath(driver, locatorType));
		select.selectByValue(textItem);
	}
	
	public void selectItemDefaulDropDown(WebDriver driver, String locatorType, String textItem, String...dynamicValues) {
		Select select = new Select(getElementByXpath(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByValue(textItem);
	}
	
	
	public String getSelectedItem(WebDriver driver, String locatorType) {
		Select select = new Select(getElementByXpath(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}
	
	public Boolean isDropDownMulti(WebDriver driver, String locatorType) {
		Select select = new Select(getElementByXpath(driver, locatorType));
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
		return getElementByXpath(driver, locatorType).getAttribute(name);
	}
	
	public String getElementCssValue(WebDriver driver, String locatorType, String cssValue) {
		return getElementByXpath(driver, locatorType).getCssValue(cssValue);
	}

	public String getoHexColorFromRgba(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver, String locatorType) {
		return getListElementByXpath(driver, locatorType).size();
	}

	public void checkToDefaultCheckBoxRadio(WebDriver driver, String locatorType) {
		WebElement element = getElementByXpath(driver, locatorType);
		if(!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToDefaultCheckBoxRadio(WebDriver driver, String locatorType) {
		WebElement element = getElementByXpath(driver, locatorType);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public Boolean isElementDisplay(WebDriver driver, String locatorType) {
		return getElementByXpath(driver, locatorType).isDisplayed();
	}
	
	public Boolean isElementDisplay(WebDriver driver, String locatorType, String...dynamicValues) {
		return getElementByXpath(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}
	
	public Boolean isElementEnable(WebDriver driver, String locatorType) {
		return getElementByXpath(driver, locatorType).isEnabled();
	}
	
	public Boolean isElementSelected(WebDriver driver, String locatorType) {
		return getElementByXpath(driver, locatorType).isSelected();
	}
	
	public void switchToFrame(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getElementByXpath(driver, locatorType));
	}
	
	public void switchToDefaultContent(WebDriver driver, String locatorType) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action =new Actions(driver);
		action.moveToElement(getElementByXpath(driver, locatorType)).perform();
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
		WebElement element = getElementByXpath(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElementByXpath(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElementByXpath(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElementByXpath(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElementByXpath(driver, locator));
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
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",getElementByXpath(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElementByXpath(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	//Add các hàm Wait
	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
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
		
	    explixitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElementByXpath(driver, locatorType)));
	}
	
	public void waitForAllElementInvisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
	    explixitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElementByXpath(driver, getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForElementClickAble(WebDriver driver, String locatorType) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	public void waitForElementClickAble(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public UserMyProductReviewPageObj openMyProductReviewPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.MY_PRODUCT_REVIEWS_PAGE);
		clickToElementByXpath(driver, BasePageUI.MY_PRODUCT_REVIEWS_PAGE);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}
	
	public UserRewardPointPageObj openRewardPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.REWARD_POINT_PAGE);
		clickToElementByXpath(driver, BasePageUI.REWARD_POINT_PAGE);
		return PageGeneratorManager.getUserRewardPage(driver);
	}
	
	public UserAddressPageObj openAddressPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.ADDRESS_PAGE);
		clickToElementByXpath(driver, BasePageUI.ADDRESS_PAGE);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	public UserCustomerInforPageObj openCustomerInforPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.CUSTOMER_INFO_PAGE);
		clickToElementByXpath(driver, BasePageUI.CUSTOMER_INFO_PAGE);
		return PageGeneratorManager.getUserCustomerInfor(driver);
	}
	
	public UserHomePageObj clickToLogoutBtnUser(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.LOGOUT_BTN_USER);
		clickToElementByXpath(driver, BasePageUI.LOGOUT_BTN_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public AdminLoginPageObj clickToLogoutBtnAdmin(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.LOGOUT_BTN_ADMIN);
		clickToElementByXpath(driver, BasePageUI.LOGOUT_BTN_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	private long longTimeOut = 30;
	
	private long shortTimeOut = 5;













}

