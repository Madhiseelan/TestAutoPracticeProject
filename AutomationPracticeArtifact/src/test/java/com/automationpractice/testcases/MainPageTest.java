	package com.automationpractice.testcases;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationpractice.base.TestBase;
import com.automationpractice.listener.CustomListener;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MainPage;
import com.automationpractice.reports.ExtentFactory;
import com.automationpractice.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(CustomListener.class)
public class MainPageTest extends TestBase{
		private static Logger logger = LogManager.getLogger(MainPageTest.class);
		
		MainPage mainPage;
		LoginPage loginPage;
		
		public MainPageTest() {
			super();
			logger.info("Loading and initializing properties file ....");
		}
		
		@BeforeClass
		public void setExtent() {
			extent = ExtentFactory.getExtentInstance();
			logger.info("Extent Report has been Loaded...");
		}
		
		@BeforeMethod
		public void setUp() {
			initialization();
			logger.info("Loading and initializing driver for MainPageTest Class ....");
			//Create an Object of MainPage Class
			mainPage = new MainPage();
		}
		
		@Test
		public void verifyPageTitleTest() {
			extentTest = extent.startTest("verifyPageTitleTest");
			String title = mainPage.validateMainPageTitle();
			System.out.println("Title of the Page is:" + title);
			Assert.assertEquals(title, "My Stores");
		}
		
		@Test
		public void verifyLogoImageTest() {
			extentTest = extent.startTest("verifyLogoImageTest");
			boolean logoFlag = mainPage.validateLogoImage();
			Assert.assertTrue(logoFlag);
		}
		
		@Test
		public void verifyLoginClickTest() throws InterruptedException {
			extentTest = extent.startTest("verifyLoginClickTest");
			loginPage = mainPage.signinBtnClick();
			Thread.sleep(4000);
		}
		
		@AfterMethod
		public void tearDown(ITestResult result) throws IOException{
			
			if(result.getStatus()==ITestResult.FAILURE) {
				extentTest.log(LogStatus.FAIL, "Test Case Failed is "+ result.getName()); //to add name in extent report
				extentTest.log(LogStatus.FAIL, "Test Case Failed is "+ result.getThrowable()); //To add error or Exception in Extent report
				
				String finalScreenshotPath = TestUtil.takeFailedScreenshot(driver, result.getName());
				
				//Attach the screenshot in Extent Report
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(finalScreenshotPath));
				
			} else if (result.getStatus() == ITestResult.SKIP) {
				extentTest.log(LogStatus.SKIP, "Test Case Skipped is "+ result.getName());
				
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(LogStatus.PASS, "Test Case Passed is :"+ result.getName());
			}
				
			driver.quit();
			logger.info("Browser Closed successfully");
		}
		
}
