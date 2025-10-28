package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

public class ProductPage extends BrowserUtility{
	
	private static final By SEARCHED_TEXT = By.xpath("//span[@class='lighter']");
	
	private static final By PRODUCT_NAMES = By.xpath("//h5[@itemprop='name']/a");
	
	public ProductPage(WebDriver driver)
	{
		super(driver);
	}
	
	public String getSearchedItemText()
	{
		return getVisibleText(SEARCHED_TEXT);
	}
	
	public void getProductNames()
	{
		getAllVisibleText(getListOfElements(PRODUCT_NAMES));
	}
	
	public List<String> getProductNamesList()
	{
		return getAllVisibleTextList(getListOfElements(PRODUCT_NAMES));
	}
	
	
	public boolean verifyProductNameMatch(String searchTerms)
	{
		List<String> allProductNames = getAllVisibleTextList(getListOfElements(PRODUCT_NAMES));
		
		List<String> keywordsList = Arrays.asList(searchTerms.toLowerCase().split(" "));
		
		boolean isMatched = allProductNames.stream()
		        .anyMatch(productName -> keywordsList.stream()
		                .anyMatch(productName.toLowerCase()::contains));
		
		return isMatched;
	}
	
	public ItemsPage clickOnDesiredProduct(String searchTerms)
	{
		List<WebElement> productLists = getListOfElements(PRODUCT_NAMES);
		
		for(WebElement product : productLists)
		{
			if(product.getText().equalsIgnoreCase(searchTerms))
			{
				clickOn(product);
				break;
			}
		}
		
		ItemsPage itemsPage = new ItemsPage(getDriver());
		return itemsPage;
	}

	
	
	
	
	

}
