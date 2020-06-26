package com.qa.orangehrm.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.orangehrm.factory.DataProviderFactory;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.BaseClass;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.pages.LogoutPage;
import com.qa.orangehrm.utility.AppConistents;
import com.qa.orangehrm.utility.ExcelUtil;

public class UsersPageTest extends BaseClass {

	LoginPage loginpage;
	HomePage homepage;
	AdminPage adminpage;
	LogoutPage logoutpage;
	

	@Test(priority = 1, description = "loginpage test")
	public void loginWithAdmin() {
		loginpage = new LoginPage(driver);
		PageFactory.initElements(driver, LoginPage.class);
		logger = report.createTest("LoginTest", "Login to HRM with valid credentials");
		homepage = loginpage.doLoginToApplication(DataProviderFactory.getExcel().getData("Login", 0, 0),
				DataProviderFactory.getExcel().getData("Login", 0, 1));
	}
	
	@Test(priority=2)
	public void homepageTest() {
		//homepage = new HomePage(driver);
		PageFactory.initElements(driver, HomePage.class);
		logger = report.createTest("HomeTest", "Laneded HomePage after successful login");
		adminpage = homepage.doAdmin();
	}
	
	@Test(priority=3)
	public void adminPageTest() {
		String adminpagetitle = adminpage.getPageTitle();
		Assert.assertEquals(adminpagetitle, "OrangeHRM");
			
	}
	@DataProvider
	public Object[][] getUserTestData() {
		Object[][] data = ExcelUtil.getTestData(AppConistents.USERS_SHEET_NAME);
		return data;
	}
	@Test(priority=4,dataProvider = "getUserTestData")
	public void addUserTest(String Employeename,String username,String pswd,String cnfpswd) throws InterruptedException {
		adminpage.createNewUser(Employeename, username, pswd, cnfpswd);
		
	}

	@Test(priority = 5, description = "logout from application")
	public void logoutFromAdmin() {
		logoutpage = new LogoutPage(driver);
		PageFactory.initElements(driver, LogoutPage.class);
		logger = report.createTest("LogoutTest", "logout from current session");
		
		logoutpage.doLogoutFromApplication();

	}

}
