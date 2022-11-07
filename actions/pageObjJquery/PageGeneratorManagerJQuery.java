package pageObjJquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerJQuery {

	public static HomePageObj getHomePage(WebDriver driver) {
			return new HomePageObj(driver);
	}
}
