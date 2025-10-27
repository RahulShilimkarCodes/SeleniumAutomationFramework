package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AccountPage;
import com.ui.pages.AddressPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewAddressTest extends BaseTest{
	
	private AccountPage accountPage;
	private AddressPOJO address;
	
	@BeforeMethod
	public void loginUserSetUp()
	{
		accountPage = homePage.goToLoginPage().enteringAndSubmittingCredentials("nococac422@aperiol.com","Rahul@nococac");
		address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test
	public void addingNewAddres()
	{
		accountPage.clickingOnAddFirstAddress().savingAddressDetails(address);
	}

}
