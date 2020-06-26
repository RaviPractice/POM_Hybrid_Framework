package com.qa.orangehrm.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	public static Workbook workbook;
	public static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH = ".\\src\\test\\java\\com\\qa\\orangehrm\\testdata\\Testdata.xlsx";
	
	public static Object[][] getTestData(String sheetname) {
		
		try {
			FileInputStream fip = new FileInputStream(TESTDATA_SHEET_PATH);
			workbook = WorkbookFactory.create(fip);
			sheet = workbook.getSheet(sheetname);
			
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
					data[i][k] = sheet.getRow(i).getCell(k).toString();
					
				}
			}
			
			return data;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
