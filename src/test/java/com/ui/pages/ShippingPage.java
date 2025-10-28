package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility{
	
	public ShippingPage(WebDriver driver)
	{
		super(driver);
	}
	
	public static final By AGREE_TERMS = By.id("cgv");
	public static final By PROCESS_SHIPPING = By.name("processCarrier");	
	
	public void agreeTermsAndCondition()
	{
		jsClickOn(AGREE_TERMS);
		jsClickOn(PROCESS_SHIPPING);
	}

}
