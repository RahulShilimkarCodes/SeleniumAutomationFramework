package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Environments;

public class PropertiesUtility {
	
	public static String readProperties(Environments env , String propertyName)
	{
		
		File propFile = new File(System.getProperty("user.dir")+"//config//"+env+".properties");
		
		FileReader fileReader = null;
		
		Properties properties = new Properties();
		
		try {
			fileReader = new FileReader(propFile);
			
			properties.load(fileReader);
			
		} catch (FileNotFoundException e) {				//compile time exception..
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 catch (IOException e) {				//compile time exception..
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String propertyValue = properties.getProperty(propertyName.toUpperCase());			//this will fetch value from property file(baseUrl)
		
		return propertyValue;
		
		
		
	}

}
