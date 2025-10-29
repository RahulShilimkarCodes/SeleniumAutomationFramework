package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class BankWirePaymentPage extends BrowserUtility{
	
	public BankWirePaymentPage(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By CONFIRM_ORDER = By.xpath("//span[text()='I confirm my order']/parent::button");
	
	public OrderConfirmationPage confirmOrder()
	{
		clickOn(CONFIRM_ORDER);
		
		OrderConfirmationPage orderConfirmation = new OrderConfirmationPage(getDriver());
		return orderConfirmation;
	}
			

}
