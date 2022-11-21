package reportConfig;

import java.io.File;

import org.openqa.selenium.Platform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManagerV3 {
	private static ExtentReports extent;
	private static Platform platform;
	private static String reportFileName = "ExtentReport.html";
	private static String macPath = System.getProperty("user.dir") + "/ExtentReportV3";
	private static String extentReportPath = System.getProperty("user.dir") + "/extentV3/" + reportFileName;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(extentReportPath);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Nop Commerce HTML Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Nop Commerce HTML Report");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}
}