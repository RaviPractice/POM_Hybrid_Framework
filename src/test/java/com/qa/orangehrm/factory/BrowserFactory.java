package com.qa.orangehrm.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	
	public static WebDriver startBrowser(String browserName,String appUrl) {
		
		System.out.println("****LOG:INFO-Starting browser session****");
		WebDriver driver=null;
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\MukeshAutomation\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\MukeshAutomation\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\MukeshAutomation\\drivers\\IEDriverServer-32.exe");
			driver=new InternetExplorerDriver();
			
		}
		else {
			System.out.println("browser name :"+browserName + " is not correct please provide correct browser... ");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("****LOG:INFO-Browser session is up and Running****");
		
		return driver;
	}
	
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
		System.out.println("****LOG:INFO-Browser session terminated*****");
	}

}
