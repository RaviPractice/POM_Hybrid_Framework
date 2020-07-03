package com.qa.orangehrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.orangehrm.factory.BrowserFactory;
import com.qa.orangehrm.factory.DataProviderFactory;
import com.qa.orangehrm.utility.ElementUtil;

public class BaseClass {

	public static ExtentReports report;
	public static ExtentTest logger;
	public WebDriver driver;

	@BeforeSuite
	public void setupReport() {
		System.out.println("****LOG:INFO - Setting up report****");
		ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Report/Selenium" +ElementUtil.getCurrentDateAndTime()+".html");
		report = new ExtentReports();
		report.attachReporter(html);
		System.out.println("****LOG:INFO - Reporting set****");
	}
	// please use this when you want to accept parameters from maven/gradle/jenkins
	
	@Parameters({"Browser","URL"})
	@BeforeClass
	public void startSession(String browserName,String appUrl) {
		System.out.println("****LOG:INFO - Starting Browser Session****");
		driver = BrowserFactory.startBrowser(browserName, appUrl);
		System.out.println("****LOG:INFO - Started Browser Session****");
	}
	
	//please use this if we want to continue with config/propertyfile

	/*@BeforeClass
	public void startSession() {
		System.out.println("****LOG:INFO - Starting Browser Session****");
		String browser = DataProviderFactory.getConfig().getdata("browser");
		String url = DataProviderFactory.getConfig().getdata("url");
		driver = BrowserFactory.startBrowser(browser, url);
		System.out.println("****LOG:INFO - Started Browser Session****");
	}*/
	
	@AfterClass
	public void closeSession() {
		System.out.println("****LOG:INFO - closing Browser Session****");
		BrowserFactory.closeBrowser(driver);
		System.out.println("****LOG:INFO - Closed Browser Session****");
		
	}

	@AfterMethod
	public void tearDownReport(ITestResult result) {
		System.out.println("****LOG:INFO -Collecting Result from Test****");
		if (ITestResult.SUCCESS == result.getStatus()) {
			try {
				logger.log(Status.PASS, "Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(ElementUtil.captureScreenshotNew(driver)).build());
			} catch (IOException e) {
				System.out.println("Exception " + e.getMessage());
				
			}
			
		} else if (ITestResult.FAILURE == result.getStatus()) {
			try {
				logger.log(Status.FAIL, "Test Failed "+ result.getThrowable().getMessage(),
				MediaEntityBuilder.createScreenCaptureFromPath(ElementUtil.captureScreenshotNew(driver)).build());
			} catch (IOException e) {

				System.out.println("Exception " + e.getMessage());
			}
		} else if (ITestResult.SKIP == result.getStatus()) {
			logger.log(Status.SKIP, "Test Skipped");
		}

		System.out.println("****LOG:INFO - Status updated in report****");
		report.flush();
	}

}
