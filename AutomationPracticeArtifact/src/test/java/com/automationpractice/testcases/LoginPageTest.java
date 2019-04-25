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
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MainPage;
import com.automationpractice.reports.ExtentFactory;
import com.automationpractice.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(CustomListener.class)
public class LoginPageTest extends TestBase{
	private static Logger logger = LogManager.getLogger(LoginPageTest.class);
	MainPage mainPage;
	LoginPage loginPage;
	
	public LoginPageTest() {
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
		logger.info("Loading and initializing driver for LoginPageTest Class ....");
		mainPage = new MainPage();
		loginPage = mainPage.signinBtnClick();
	}
	
	@Test
	public void loginPageTitleTest() {
		// This login page object is coming from Main Page
		extentTest = extent.startTest("loginPageTitleTest");
		String loginTitle = loginPage.loginPageTitle();
		Assert.assertEquals(loginTitle, "Login - My Stores", "Login Page title is not matched");
	}
	
	@Test
	public void loginTest() {
		extentTest = extent.startTest("getLoginDetails");
		loginPage.getLoginDetails(prop.getProperty("usname"), prop.getProperty("paword"));
		
		/*
		 * driver.findElement(By.id("email")).sendKeys("assistanceqa@gmail.com");
		 * driver.findElement(By.id("passwd")).sendKeys("123456");
		 * driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click(); try {
		 * Thread.sleep(10000); } catch (InterruptedException e) { e.printStackTrace();
		 * }
		 */
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test Case Failed is: " +result.getName());
			extentTest.log(LogStatus.FAIL, "Test Case Failed is: " +result.getThrowable());
			
			String finalScreenshotPath = TestUtil.takeFailedScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(finalScreenshotPath));
			
		} else if(result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case Skipped is: " +result.getName());
			
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case Passed is: " +result.getName());
		}
		
		//extent.endTest(extentTest);
		
		driver.quit();
		logger.info("Browser closed Successfully");
	}

}
