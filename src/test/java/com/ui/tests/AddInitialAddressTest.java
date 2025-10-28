package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AccountPage;
import com.ui.pages.AddressPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddInitialAddressTest extends BaseTest{
	
	private AccountPage accountPage;
	private AddressPOJO address;
	
	@BeforeMethod(description="Valid first time user logs into the application")
	public void loginUserSetUp()
	{
		accountPage = homePage.goToLoginPage().enteringAndSubmittingCredentials("nococac422@aperiol.com","Rahul@nococac");
		address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test(description="Adding the initial address for the first time user")
	public void addingNewAddres()
	{
		String actualAddressType = accountPage.clickingOnAddFirstAddress().savingAddressDetails(address).verifyAddressType();
		Assert.assertEquals(actualAddressType, address.getAddressTitle().toUpperCase());	
	}
	
	@Test(description="Adding and Deleting the initial address for the first time user")
	public void addingandDeletingNewAddres()
	{
		accountPage.clickingOnAddFirstAddress().savingAddressDetails(address).deleteExistingAddress();
		
	}


}
