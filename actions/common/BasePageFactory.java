package common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
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
		
		private By getByXpath(String xpathLocator) {
			return By.xpath(xpathLocator);
		}
		
		private WebElement getElementByXpath(WebDriver driver, String xpathLocator) {
			return driver.findElement(getByXpath(xpathLocator));
		}
		
		private List<WebElement> getListElementByXpath(WebDriver driver, String xpathLocator) {
			return driver.findElements(getByXpath(xpathLocator));
		}
			
		public void clickToElement(WebDriver driver, WebElement element) {
			 element.click();
		}
		
		public void sendkeysToElement(WebDriver driver, WebElement element, String textValue ) {
			element.clear();
			element.sendKeys(textValue);
		}
		
		public String getTextOfElement(WebDriver driver, WebElement element) {
			return element.getText();
		}
	    
		public void selectItemDefaulDropDown(WebDriver driver, String xpathLocator, String textItem) {
			Select select = new Select(getElementByXpath(driver, xpathLocator));
			select.selectByValue(textItem);
		}
		
		public String getSelectedItem(WebDriver driver, String xpathLocator) {
			Select select = new Select(getElementByXpath(driver, xpathLocator));
			return select.getFirstSelectedOption().getText();
		}
		
		public Boolean isDropDownMulti(WebDriver driver, String xpathLocator) {
			Select select = new Select(getElementByXpath(driver, xpathLocator));
			return select.isMultiple();
		}
		


		public void sleepInSecond(long timeInSecond) {
			try {
				Thread.sleep(timeInSecond * 1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	}

		public String getElementAttribute(WebDriver driver, String xpathLocator, String name) {
			return getElementByXpath(driver, xpathLocator).getAttribute(name);
		}
		
		public String getElementCssValue(WebDriver driver, String xpathLocator, String cssValue) {
			return getElementByXpath(driver, xpathLocator).getCssValue(cssValue);
		}

		public String getoHexColorFromRgba(String rgbaValue) {
			return Color.fromString(rgbaValue).asHex();
		}
		
		public int getElementSize(WebDriver driver, String xpathLocator) {
			return getListElementByXpath(driver, xpathLocator).size();
		}

		public void checkToDefaultCheckBoxRadio(WebDriver driver, String xpathLocator) {
			WebElement element = getElementByXpath(driver, xpathLocator);
			if(!element.isSelected()) {
				element.click();
			}
		}

		public void unCheckToDefaultCheckBoxRadio(WebDriver driver, String xpathLocator) {
			WebElement element = getElementByXpath(driver, xpathLocator);
			if(element.isSelected()) {
				element.click();
			}
		}
		
		public Boolean isElementDisplay(WebDriver driver, WebElement element) {
			return element.isDisplayed();
		}
		
		public Boolean isElementEnable(WebDriver driver, String xpathLocator) {
			return getElementByXpath(driver, xpathLocator).isEnabled();
		}
		
		public Boolean isElementSelected(WebDriver driver, String xpathLocator) {
			return getElementByXpath(driver, xpathLocator).isSelected();
		}
		
		public void switchToFrame(WebDriver driver, String xpathLocator) {
			driver.switchTo().frame(getElementByXpath(driver, xpathLocator));
		}
		
		public void switchToDefaultContent(WebDriver driver, String xpathLocator) {
			driver.switchTo().defaultContent();
		}

		public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
			Actions action =new Actions(driver);
			action.moveToElement(getElementByXpath(driver, xpathLocator)).perform();
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
		
		//Các hàm wait khi dùng với Page Factory thì cần define lại thành WebElement
		public void waitForElementVisible(WebDriver driver, WebElement element) {
			WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
			
			explixitWait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
			WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
			
			explixitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
		}
		
		public void waitForElementInvisible(WebDriver driver, WebElement element) {
			WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
			
			explixitWait.until(ExpectedConditions.invisibilityOf(element));
		}
		
		public void waitForAllElementInvisible(WebDriver driver,  List<WebElement> elements) {
			WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
			
		    explixitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
		}
		
		public void waitForElementClickAble(WebDriver driver, WebElement element) {
			WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
			
			explixitWait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		private long longTimeOut = 30;
		
		private long shortTimeOut = 5;
}
