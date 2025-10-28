package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class CartConfirmationPage extends BrowserUtility{
	
	public CartConfirmationPage(WebDriver driver)
	{
		super(driver);
	}
	
	public static final By PROCEED_TO_CHECKOUT = By.xpath("//a[@title='Proceed to checkout']");
	
	public ShoppingCartPage proceedToCheckout()
	{
		jsClickOn(PROCEED_TO_CHECKOUT);
		ShoppingCartPage sc = new ShoppingCartPage(getDriver());
		return sc;
	}

}
