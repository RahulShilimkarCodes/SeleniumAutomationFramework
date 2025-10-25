package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
	//we will do global setup for logger..it will be accessible for all the components..
	//Design pattern - this ensure's that we are following correct OOPs principle..
	
	//DP we used are POJO and Page Object Model
	//Singleton Design Pattern we will be using now to generate logs..it means class can have only one object creation..
	//SDP is used for DB connectivity, loggers and WebDriver creation.
	
	//note:- In Singleton Class - constructors are always going to be private..
	//when constructor is private, you can create object of class only in the Original Class and cannot create anywhere outside the class..
	
	private LoggerUtility()
	{
		
	}
	
	public static Logger getLogger(Class<?> clazz)
	{
		Logger logger = null;
		
		logger = LogManager.getLogger(clazz);
		
		return logger;
	}
	

}
