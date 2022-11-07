package pageObjUploadFiles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import commonJquery.BasePageJquery;
import commonJquery.GlobalConstants;
import pageUI.Jquery.uploadFile.HomePageUI;

public class HomePageObj extends BasePageJquery {
	WebDriver driver;

	public HomePageObj(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplay(driver, HomePageUI.FILE_NAME_LOADED, fileName);
	}
	
	public boolean isFileLinksUpLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINKS, fileName);
		return isElementDisplay(driver, HomePageUI.FILE_NAME_UPLOADED_LINKS, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTON);
		
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(GlobalConstants.SHORT_TIMEOUT);
		}		
	}

	public boolean isFileImageUpLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}
	
	
}
