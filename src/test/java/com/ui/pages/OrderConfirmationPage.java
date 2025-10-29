package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class OrderConfirmationPage extends BrowserUtility {

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public static final By ORDER_COMPLETION_MESSAGE = By.xpath("//p[@class='alert alert-success']");
	
	public String orderConfirmationMessage()
	{
		return getVisibleText(ORDER_COMPLETION_MESSAGE);
	}
			

}
