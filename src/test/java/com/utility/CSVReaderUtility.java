package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;	
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.DataPOJO;


public class CSVReaderUtility {
	
	public static Iterator<DataPOJO> readCSVFile(String fileName)
	{
		
		File csvFile = new File(System.getProperty("user.dir")+"\\testData\\"+fileName);
		
		FileReader csvfileReader = null;
		CSVReader csvReader;
		String[] userDetails;
		List<DataPOJO> userDetailsList = null;
		DataPOJO userData;
		
		
		try {
			csvfileReader = new FileReader(csvFile);
			csvReader = new CSVReader(csvfileReader);
			csvReader.readNext();							//Row-1 - headers/column name

			userDetailsList = new ArrayList<>();	
			
			while((userDetails = csvReader.readNext()) != null)
			{
				userData = new DataPOJO(userDetails[0],userDetails[1]);
				userDetailsList.add(userData);
			}
			
			//printing the data from CSV....
			for(DataPOJO user : userDetailsList)
			{
				System.out.println(user.getEmailAddress()+" "+user.getPassword());
			}
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		} 
		
		
		return userDetailsList.iterator();
	}

}
