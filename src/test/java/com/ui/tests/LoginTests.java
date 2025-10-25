package com.ui.tests;

import static com.constants.Browser.*;
import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.DataPOJO;
import com.utility.LoggerUtility;


@Listeners({com.ui.listeners.LoggerListener.class,com.ui.listeners.ExtentReportListener.class,com.ui.listeners.ScreenshotListener.class})
public class LoginTests extends BaseTest{
	
	

	
	@Test(description = "Login with valid credentials", groups = {"e2e","Sanity"}, retryAnalyzer = com.ui.listeners.RetryMechanism.class)
	public void LoginTest()
	{

		String userName = homePage.goToLoginPage().enteringAndSubmittingCredentials("nococac422@aperiol.com","Rahul@nococac").getUserName();
		
		assertEquals(userName, "Rahul SHILIMKAR");			//static import, hence not used Assert.assertEquals
		
		//assertEquals(userName, "Rahul SHILIMKAR1");	- this will fail and run the test 3 times..retry logic
		//Note:- to run only the failed test post result generation, we need to configure jenkins to run testng-failed.xml file

	}

	@Test(description = "Login with valid JSON credentials", groups = {"e2e","Sanity"}, dataProviderClass = com.ui.dataProviders.JSONDataProvider.class, dataProvider = "LoginTestData")
	public void LoginJSONTest(DataPOJO user)
	{
		
		String userName = homePage.goToLoginPage().enteringAndSubmittingCredentials(user.getEmailAddress(),user.getPassword()).getUserName();
		
		assertEquals(userName, "Rahul SHILIMKAR");
		
	}
	
	@Test(description = "Login with valid CSV credentials", groups = {"e2e","Sanity"}, dataProviderClass = com.ui.dataProviders.CSVDataProvider.class, dataProvider = "CsvDataProvider")
	public void LoginCSVTest(DataPOJO user)
	{
		
		String userName = homePage.goToLoginPage().enteringAndSubmittingCredentials(user.getEmailAddress(),user.getPassword()).getUserName();
		
		assertEquals(userName, "Rahul SHILIMKAR");
		
	}
	
	@Test(description = "Login with valid Excel credentials", groups = {"e2e","Sanity"}, dataProviderClass = com.ui.dataProviders.ExcelDataProvider.class, dataProvider = "ExcelDataProvider")
	public void LoginExcelTest(DataPOJO user)
	{
		
		String userName = homePage.goToLoginPage().enteringAndSubmittingCredentials(user.getEmailAddress(),user.getPassword()).getUserName();
		
		assertEquals(userName, "Rahul SHILIMKAR");
		
	}

}
