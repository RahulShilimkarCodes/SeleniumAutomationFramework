package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{
	
	public LoginPage(WebDriver driver)			//subclass must call param constructor of base/parent class
	{
		super(driver);			//to call parent class constructor
		//Home page has an object of LoginPage created, in which we are passing driver session, that driver session is being catched over here..
	}

	private static final By EMAIL_LOCATOR = By.xpath("//input[@id='email']");
	private static final By PASSWORD_LOCATOR = By.xpath("//input[@id='passwd']");
	private static final By SUBMIT_LOGIN_LOCATOR = By.xpath("//button[@id='SubmitLogin']");
	private static final By INVALID_LOGIN_ERROR_MESSAGE = By.xpath("//div[@class='alert alert-danger']/ol/li");
	
	public AccountPage enteringAndSubmittingCredentials(String username, String password)
	{
		enterText(EMAIL_LOCATOR,username);
		enterText(PASSWORD_LOCATOR,password);
		
		clickOn(SUBMIT_LOGIN_LOCATOR);
		AccountPage accountPage = new AccountPage(getDriver());		//passing driver session to account page...
		return accountPage;
	} 
	
	public LoginPage loginWithInvalidCredentials(String username, String password)
	{
		enterText(EMAIL_LOCATOR,username);
		enterText(PASSWORD_LOCATOR,password);
		
		clickOn(SUBMIT_LOGIN_LOCATOR);
		
		LoginPage loginPage = new LoginPage(getDriver());		//since we are on same page
		return loginPage;
	}
	
	
	public String getErrorMessage()
	{
		return getVisibleText(INVALID_LOGIN_ERROR_MESSAGE);
	}
	
	
}
