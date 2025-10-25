package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	public static String getScreenshot(String name)
	{
		
		File takingScreenshot = ((TakesScreenshot)BrowserUtility.getDriver()).getScreenshotAs(OutputType.FILE);
		
		Date date = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		
		String failureScreenshotPath = "./screenshots/"+name+"-"+timeStamp+".png";
		File failureScreenshot = new File(failureScreenshotPath);
			
		try {
			FileUtils.copyFile(takingScreenshot, failureScreenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return failureScreenshotPath;
	}

}
