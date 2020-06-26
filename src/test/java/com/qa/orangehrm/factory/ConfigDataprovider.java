package com.qa.orangehrm.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataprovider {
	
	Properties prop;
	public ConfigDataprovider() {
		
		
		prop = new Properties();
		try {
			FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\orangehrm\\config\\config.properties");
			prop.load(fip);
			
		} catch (IOException e) {
			System.out.println(" some exception occur while loading config file..." + e.getMessage());
		}
			
	}
	public String getdata(String key) {
		return prop.getProperty(key);
	}
	

}
