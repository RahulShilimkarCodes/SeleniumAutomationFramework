package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Environments;
import com.google.gson.Gson;
import com.ui.pojo.Environment;
import com.ui.pojo.JSONConfig;

public class JSONUtility {
	
	public static Environment readJson(Environments env) 
	{
		Gson gsonReader = new Gson();
		//to read data from json, we need to use external library called Gson.
		
		File jsonFile = new File(System.getProperty("user.dir")+"\\config\\config.json");
		
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONConfig jsonConfig = gsonReader.fromJson(fileReader, JSONConfig.class);
		
		Environment environment = jsonConfig.getEnvironments().get("QA");
		
		return environment;
		
	}

}
