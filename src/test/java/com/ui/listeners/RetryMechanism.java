package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Environments;
import com.utility.JSONUtility;
import com.utility.PropertiesUtility;

public class RetryMechanism implements IRetryAnalyzer{
	
	private static final int MAX_NUMBER_OF_RETRY_ATTEMPTS = Integer.parseInt(PropertiesUtility.readProperties(Environments.QA, "MAX_NUMBER_OF_RETRY_ATTEMPTS"));

	//private static final int MAX_NUMBER_OF_RETRY_ATTEMPTS = JSONUtility.readJson(Environments.QA).getMaxAttempts();
	
	private static int current_attempt_number = 1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(current_attempt_number <= MAX_NUMBER_OF_RETRY_ATTEMPTS)
		{
			current_attempt_number++;
			return true;
		}
		
		return false;
	}
	

}
