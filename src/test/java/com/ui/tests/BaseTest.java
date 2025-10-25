package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class BaseTest {
	
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	
	@Parameters({"browser","isHeadLess","isLambdaTest"})
	@BeforeMethod(description = "Loading homepage of the website")
	
	public void setUpBrowser(
		    @Optional("Chrome") String browser,
		    @Optional("false") boolean isHeadLess,
		    @Optional("false") boolean isLambdaTest,
		    ITestResult result)
	{
		WebDriver remoteLambdaDriver;
		this.isLambdaTest =  isLambdaTest;		//this is done because we need to send isLambdaTest to tear down method as well
		if(isLambdaTest)
		{
			remoteLambdaDriver = LambdaTestUtility.intiliazelambdaTestSessionSetup(browser, result.getMethod().getMethodName());
			homePage = new HomePage(remoteLambdaDriver);
		}
		else
		{
			logger.info("Loading the HomePage");
			homePage = new HomePage(Browser.valueOf(browser.trim().toUpperCase()),isHeadLess);
		}
		
		//homePage = new HomePage(Browser.CHROME);		- above line is same to this,since we have static import for Enum Browser
	}
	
	@AfterMethod(description = "Closing the Browser",alwaysRun = true)
	public void tearDown()
	{
		
		if(isLambdaTest)
		{
			LambdaTestUtility.quitLambdaSession();
		}
		else
		{
			BrowserUtility.quitDriver();
		}
		
	}


}
