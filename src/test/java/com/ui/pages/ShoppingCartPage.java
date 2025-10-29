package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility{
	
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	public static final By PROCEED_TO_CHECKOUT = By.xpath("//span[text()='Proceed to checkout']/parent::a");
	
	public ExistingAddressPage confirmCartSummary()
	{
		jsScrollToElement(PROCEED_TO_CHECKOUT);
		clickOn(PROCEED_TO_CHECKOUT);
		
		ExistingAddressPage existingAddressPage  = new ExistingAddressPage(getDriver());
		return existingAddressPage;
	}

}
