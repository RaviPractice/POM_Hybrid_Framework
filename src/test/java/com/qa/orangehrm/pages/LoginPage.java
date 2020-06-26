package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.orangehrm.utility.ElementUtil;

public class LoginPage {
	public WebDriver driver;
	
	//page constructor - this will get driver instance from script that will reuse this
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	// Page Locators(elements) - using By
	
	 By username=By.id("txtUsername");
	 By password=By.xpath("//input[@id='txtPassword']");
	 By loginButton=By.id("btnLogin");
	
 // page actions - in the form of methods
	 
	 public HomePage doLoginToApplication(String userName,String pswd) {
		 ElementUtil.waitForWebElementAndType(driver,username, userName, "Enter username");
		 ElementUtil.waitForWebElementAndType(driver,password, pswd, "Enter password");
		 ElementUtil.waitForWebElementAndClick(driver,loginButton, "Click on loginbutton ");
		// Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"URL Does not has dashboard- Login Failed");
		 return new HomePage(driver);
		 
		  
	 }
}
