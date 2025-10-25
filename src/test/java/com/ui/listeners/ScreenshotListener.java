package com.ui.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;
import com.utility.ScreenshotUtility;

public class ScreenshotListener implements ITestListener{
	
	public void onTestFailure(ITestResult result) {


		String fileName = ScreenshotUtility.getScreenshot(result.getMethod().getMethodName());
		
		ExtentReportUtility.getExtentTest().addScreenCaptureFromPath(fileName);
		
		LoggerUtility.getLogger(this.getClass()).info("Screenshot taken for failed test " + result.getMethod().getMethodName());

}
	
}
