package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility{
	
	public AddressPage(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By FIRST_NAME = By.id("firstname");
	private static final By LAST_NAME = By.id("lastname");
	private static final By COMPANY = By.id("company");
	private static final By ADDRESS = By.id("address1");
	private static final By ADDRESS_LINE_2 = By.id("address2");
	private static final By CITY = By.id("city");
	private static final By STATE = By.id("id_state");
	private static final By ZIP_CODE = By.id("postcode");
	private static final By HOME_PHONE = By.id("phone");
	private static final By MOBILE_PHONE = By.id("phone_mobile");
	private static final By ADDITIONAL_INFO = By.id("other");
	private static final By ADDRESS_TITLE = By.id("alias");
	private static final By SAVE_ADDRESS = By.id("submitAddress");
	
	public void savingAddressDetails(AddressPOJO addressPOJO)
	{
		enterText(COMPANY, addressPOJO.getCompany());
		enterText(ADDRESS, addressPOJO.getAddressLine1());
		enterText(ADDRESS_LINE_2, addressPOJO.getAddressLine2());
		enterText(CITY, addressPOJO.getCity());
		selectOptionByVisibleText(STATE, addressPOJO.getState());
		enterText(ZIP_CODE, addressPOJO.getZipCode());
		enterText(HOME_PHONE, addressPOJO.getHomePhone());
		enterText(MOBILE_PHONE, addressPOJO.getMobilePhone());
		enterText(ADDITIONAL_INFO, addressPOJO.getAdditionalInfo());
		clearText(ADDRESS_TITLE);
		enterText(ADDRESS_TITLE, addressPOJO.getAddressTitle());
		
		clickOn(SAVE_ADDRESS);
		
	}
	

}
