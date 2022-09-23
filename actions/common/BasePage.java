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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//Common class
public class BasePage {
	
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
	
	public By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	
	public WebElement getElementByXpath(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	public List<WebElement> getListElementByXpath(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));
	}
		
	public void clickToElementByXpath(WebDriver driver, String xpathLocator) {
		 getElementByXpath(driver, xpathLocator).click();
	}
	
	public void sendkeysToElementByXpath(WebDriver driver, String xpathLocator, String textValue ) {
		WebElement element = getElementByXpath(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	
	public String getTextOfElement(WebDriver driver, String xpathLocator, String textValue ) {
		return getElementByXpath(driver, xpathLocator).getText();
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
	
	public void selectitemCustomDropDown(WebDriver driver, String parentLocator , String childLocator, String expectedTextItem) {
		
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);

		clickToElementByXpath(driver, parentLocator);
		
		//explixitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));
		
		List<WebElement> allDropDownItems = explixitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));
		
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
	
	public Boolean isElementDisplay(WebDriver driver, String xpathLocator) {
		return getElementByXpath(driver, xpathLocator).isDisplayed();
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
	
	//Add các hàm Wait
	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	public void waitForAllElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
	    explixitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElementByXpath(driver, xpathLocator)));
	}
	
	public void waitForElementClickAble(WebDriver driver, String xpathLocator) {
		WebDriverWait explixitWait = new WebDriverWait(driver, longTimeOut);
		
		explixitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	
	private long longTimeOut = 30;
	
	private long shortTimeOut = 5;













}

