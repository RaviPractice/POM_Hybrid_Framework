package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.orangehrm.utility.AppConistents;
import com.qa.orangehrm.utility.ElementUtil;


public class AdminPage {
	public WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}
	//page elements - By
	 By addButton = By.xpath("//input[@value='Add']");
	 By deleteButton = By.xpath("//input[@id='btnDelete']");
	 //Add user - By locators
	 By employeeName = By.xpath("//label[text()='Employee Name']//following::input[1]");
	 By username = By.xpath("//label[text()='Username']//following::input[1]");
	 By passWord = By.xpath("//label[text()='Password']//following::input[1]");
	 By cnfPassword = By.xpath("//label[text()='Confirm Password']//following::input[1]");
	 By saveButton = By.xpath("//input[@value='Save']");
	
	//page actions - form of methods
	 public String getPageTitle() {
		 ElementUtil.waitForTitlePresent(driver, AppConistents.ADMIN_PAGE_TITLE);
		 
			return ElementUtil.doGetPageTitle(driver);
	 }
	
	 public void createNewUser(String empName,String userName,String pwd,String cnfpwd) throws InterruptedException {
		 ElementUtil.waitForElementPresent(driver, addButton);
		 ElementUtil.waitForWebElementAndClick(driver, addButton, "Click on Add button");
		 ElementUtil.waitForElementPresent(driver, employeeName);
		 ElementUtil.waitForWebElementAndType(driver, employeeName, empName, "Enter Employeename");
		 ElementUtil.waitForWebElementAndType(driver, username, userName, "Enter username");
		 ElementUtil.waitForWebElementAndType(driver, passWord, pwd, "Enter password");
		 ElementUtil.waitForWebElementAndType(driver, cnfPassword, cnfpwd, "Enter confirmpassword");
		 ElementUtil.waitForWebElementAndClick(driver, saveButton, "Click on save button");
		 Thread.sleep(3000);
		 
	 }

}
