package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.TestBase;

public class MainPage extends TestBase{
			
		//Page Repository 
		@FindBy(xpath="//img[@class='logo img-responsive']")
		WebElement logo;
	
		@FindBy(id="search_query_top")
		WebElement search_BOX;
		
		@FindBy(name="submit_search")
		WebElement search_BTN;
		
		@FindBy(xpath="//div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")
		WebElement dresses_BTN;
	
		@FindBy(xpath="//div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[1]")
		WebElement tshirts_BTN;
		
		@FindBy(xpath="//a[@title='Log in to your customer account']")
		WebElement signin_BTN;
		
		//public static String search_BOX = "search_query_top~ID";
		//public static String search_BTN = "submit_search~NAME";	
		//public static String dresses_BTN = "//div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]~XPATH";
		//public static String tshirts_BTN = "//div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[1]~XPATH";
		
		//Initializing the Page Objects
		public MainPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions are nothing but the Features available on Main page
		public String validateMainPageTitle() {
			return driver.getTitle();
		}
		
		public boolean validateLogoImage() {
			return logo.isDisplayed();
		}
		
		public LoginPage signinBtnClick() {
			signin_BTN.click();
			//After click on Sign-on button from Main page, it will move to Login Page
			//Login Page is the landing page of Main Page. So ideally, this method should return Login page class Object.
			return new LoginPage();
			
		}
		
}