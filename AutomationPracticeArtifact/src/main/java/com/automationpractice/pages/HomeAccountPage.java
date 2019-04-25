package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.TestBase;

public class HomeAccountPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(), 'Order history and details')]")
	WebElement orderHistory_BTN;
	
	@FindBy(xpath="//span[contains(text(), 'My credit slips')]")
	WebElement credeitSlip_BTN;
	
	@FindBy(xpath="//span[contains(text(), 'My addresses')]")
	WebElement myAddresses_BTN;
	
	@FindBy(xpath="//span[contains(text(), 'My personal information')]")
	WebElement myPersonalInfo_BTN;
	
	@FindBy(xpath="//span[contains(text(), 'My wishlists')]")
	WebElement myWishlst_BTN;
	
	public HomeAccountPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String HomeAccountPageTitle() {
		String homePgTitle = driver.getTitle();
		return homePgTitle;
	}
}
