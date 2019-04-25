package com.automationpractice.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationpractice.base.TestBase;
import com.automationpractice.listener.CustomListener;
import com.automationpractice.pages.HomeAccountPage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MainPage;
import com.automationpractice.reports.ExtentFactory;
import com.automationpractice.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(CustomListener.class)
public class HomeAccountPageTest extends TestBase {
	private static Logger logger = LogManager.getLogger(HomeAccountPageTest.class);
	LoginPage loginPage;
	MainPage mainPage;
	HomeAccountPage homeAccountPage;
	
	public HomeAccountPageTest() {
		super();
	}
	
	@BeforeClass
	public void setExtent() {
		extent = ExtentFactory.getExtentInstance();
		logger.info("Extent Report has been Loaded...");
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		logger.info("Loading and initializing driver for HomeAccountPageTest Class ....");
		mainPage = new MainPage();
		loginPage = new LoginPage();
		homeAccountPage = new HomeAccountPage(); //This will work without this line as well

		mainPage.signinBtnClick();
		homeAccountPage = loginPage.getLoginDetails(prop.getProperty("usname"), prop.getProperty("paword"));
	}
	
	@Test
	public void HomeAccountTitleTest() {
		extentTest = extent.startTest("HomeAccountTitleTest");
		String homeAccTitle = homeAccountPage.HomeAccountPageTitle();
		Assert.assertEquals(homeAccTitle, "My account - My Store", "Home Ac. Page title is not Matched");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {

		if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test Case Failed is: " +result.getName());
			extentTest.log(LogStatus.FAIL, "Test Case Failed is: " +result.getThrowable());
			
			String finalScreenshotPath = TestUtil.takeFailedScreenshot(driver, result.getName());
			
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(finalScreenshotPath));
		} else if(result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test case Skipped is: " +result.getName());
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case Passed is: " +result.getName());
		}
		
		//extent.endTest(extentTest);
		driver.quit();
		logger.info("Browser Closed Successfully");
	}
	
}
