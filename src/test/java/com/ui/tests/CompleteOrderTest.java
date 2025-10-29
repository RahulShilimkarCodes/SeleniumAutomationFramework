package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Size.*;

import com.constants.Size;
import com.ui.pages.AccountPage;


@Listeners({com.ui.listeners.LoggerListener.class,com.ui.listeners.ExtentReportListener.class,com.ui.listeners.ScreenshotListener.class})
public class CompleteOrderTest extends BaseTest{
	
	private AccountPage accountPage;
	public static final String ITEM_TO_SEARCH = "printed chiffon dress";
	private static final String ORDER_SUCCESS_MESSAGE = "Your order on My Shop is complete.";
	
	@BeforeMethod(description="user logs into the application and searches the product")
	public void checkOutSetup()
	{
		accountPage = homePage.goToLoginPage().enteringAndSubmittingCredentials("nococac422@aperiol.com","Rahul@nococac");
	}
	
	@Test(description="end to end order completion", retryAnalyzer = com.ui.listeners.RetryMechanism.class)
	public void completeOrder()
	{ 
		String orderMessage = accountPage.searchProduct(ITEM_TO_SEARCH).clickOnDesiredProduct(ITEM_TO_SEARCH).selectSize(Size.L).incrementItems().addToCart().proceedToCheckout().confirmCartSummary().confirmAddress().agreeTermsAndCondition().payByBankWire().confirmOrder().orderConfirmationMessage();
		Assert.assertEquals(orderMessage, ORDER_SUCCESS_MESSAGE);
	}
}
