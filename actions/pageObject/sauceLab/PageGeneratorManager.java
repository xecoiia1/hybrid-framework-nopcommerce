package pageObject.sauceLab;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

		public static LoginPageObj getLoginPage(WebDriver driver) {
			return new LoginPageObj(driver);
		}
		
		public static ProductPageObj getProductPage(WebDriver driver) {
			return new ProductPageObj(driver);
		}
}
