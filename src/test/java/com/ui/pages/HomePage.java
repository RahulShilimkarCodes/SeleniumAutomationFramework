package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Environments;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.PropertiesUtility;

public final class HomePage extends BrowserUtility{
	
	public HomePage(Browser browserName, boolean isHeadLess) {
		super(browserName,isHeadLess);
		launchWebsite(PropertiesUtility.readProperties(Environments.QA, "URL"));
		//launchWebsite(JSONUtility.readJson(Environments.QA).getUrl());		//-- using JSON file to read properties.
		maximizeBrowser();
	}

	public HomePage(WebDriver remoteLambdaDriver) {
		super(remoteLambdaDriver);
		launchWebsite(PropertiesUtility.readProperties(Environments.QA, "URL"));
		//launchWebsite(JSONUtility.readJson(Environments.QA).getUrl());		//-- using JSON file to read properties.
		maximizeBrowser();
	}

	private static final By SIGN_IN_LOCATOR = By.xpath("//a[@class='login']");
	
	
	public LoginPage goToLoginPage()
	{
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());		//passing driver session to loginPage...
		return loginPage;
	}
	
	

}
