package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility{
	
	public PaymentPage(WebDriver driver)
	{
		super(driver);
	}
	
	private static final By PAY_BY_BANK_WIRE = By.xpath("//a[@title='Pay by bank wire']");
	
	public BankWirePaymentPage payByBankWire()
	{
		clickOn(PAY_BY_BANK_WIRE);
		
		BankWirePaymentPage bankwire = new BankWirePaymentPage(getDriver());
		return bankwire;
	}
			

}
