package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Size;
import com.utility.BrowserUtility;

public class ItemsPage extends BrowserUtility {

	public ItemsPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By SIZE_DROPDOWN = By.id("group_1");
	private static final By INCREMENT_PRODUCT = By.xpath("//a[contains(@class,'product_quantity_up')]");
	private static final By ADD_TO_CART = By.name("Submit");
	
	public ItemsPage selectSize(Size size)
	{
		selectOptionByVisibleText(SIZE_DROPDOWN, size.toString());
		
		ItemsPage itemsPage = new ItemsPage(getDriver());
		return itemsPage;
	}
	
	public ItemsPage incrementItems()
	{
		jsClickOn(INCREMENT_PRODUCT);
		ItemsPage itemsPage = new ItemsPage(getDriver());
		return itemsPage;
	}
	
	public CartConfirmationPage addToCart()
	{
		jsClickOn(ADD_TO_CART);
		
		CartConfirmationPage cartConfirmationPage = new CartConfirmationPage(getDriver());
		return cartConfirmationPage;
	}
	
	
			

}
