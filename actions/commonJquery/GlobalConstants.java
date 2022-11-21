package commonJquery;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String JAVA_VERSION  = System.getProperty("java.version");
	
	//Tạo đường dẫn cho cả Window/Linux/Mac
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "Upload_File" + File.separator;
	public static final String DOWNLOAD_FOLDER = PROJECT_PATH + File.separator + "";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML = PROJECT_PATH + File.separator + "drag_and_drop";
	public static final String AUTO_IT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTING_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;
	public static final String EXTENT_PATH = PROJECT_PATH + File.separator + "extentV2";
}
