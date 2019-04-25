package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationpractice.base.TestBase;

public class CreateNewAccountPage extends TestBase{
		
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement pageHeading;
	
	@FindBy(xpath="//form[@id='account-creation_form']//label[@for='id_gender1']")
	WebElement gender1Mr_ID;
	
	@FindBy(xpath="//form[@id='account-creation_form']//label[@for='id_gender2']")
	WebElement gender2Mrs_ID;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement firstName_TXT;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement lastName_TXT;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement eMail_TXT;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password_TXT;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement dateOfBirthDay_PICKER;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement dateOfBirthMonth_PICKER;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement dateOfBirthYear_PICKER;
	
	@FindBy(xpath="//input[@id='company']")
	WebElement companyName_TXT;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement addressOne_TXT;
	
	@FindBy(xpath="//input[@id='address2']")
	WebElement addressTwo_TXT;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city_TXT;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement state_DROPDWN;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement ZipCode_TXT;
	
	@FindBy(xpath="//select[@id='id_country']")
	WebElement country_DROPDWN;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement homePhone_TXT;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobilePhone_TXT;
	
	@FindBy(xpath="//span[contains(text(),'Register')]")
	WebElement register_BTN;
	
	@FindBy(xpath="//input[@value='My address']")
	WebElement assignForFuture;
	
	
	public CreateNewAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewSignUpContact(String title, String firstname, String lastname, String email,
										String password, String dayofbirth, String monthofbirth, String yearofbirth,
										String company, String addressone, String addresstwo, String city,
										String state, String zip, String country, String homeph, String mobileph, String assignaddres) throws InterruptedException 
	{
		
		if(title == "Mr") {
			gender1Mr_ID.click();
		} else if (title == "Mrs") {
			gender2Mrs_ID.click();
		}
		
		firstName_TXT.sendKeys(firstname);
		
		lastName_TXT.sendKeys(lastname);
		
		eMail_TXT.clear();
		eMail_TXT.sendKeys(email);
		
		password_TXT.sendKeys(password);
		
		
		/*WebDriverWait wdWait = new WebDriverWait(driver, 20);
		WebElement DOBdayPicker = wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='days']")));
		DOBdayPicker.click(); */
		
		Thread.sleep(5000);
		
		//Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		//selectDay.selectByVisibleText(dayofbirth);
		
		WebElement DOBdayPicker = driver.findElement(By.xpath("//select[@id='days']")); 
		DOBdayPicker.sendKeys(dayofbirth);  
		DOBdayPicker.sendKeys(Keys.ENTER);
		
		//Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		//selectMonth.selectByVisibleText(monthofbirth);
		
        WebElement DOBMonthPicker = driver.findElement(By.xpath("//select[@id='months']")); 
        DOBMonthPicker.sendKeys(monthofbirth);  
        DOBMonthPicker.sendKeys(Keys.ENTER);
        
		//Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		//selectYear.selectByVisibleText(yearofbirth);
		
        WebElement DOBYearPicker = driver.findElement(By.xpath("//select[@id='years']")); 
        DOBYearPicker.sendKeys(yearofbirth);  
        DOBYearPicker.sendKeys(Keys.ENTER);
        
        Thread.sleep(3000);
		
		companyName_TXT.sendKeys(company);
		
		addressOne_TXT.sendKeys(addressone);
		
		addressTwo_TXT.sendKeys(addresstwo);
		
		city_TXT.sendKeys(city);
		
		Select selectState = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		selectState.selectByVisibleText(state);
		
		ZipCode_TXT.sendKeys(zip);
		
		Select selectCountry = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		selectCountry.selectByVisibleText(country);
				
		homePhone_TXT.sendKeys(homeph);
		
		mobilePhone_TXT.sendKeys(mobileph);
		
		assignForFuture.sendKeys(assignaddres);
		
		register_BTN.click();
		
		Thread.sleep(5000);
		
	}
	
	
}
