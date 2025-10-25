package com.ui.dataProviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.ui.pojo.DataPOJO;
import com.utility.CSVReaderUtility;

public class CSVDataProvider {
	
	@DataProvider(name="CsvDataProvider")
	public Iterator<DataPOJO> loginCSVData()
	{
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}

}
