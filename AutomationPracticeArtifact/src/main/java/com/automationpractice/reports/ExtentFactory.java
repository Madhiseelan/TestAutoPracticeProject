package com.automationpractice.reports;

import com.automationpractice.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentFactory extends TestBase{
	
	public static ExtentReports getExtentInstance() {
		if (extent != null) return extent;
		ExtentReports extent;
		//if you pass false it wont replace the existing extent report
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true );
		
		extent
		.addSystemInfo("User Name", "Madhiseeln Ponnusamy")
		.addSystemInfo("Platform", "Windows - Local Machine");
		
		return extent;
	}
	
}
