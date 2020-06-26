package com.qa.orangehrm.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	
	XSSFWorkbook workbook;
	
	public ExcelDataProvider()
	{
		
		try 
		{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\orangehrm\\testdata\\Testdata.xlsx");
			workbook = new XSSFWorkbook(fis);
			//wb=new XSSFWorkbook(new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\orangehrm\\testdata\\Testdata.xlsx"));
		} catch (IOException e) {
			
			System.out.println("Exception while loading excel "+e.getMessage());
		}
		
	}
	
	public String getData(String sheetName,int row, int column) 
	{
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();		
	}
	

}
