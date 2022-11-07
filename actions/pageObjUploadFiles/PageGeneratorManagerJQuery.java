package pageObjUploadFiles;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerJQuery {

	public static pageObjUploadFiles.HomePageObj getHomePage(WebDriver driver) {
		return new pageObjUploadFiles.HomePageObj(driver);
}
}
