package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;

import com.constants.Size;
import com.ui.pages.AccountPage;

public class ProductCheckoutTest extends BaseTest{
	
	private AccountPage accountPage;
	public static final String ITEM_TO_SEARCH = "printed chiffon dress";
	
	@BeforeMethod(description="user logs into the application and searches the product")
	public void checkOutSetup()
	{
		accountPage = homePage.goToLoginPage().enteringAndSubmittingCredentials("nococac422@aperiol.com","Rahul@nococac");
	}
	
	@Test
	public void checkOutProduct()
	{ //
		accountPage.searchProduct(ITEM_TO_SEARCH).clickOnDesiredProduct(ITEM_TO_SEARCH).selectSize(Size.L).incrementItems().addToCart().proceedToCheckout().confirmCartSummary().confirmAddress().agreeTermsAndCondition();
	}
}
