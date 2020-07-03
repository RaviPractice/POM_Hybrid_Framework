package com.qa.orangehrm.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
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
	
	public String getCellData(String sheetName,int row,int column) {
		XSSFCell cell =workbook.getSheet(sheetName).getRow(row).getCell(column);
		String data = null;
		if(cell.getCellType()== CellType.STRING) {
			data = cell.getStringCellValue();
		}
		else if (cell.getCellType()== CellType.NUMERIC) {
			data =String.valueOf(cell.getStringCellValue());
		}
		else if (cell.getCellType()== CellType.BLANK) {
			data = "";
		}
		return data;
	}

}
