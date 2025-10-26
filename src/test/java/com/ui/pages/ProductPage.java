package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	
	public boolean verifyProductNameMatch(String searchTerms)
	{
		List<String> allProductNames = getAllVisibleTextList(getListOfElements(PRODUCT_NAMES));
		
		List<String> keywordsList = Arrays.asList(searchTerms.toLowerCase().split(" "));
		
		boolean isMatched = allProductNames.stream()
		        .anyMatch(productName -> keywordsList.stream()
		                .anyMatch(productName.toLowerCase()::contains));
		
		return isMatched;
	}
	
	
	
	
	

}
