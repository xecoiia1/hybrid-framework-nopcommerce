package pageObject.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static LoginPageObj getLoginPage(WebDriver driver) {
			return new LoginPageObj(driver);
	}
}
