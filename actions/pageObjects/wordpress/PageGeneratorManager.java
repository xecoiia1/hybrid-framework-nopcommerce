package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	
	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}
	
	public static AdminPostSearchPO getAdminPostSeachPage(WebDriver driver) {
		return new AdminPostSearchPO(driver);
	}
	
	public static AdminPostAddNewPO getAdminPostAddNewPage(WebDriver driver) {
		return new AdminPostAddNewPO(driver);
	}
	
	public static UserPostDetailPO getUserPostDetailPO(WebDriver driver) {
		return new UserPostDetailPO(driver);
	}
	
	public static UserHomePO getUserHomePO(WebDriver driver) {
		return new UserHomePO(driver);
	}
}
