package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class AccountPage extends BrowserUtility{
	
	private static final By ENTER_SEARCH_PRODUCT = By.id("search_query_top");
	private static final By CLICK_SEARCH_PRODUCT = By.name("submit_search");
	private static final By ADD_MY_FIRST_ADDRESS = By.xpath("//a[@title='Add my first address']");

	public AccountPage(WebDriver driver)				//subclass must call param constructor of base/parent class
	{
		super(driver);		//to call parent class constructor
	}
	
	private static final By USER_NAME_LOCATOR = By.xpath("//div[@class='header_user_info']/a/span");			//class variable
	
	public String getUserName() 
	{
		return getVisibleText(USER_NAME_LOCATOR);
	}
	
	public ProductPage searchProduct(String productText)
	{
		enterText(ENTER_SEARCH_PRODUCT, productText);
		clickOn(CLICK_SEARCH_PRODUCT);
		
		ProductPage productPage = new ProductPage(getDriver());
		return productPage;
	}
	
	public AddressPage clickingOnAddFirstAddress()
	{
		clickOn(ADD_MY_FIRST_ADDRESS);
		
		AddressPage addressPage = new AddressPage(getDriver());
		return addressPage;
	}
	
	
	
	
	
}
