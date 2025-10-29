package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {		//abstract class can have constructor, but no object can be created.
	
	//private WebDriver driver;		//instance variable, stored in heap..default value is null
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();		//thread-safe driver for each test...
	private static WebDriverWait wait; 
	
	public BrowserUtility(WebDriver driver)
	{
		 	BrowserUtility.driver.set(driver);		//initialize the instance variable - driver..
		 	wait = new WebDriverWait(driver,Duration.ofSeconds(10L));
	}
	
	public BrowserUtility(String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10L));
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10L));
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10L));
		}
		else
		{
			throw new IllegalArgumentException("Invalid browser: " + browserName);
		}
	}
	
	public BrowserUtility(Browser browserName)
	{
		if(browserName==Browser.CHROME)
		{
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10L));
		}
		else if(browserName==Browser.EDGE)
		{
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10L));
		}
		else if(browserName==Browser.FIREFOX)
		{
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10L));
		}
	}
	
	// to test in headless mode..
	public BrowserUtility(Browser browserName, boolean isHeadLess)
	{
		if(browserName==Browser.CHROME)
		{   
		    if(isHeadLess)
		    {
		    	ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old"); // headless
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10L));
		    }
		    else {
		    	driver.set(new ChromeDriver());
		    	wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10L));
		    }
		    
		}
		
		else if(browserName==Browser.EDGE)
		{
			if (isHeadLess) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10L));
			}

			else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10L));

			}
			
		}
		else if(browserName==Browser.FIREFOX)
		{
			if(isHeadLess)
			{
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");		//browser in headless mode..
				options.addArguments("--disable-notifications");
				options.addArguments("--disable-gpu");
				options.addArguments("--window-size=1920,1080");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10L));
			}
			else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10L));
			}
		}
	}
	
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	public static void launchWebsite(String url)
	{
		getDriver().get(url);
	}
	
	public static void maximizeBrowser()
	{
		getDriver().manage().window().maximize();
	}
	
//	public static void clickOn(By locator)
//	{
//		WebElement element = getDriver().findElement(locator);
//		element.click();
//	}
	public static void checkOn(By locator)
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}
	
	public static void clickOn(By locator)
	{
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public static void clickOn(WebElement element)
	{
		element.click();
	}
	
	public static void jsClickOn(By locator)
	{
		WebElement element = getDriver().findElement(locator);
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void jsScrollToElement(By locator)
	{
		WebElement element = getDriver().findElement(locator);
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void enterText(By locator , String text )
	{
		//WebElement element = getDriver().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text);
	}
	
	public static void clearText(By locator)
	{
		//WebElement element = getDriver().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
	}
	
	public static String getVisibleText(By locator)
	{
		//WebElement visibleText = getDriver().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();
	}
	
	
	
	public static List<WebElement> getListOfElements(By locator)
	{
		//List<WebElement> products = getDriver().findElements(locator);
		List<WebElement>  products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return products;
	}
	
	public static void getAllVisibleText(List<WebElement>  elements)
	{
		for(WebElement element : elements)
		{
			//System.out.println(element.getText());
			System.out.println(getVisibleText(element));
		}

	}
	
	public static List<String> getAllVisibleTextList(List<WebElement>  elements)
	{
		List<String> productsText = new ArrayList<>();
		
		for(WebElement element : elements)
		{
			productsText.add(getVisibleText(element));
		}
		
		return productsText;
	}
	
	public static String getVisibleText(WebElement element)
	{
		return element.getText();
	}
	
	public static Select enterDropdown(By locator)
	{
		WebElement dropdownElement = getDriver().findElement(locator);
		Select sc = new Select(dropdownElement);
		return sc;
	}
	
	public static void selectOptionByVisibleText(By locator, String visibleText)
	{
		enterDropdown(locator).selectByVisibleText(visibleText);
	}
	
	public static void selectOptionByValue(By locator, String value)
	{
		enterDropdown(locator).selectByValue(value);
	}
	
	public static void selectOptionByIndex(By locator, int index)
	{
		enterDropdown(locator).selectByIndex(index);
	}
	
	public static void acceptAlert()
	{
		getDriver().switchTo().alert().accept();
	}
	
	public static void dismissAlert()
	{
		getDriver().switchTo().alert().accept();
	}
	
	public static void printStringList(List<String> listValue)
	{
		for(String list : listValue)
		{
			System.out.println(list);
		}
	}
	
	
	public static void quitDriver()
	{
		if(getDriver() != null)
		{
			getDriver().quit();
			driver.remove();		// cleanup ThreadLocal reference/memory
		}
	}

}
