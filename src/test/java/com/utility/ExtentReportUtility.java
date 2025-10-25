package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	
	private static ExtentSparkReporter extentSparkReporter;		// provide with functionality to create HTML file(look,styling,etc of the report)..
	private static ExtentReports extentReports;		//to do heavy lifting - data to be dump/include/show in HTML file..
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();		//to have separate thread for each test...//to store info about test(status of test, timing,etc of the test)...
	
	public static void setUpSparkReporter(String reportName)
	{
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//"+reportName+".html");	//create report at this level
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);		//to attach the results/dump the info at the file...
		
	}
	
	public static void createExtentTest(String testName)
	{
		ExtentTest tests = extentReports.createTest(testName);			//creates a test info for the tests..
		extentTest.set(tests);
		
	}
	
	public static ExtentTest getExtentTest()
	{
		return extentTest.get();
	}
	
	public static void flushReport()
	{		
		extentReports.flush();		//dump/attach the data to HTML file..
	}
	

}
