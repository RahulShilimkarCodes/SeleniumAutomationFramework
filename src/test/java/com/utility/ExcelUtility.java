package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.DataPOJO;

public class ExcelUtility {
	
	public static Iterator<DataPOJO> readExcelFile(String fileName) 
	{
		File dataFile = new File(System.getProperty("user.dir")+"//testData//"+fileName);
		
		XSSFWorkbook readWorkbook = null;
		try {
			readWorkbook = new XSSFWorkbook(dataFile);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet readSheet = readWorkbook.getSheet("LoginTestData");
		
		Iterator<Row> navigatingRows = readSheet.iterator();
		
		List<DataPOJO> userList = new ArrayList<>();
		DataPOJO userData ; 
		navigatingRows.next();		//skipping first row/header...
		
		while(navigatingRows.hasNext())
		{
			Row rowValue = navigatingRows.next();
			
			Cell emailAddress = rowValue.getCell(0);
			Cell password = rowValue.getCell(1);
			
			userData = new DataPOJO(emailAddress.toString(),password.toString());
			userList.add(userData);
			
			try {
				readWorkbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		
		return userList.iterator();
		
		
	}

}


