package com.qa.orangehrm.unitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.orangehrm.factory.ConfigDataprovider;
import com.qa.orangehrm.factory.DataProviderFactory;
import com.qa.orangehrm.factory.ExcelDataProvider;

public class TestDataprovider {
	
	@Test
	public void excelTest() {
		ExcelDataProvider excel = new ExcelDataProvider();
		String actualData = excel.getData("Login", 0, 0);
		Assert.assertEquals(actualData, "Admin");
		
		
	}
	
	@Test
	public void configTest() {
		ConfigDataprovider config = new ConfigDataprovider();
		Assert.assertEquals(config.getdata("browser"), "chrome");
	}
	
	@Test
	public void excelTest1() {
		Assert.assertEquals(DataProviderFactory.getExcel().getData("Login", 0, 0),"Admin");
	}
	
	@Test
	public void configTest1() {
		Assert.assertEquals(DataProviderFactory.getConfig().getdata("browser"), "chrome");
	}

}
