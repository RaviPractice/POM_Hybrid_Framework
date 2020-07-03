package com.qa.orangehrm.testcases;

import org.testng.annotations.Test;

import com.qa.orangehrm.factory.DataProviderFactory;
import com.qa.orangehrm.pages.BaseClass;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.pages.LogoutPage;

public class LoginTest extends BaseClass {

	LoginPage loginpage;
	LogoutPage logoutpage;

	@Test(priority = 1, description = "loginpage test")
	public void loginWithAdmin() {
		loginpage = new LoginPage(driver);
		//PageFactory.initElements(driver, LoginPage.class);//comment page factory
		logger = report.createTest("LoginTest", "Login to HRM with valid credentials");
		loginpage.doLoginToApplication(DataProviderFactory.getExcel().getCellData("Login", 0, 0),
				DataProviderFactory.getExcel().getCellData("Login", 0, 1));
	}

	@Test(priority = 2, description = "logout from application")
	public void logoutFromAdmin() {
		logoutpage = new LogoutPage(driver);
		//PageFactory.initElements(driver, LogoutPage.class);//comment on pagefactory
		logger = report.createTest("LogoutTest", "logout from current session");
		logoutpage.doLogoutFromApplication();

	}

}
