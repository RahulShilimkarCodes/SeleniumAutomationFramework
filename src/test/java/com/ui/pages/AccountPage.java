package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class AccountPage extends BrowserUtility{
	

	public AccountPage(WebDriver driver)				//subclass must call param constructor of base/parent class
	{
		super(driver);		//to call parent class constructor
	}
	
	private static final By USER_NAME_LOCATOR = By.xpath("//div[@class='header_user_info']/a/span");			//class variable
	
	public String getUserName() 
	{
		return getVisibleText(USER_NAME_LOCATOR);
	}
	
	
	
	
}
