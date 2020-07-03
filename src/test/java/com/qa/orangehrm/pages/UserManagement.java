package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.factory.DataProviderFactory;
import com.qa.orangehrm.utility.ElementUtil;

public class UserManagement {
	WebDriver driver;
	
	public UserManagement(WebDriver driver) {
		this.driver = driver;
		
	}
	// page locators
	
		By adminTab = By.xpath("//b[text()='Admin']");
		By addButton = By.id("btnAdd");
		By empname = By.xpath("//input[contains(@id,'systemUser_employeeName_empName')]");
		By username = By.xpath("//input[contains(@id,'systemUser_userName')]");
		By pswd = By.xpath("//input[contains(@id,'systemUser_password')]");
		By cnfpswd = By.xpath("//input[contains(@id,'systemUser_confirmPassword')]");
		By saveButton = By.xpath("//input[contains(@id,'btnSave')]");
		
		
		
		
		
		// page actions - methods
		
		public void createUser() {
		ElementUtil.waitForWebElementAndClick(driver, adminTab, "Click on AdminTab");
		ElementUtil.waitForWebElementAndClick(driver, addButton, "Click on Addbutton");
		ElementUtil.waitForWebElementAndType(driver, empname, DataProviderFactory.getExcel().getCellData("Users", 0, 0), "Enter employeename");
		ElementUtil.waitForWebElementAndType(driver, username, DataProviderFactory.getExcel().getCellData("Users", 0, 1), "Enter username");
		ElementUtil.waitForWebElementAndType(driver, pswd, DataProviderFactory.getExcel().getCellData("Users", 0, 2), "Enter password");
		ElementUtil.waitForWebElementAndType(driver, cnfpswd, DataProviderFactory.getExcel().getCellData("Users", 0, 3), "Enter confirmpswd");
		ElementUtil.waitForWebElementAndClick(driver, saveButton, "Click on Savebutton");
		
		}

}

