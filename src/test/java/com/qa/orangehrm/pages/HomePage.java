package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.utility.AppConistents;
import com.qa.orangehrm.utility.ElementUtil;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//page locators - By
	By dashboard = By.xpath("//h1[contains(text(),'Dashboard')]");
	By user = By.xpath("//a[@class='panelTrigger']");
	By adminTab = By.xpath("//b[text()='Admin']");
	
	//page actions - in the form of methods
	public String getPageTitle() {
		ElementUtil.waitForTitlePresent(driver, AppConistents.HOME_PAGE_TITLE);
		return ElementUtil.doGetPageTitle(driver);
	}
	public String getPageHeader() {
		return ElementUtil.doGetText(driver, dashboard);
		
	}
	
	public String getUserName() {
		return ElementUtil.doGetText(driver,user);
		
	}
	public AdminPage doAdmin() {
		ElementUtil.waitForElementPresent(driver, adminTab);
		ElementUtil.waitForWebElementAndClick(driver, adminTab, "Click on Admin Tab");
		return new AdminPage(driver);
		
	}
	
	
	

}
