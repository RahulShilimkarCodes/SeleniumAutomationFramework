package com.ui.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.AccountPage;

@Listeners({com.ui.listeners.LoggerListener.class})
public class ProductTest extends BaseTest{
	
	private AccountPage accountPage;
	public static final String ITEM_TO_SEARCH = "printed chiffon dress";
	
	@BeforeMethod(description="Logging in as the valid user in the application")
	public void loginSetUp()
	{
		accountPage = homePage.goToLoginPage().enteringAndSubmittingCredentials("nococac422@aperiol.com", "Rahul@nococac");
		//we took this in variable, since we have to use it in other test to access the driver...if not given, no driver passed..
	}
	
	@Test(description="Verifying the product page title")
	public void verifyCorrectProduct() throws InterruptedException
	{
		String searchedItems = accountPage.searchProduct(ITEM_TO_SEARCH).getSearchedItemText();
		Assert.assertTrue(searchedItems.contains(ITEM_TO_SEARCH.toUpperCase()));
	}
	
	@Test(description="Printing the products name")
	public void getAllProductNames() throws InterruptedException
	{	
		accountPage.searchProduct(ITEM_TO_SEARCH).getProductNames();
	}
	
	
	@Test(description="verifying all the products are as per search")
	public void verifyingAllProductNames() throws InterruptedException
	{	
		boolean result = accountPage.searchProduct(ITEM_TO_SEARCH).verifyProductNameMatch(ITEM_TO_SEARCH);
		Assert.assertTrue(result);
	}

}
