package common;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	
	//Tạo đường dẫn cho cả Window/Linux/Mac
	public static final String UPLOAD_FOLDER = PROJECT_PATH + File.separator + "";
	public static final String DOWNLOAD_FOLDER = PROJECT_PATH + File.separator + "";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML = PROJECT_PATH + File.separator + "drag_and_drop";
	public static final String AUTO_IT = PROJECT_PATH + File.separator + "autoIT";
}
