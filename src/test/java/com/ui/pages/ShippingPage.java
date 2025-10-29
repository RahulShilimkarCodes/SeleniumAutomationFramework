package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility{
	
	public ShippingPage(WebDriver driver)
	{
		super(driver);
	}
	
	public static final By AGREE_TERMS = By.id("uniform-cgv");
	public static final By PROCESS_SHIPPING = By.name("processCarrier");	
	
	public PaymentPage agreeTermsAndCondition()
	{
		jsScrollToElement(AGREE_TERMS);
		checkOn(AGREE_TERMS);
		
		jsScrollToElement(PROCESS_SHIPPING);
		jsClickOn(PROCESS_SHIPPING);
		
		PaymentPage paymentPage = new PaymentPage(getDriver());
		return paymentPage;
	}

}
