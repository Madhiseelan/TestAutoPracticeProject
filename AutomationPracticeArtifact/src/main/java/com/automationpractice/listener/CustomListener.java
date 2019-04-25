package com.automationpractice.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import com.automationpractice.base.TestBase;
import com.automationpractice.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;

public class CustomListener extends TestBase implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
	
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test Case is Failed ***");
		//TestUtil.takeFailedScreenshot(result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.endTest(extentTest); //Ending the current test and prepare the HTMl report
		extent.flush();
		//extent.close();
	}

}
