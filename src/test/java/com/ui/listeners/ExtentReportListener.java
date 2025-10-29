package com.ui.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.utility.ExtentReportUtility;

public class ExtentReportListener implements ITestListener{
	
	
	  public void onStart(ITestContext context) {
		    ExtentReportUtility.setUpSparkReporter("testExtentReport");
	  }
	
	  public void onTestStart(ITestResult result) {
		  ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	  }

	  public void onTestSuccess(ITestResult result) {
		  ExtentReportUtility.getExtentTest().log(Status.PASS, result.getMethod().getMethodName()+"    => PASSED");
	  }

	  public void onTestFailure(ITestResult result) {
		  ExtentReportUtility.getExtentTest().log(Status.FAIL, result.getMethod().getMethodName()+"    => FAILED");
		  ExtentReportUtility.getExtentTest().log(Status.FAIL,result.getThrowable().getMessage());
	  }

	  public void onTestSkipped(ITestResult result) {
		  ExtentReportUtility.getExtentTest().log(Status.SKIP, result.getMethod().getMethodName()+"    => SKIPPED");
	  }

	  public void onFinish(ITestContext context) {
		  ExtentReportUtility.flushReport();
	  }
	
	

}
