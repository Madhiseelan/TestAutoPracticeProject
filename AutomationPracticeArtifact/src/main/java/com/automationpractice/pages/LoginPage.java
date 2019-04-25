package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationpractice.base.TestBase;

public class LoginPage extends TestBase{
		
		@FindBy(xpath="//input[@id='email']")
		WebElement userEmail;
		
		@FindBy(xpath="//input[@id='passwd']")
		WebElement password;
		
		@FindBy(xpath="//p[@class='submit']//span[1]")
		WebElement login_BTN;
		
		@FindBy(xpath="//input[@id='email_create']")
		WebElement signUp_Email;
		
		@FindBy(xpath="//form[@id='create-account_form']//button[@id='SubmitCreate']")
		WebElement signUp_BTN;
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		public static String loginPageTitle() {
			String loginTitle = driver.getTitle();
			return loginTitle;
		}
		
		public HomeAccountPage getLoginDetails(String uname, String pwd) {

			userEmail.sendKeys(uname);
			password.sendKeys(pwd);
			login_BTN.click();
			
			//((JavascriptExecutor)driver).executeScript("arguments[0].value='assistanceqa@gmail.com';", userEmail);
			//((JavascriptExecutor)driver).executeScript("arguments[0].click();", login_BTN);
			
			return new HomeAccountPage();
		}
	
		
		public CreateNewAccountPage getNewEmailforSignUp(String newEmail){
			signUp_Email.sendKeys(newEmail );
			signUp_BTN.click();
			
			return new CreateNewAccountPage();
		}
		
}
