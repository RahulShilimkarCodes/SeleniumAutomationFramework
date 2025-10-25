package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {
	
	 public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	 private static ThreadLocal<WebDriver> localDriver = new ThreadLocal<WebDriver>();
	 private static ThreadLocal<DesiredCapabilities> Localcapabilities = new ThreadLocal<DesiredCapabilities>();
	
	public static WebDriver intiliazelambdaTestSessionSetup(String browserName, String testName)
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "silimkarr");
        ltOptions.put("accessKey", "LT_CXHagMNDl9tuXHMUUYkxTUf9IxCNT84GP0bB1TABUnnnDL2");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        Localcapabilities.set(capabilities);
        WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(HUB_URL), Localcapabilities.get());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		localDriver.set(driver);
		
		return localDriver.get();
        
	}
	
	public static void quitLambdaSession()
	{
		if(localDriver.get() != null)
		{
			localDriver.get().quit();
			localDriver.remove();
		}
	}

}
