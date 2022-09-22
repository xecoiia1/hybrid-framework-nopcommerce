package common;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		WebDriverWait explixitWait = new WebDriverWait(driver, 30);
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
	public void clickToElementByXpath(WebDriver driver, String locator) {
		driver.findElement(By.xpath(locator));
	}
	
	public void clickToElementByCss(WebDriver driver, String locator) {
		driver.findElement(By.cssSelector(locator));
	}

























}

