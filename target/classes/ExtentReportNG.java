package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extentReports;	
	
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir") +"\\reports\\report.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setDocumentTitle("Test Results");
		sparkReporter.config().setReportName("Chinmoy Selenium Practice Test Results");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Chinmoy", "Automation Tester");
		return extentReports;
	}

}
