package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utility.BrowserUtility;

public class ExistingAddressPage extends BrowserUtility{

	public ExistingAddressPage(WebDriver driver)
	{
		super(driver);
	}
	
	public static final By ADDRESS_TYPE = By.xpath("//h3[@class='page-subheading']");
	public static final By DELETE_ADDRESS = By.xpath("//a[@title='Delete']");
	public static final By BACK_TO_ACCOUNT = By.xpath("//span[text()=' Back to your account']/parent::a");
	public static final By CONFIRM_ADDRESS = By.name("processAddress");
	
	public String verifyAddressType()
	{	
		String addressType = getVisibleText(ADDRESS_TYPE);	
		return addressType;
	}
	
	public ExistingAddressPage deleteExistingAddress()
	{
		clickOn(DELETE_ADDRESS);
		acceptAlert();
		
		ExistingAddressPage existingAddressPage = new ExistingAddressPage(getDriver());
		return existingAddressPage;
	}
	
	public AccountPage backToAccountPage()
	{
		clickOn(BACK_TO_ACCOUNT);
		
		AccountPage accountPage = new AccountPage(getDriver());
		return accountPage;
	}
	
	public ShippingPage confirmAddress()
	{
		//jsClickOn(CONFIRM_ADDRESS);
		clickOn(CONFIRM_ADDRESS);
		
		ShippingPage shippingPage = new ShippingPage(getDriver());
		return shippingPage;
	}
	
	
}
