package com.ui.dataProviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.DataPOJO;
import com.ui.pojo.TestDataJSON;

public class JSONDataProvider {
	
	@DataProvider(name = "LoginTestData")
	public Iterator<Object[]> loginDataProvider()
	{
		Gson gson = new Gson();
		
		File testData = new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
		
		FileReader fileReader = null;
		
		try {
			fileReader = new FileReader(testData);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		TestDataJSON jsonTestData = gson.fromJson(fileReader, TestDataJSON.class);			//de-derialization
		
		List<Object[]> dataArray = new ArrayList<Object[]>();
		
		for(DataPOJO user : jsonTestData.getData())			//get individual data one by one
		{
			dataArray.add(new Object[] {user});
		}
		
		return dataArray.iterator();
	}

}
