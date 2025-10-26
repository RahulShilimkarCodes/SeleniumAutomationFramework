package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.LoggerListener.class})
public class InvalidLoginTest extends BaseTest {
	
	private static final String INVALID_USER_NAME = "rahul";
	private static final String INVALID_USER_PASSWORD = "rahul";
	
	@Test(description="verifying invalid login error message", groups = {"e2e","smoke"})
	public void invalidLoginCheck()
	{
		String errorMessage = homePage.goToLoginPage().loginWithInvalidCredentials(INVALID_USER_NAME, INVALID_USER_PASSWORD).getErrorMessage();
		
		Assert.assertEquals(errorMessage, "Invalid email address.");

	}
}
