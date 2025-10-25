package com.ui.dataProviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.ui.pojo.DataPOJO;
import com.utility.ExcelUtility;

public class ExcelDataProvider {
	
	@DataProvider(name="ExcelDataProvider")
	public Iterator<DataPOJO> readExcelData()
	{
			return ExcelUtility.readExcelFile("loginData.xlsx");
	}
	
	/*
	 * Note:- DataProvider can have any of below 3 return type
	 * Object[]
	 * Object[][]
	 * Iterator<>
	 */

}
