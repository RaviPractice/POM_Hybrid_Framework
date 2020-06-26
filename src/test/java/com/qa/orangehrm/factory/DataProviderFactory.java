package com.qa.orangehrm.factory;

public class DataProviderFactory {
	
	public static ConfigDataprovider getConfig() {
		ConfigDataprovider config = new ConfigDataprovider();
		return config;
		
	}
	
	public static ExcelDataProvider getExcel() {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;
	}

}
