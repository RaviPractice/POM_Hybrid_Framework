package com.qa.orangehrm.testcases;

import org.testng.annotations.Test;

import com.qa.orangehrm.factory.DataProviderFactory;
import com.qa.orangehrm.pages.BaseClass;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.pages.UserManagement;

public class CreateUser extends BaseClass {
	LoginPage loginpage;
	UserManagement user;
	
	
	@Test
	public void  createUsers() {
		logger = report.createTest("create user","this test will be create new user");
		loginpage = new LoginPage(driver);
		user = new UserManagement(driver);
		loginpage.doLoginToApplication(DataProviderFactory.getExcel().getCellData("Login", 0, 0),
				DataProviderFactory.getExcel().getCellData("Login", 0, 1));
		user.createUser();
		
		
		
		
	}	

}
