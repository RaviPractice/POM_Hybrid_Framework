package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.utility.ElementUtil;

public class LogoutPage {
	public WebDriver driver;
	
	//page constructor 
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//page elements(Locators) - By
	By welcomeAdmin=By.xpath("//a[text()='Welcome Admin']");
	By logOff=By.xpath("//a[text()='Logout']");
	
	// page actions - in the form of methods
	
	public void doLogoutFromApplication() {
		
		ElementUtil.waitForWebElementAndClick(driver,welcomeAdmin, "Click on WelcomeAdmin button");
		ElementUtil.waitForWebElementAndClick(driver,logOff, "Click on logoff button");
	
	}

}
