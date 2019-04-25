package com.automationpractice.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationpractice.base.TestBase;
import com.automationpractice.listener.CustomListener;
import com.automationpractice.pages.CreateNewAccountPage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MainPage;
import com.automationpractice.reports.ExtentFactory;
import com.automationpractice.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(CustomListener.class)
public class CreateNewAccountPageTest extends TestBase{
		private static Logger logger = LogManager.getLogger(CreateNewAccountPageTest.class);
		
		MainPage mainPage;
		LoginPage loginPage;
		CreateNewAccountPage createNewAccPage;
		String sheetName = "SignUpDetails";
		
		public CreateNewAccountPageTest() {
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
			mainPage = new MainPage();
			loginPage = mainPage.signinBtnClick();
			createNewAccPage = loginPage.getNewEmailforSignUp(prop.getProperty("newSignUpEmail"));
			
		}
		
		@DataProvider
		public Object[][] getNewSignInDetails() {
			Object data[][] = TestUtil.getTestData(sheetName);
			
			return data;
		}
	
		
		@Test(dataProvider = "getNewSignInDetails")
		public void newUserSignupTest(
				String title, String firstname, String lastname, 
				String email, String password, String dayofbirth, String monthofbirth, String yearofbirth, 
				String company, String addressone, String addresstwo, String city, String state, String zip, String country,
				String homeph, String mobileph, String assignaddres) throws InterruptedException 
		{
			extentTest = extent.startTest("newUserSignupTest");
			createNewAccPage.createNewSignUpContact(title, firstname, lastname, email, 
					password, dayofbirth, monthofbirth, yearofbirth, company, 
					addressone, addresstwo, city, state, zip, country, 
					homeph, mobileph, assignaddres);
		}
		
		@AfterMethod
		public void tearDown(ITestResult result) {
			
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
