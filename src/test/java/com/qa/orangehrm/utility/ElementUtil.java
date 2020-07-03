package com.qa.orangehrm.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	
	
	
	public static void highLightElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 3px solid red;');", element);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
	}
	
	public static String getCurrentDateAndTime() {
		
		SimpleDateFormat dateformat = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		Date date = new Date();
		return dateformat.format(date);
		
	}
	
	public static WebElement getElement(WebDriver driver,By locator) {
		WebElement element = null;
		
		try {
		 element = driver.findElement(locator);
		}catch(Exception e) {
			System.out.println(" some exception occur while creating web element..: " +locator);
		}
		return element;
	}
	
	public static List<WebElement> getElements(WebDriver driver,By locator) {
		List<WebElement> elementsList = driver.findElements(locator);
		return elementsList;
	}
	
	/**
	 *  this method is used to capture the screenshot
	 * @return
	 */
	public static String captureScreenshot(WebDriver driver) {
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\Screenshot\\Selenium"+ElementUtil.getCurrentDateAndTime()+ ".png ";
		File destination = new File(path);
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			System.out.println("screenshot captured failed...");
		}
		return path;
	}
	public static String captureScreenshotNew(WebDriver driver)
	{
		
		String path=System.getProperty("user.dir")+"\\Screenshot\\Selenium"+ElementUtil.getCurrentDateAndTime()+".png";
		
		try 
		{
			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(path));
		} catch (IOException e) 
		{
			System.out.println("Could not capture screenshot "+e.getMessage());
		}
		
		return path;
	}
	
	/**
	 * this method is used to wait for web element and click
	 * @param locator
	 * @param value
	 * @param stepInfo
	 */
	public static void waitForWebElementAndClick(WebDriver driver,By locator,String stepInfo) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		highLightElement(driver,element);
		element.click();
		}catch(Exception e) {
			System.out.println(" some exception occur while clicking on webelement...");
		}
		
		System.out.println("LOG:INFO "+stepInfo);
		
	}
	/**
	 * this method is used to pass values to the element (sendkeys)
	 * @param locator
	 * @param value
	 * @param stepInfo
	 */
	
	public static void waitForWebElementAndType(WebDriver driver,By locator,String value ,String stepInfo) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.clear();
			highLightElement(driver,element);
			element.sendKeys(value);
			
			}catch(Exception e) {
				System.out.println(" some exception occur while passing values to webelement...");
			}
			
			System.out.println("LOG:INFO "+stepInfo);
		
	}
	/**
	 * this method is used to wait for web element
	 * @param locator
	 * @return
	 */
	
	public static WebElement waitForWebElement(WebDriver driver,By locator) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch(Exception e) {
			System.out.println("some exception occur while waiting webelement..");
		}
		return null;
		
	}
	/**
	 * this method is used to alert is present or not w.r.t to contains
	 * @param value
	 */
	
	public static void handleAlertAndVerifyPartialText(WebDriver driver,String value)
	{
		Alert alt=new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
		
		if(alt.getText().contains(value))
		{
			System.out.println("Alert text verified");
		}
		else
		{
			System.out.println("Alert text not verified- Failed");
		}
		
		alt.accept();
	}
	/**
	 * this method is used to alert is present or not w.r.t to equalsIgnorecaes
	 * @param value
	 */
	
	public static void handleAlertAndVerifyText(WebDriver driver,String value)
	{
		Alert alt=new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
		
		if(alt.getText().equalsIgnoreCase(value))
		{
			System.out.println("Alert text verified");
		}
		else
		{
			System.out.println("Alert text not verified- Failed");
		}
		
		alt.accept();
	}
	public static boolean waitForTitlePresent(WebDriver driver,String title) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}
	
	public static  String waitForTitleToBePresent(WebDriver driver,String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	public static boolean waitForElementPresent(WebDriver driver,By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	
	public static  boolean waitForElementVisible(WebDriver driver,By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}
	
	public static boolean doWaitForUrl(WebDriver driver,String url,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.urlContains(url));
	
		
	}
	
	public static Alert DoWaitForAlertToBePresence(WebDriver driver,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
		
		
	}
	
	public static String doGetPageTitle(WebDriver driver) {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occurred while getting the title.....");
		}
		return null;
	}
	
	public static void doClick(WebDriver driver,By locator) {
		try {
			getElement(driver,locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the web element.....");

		}
	}
	
	public static void doActionClick(WebDriver driver,By locator){
		try {
			WebElement ele = getElement(driver,locator);
			Actions action = new Actions(driver);
			action.click(ele);
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the web element.....");

		}
	}


	public static void doActionSendKeys(WebDriver driver,By locator, String value){
		try {
			WebElement ele = getElement(driver,locator);
			Actions action = new Actions(driver);
			action.sendKeys(ele, value);
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the web element.....");

		}
	}
	
	public static void doSendKeys(WebDriver driver,By locator, String value) {
		try {
			//wait visible
			WebElement ele = getElement(driver,locator);
			ele.clear();
			ele.sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception got occurred while entering value in a field.....");

		}
	}
	
	public static boolean doIsDisplayed(WebDriver driver,By locator) {
		try {
			waitForElementPresent(driver,locator);
			return getElement(driver,locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception got occurred.....");
		}
		return false;
	}
	
	public static String doGetText(WebDriver driver,By locator) {
		try {
			waitForElementPresent(driver,locator);
			return getElement(driver,locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occurred while getting the text from a webelement.....");
		}
		return null;
	}
	
	//dropdown utils - Select class utils
	
	
	public void doSelectByVisableText(WebDriver driver,By locator,String value) {
		Select select = new Select(getElement(driver,locator));
		select.selectByVisibleText(value);
	}
	
	public void doSelectByIndex(WebDriver driver,By locator,int index) {
		Select select = new Select(getElement(driver,locator));
		select.selectByIndex(index);
	}
	
	public void doSelectByValue(WebDriver driver,By locator,String value) {
		Select select = new Select(getElement(driver,locator));
		select.selectByValue(value);
		
	}
	
	public int doDropdownOptionsCount(WebDriver driver,By locator) {
		return doGetDropdownOptions(driver,locator).size();
		
	}
	
	
	public ArrayList<String> doGetDropdownOptions(WebDriver driver,By locator) {
		
		ArrayList<String> al = new ArrayList<String>();
		
		Select select = new Select(getElement(driver,locator));
		
		List<WebElement> optionList = select.getOptions();
		
		for(int i=0;i<optionList.size();i++) {
			String text = optionList.get(i).getText();
			al.add(text);
		
		}
		return al;
	}
	
	
	
	public void doSelectDropdownValue(WebDriver driver,By locator,String value) {
		
		Select dayselect = new Select(getElement(driver,locator));
		List<WebElement> dayList = dayselect.getOptions();
		
		for(int i=0;i<dayList.size();i++) {
			String text = dayList.get(i).getText();
			if(text.equals(value)) {
				dayList.get(i).click();
				break;
			}
		}
		
		
	}
	
	
	public void doSelectDropdownValueWithoutSelect(WebDriver driver,By locator,String value) {
		
		Select dayselect = new Select(getElement(driver,locator));
		List<WebElement> dayList = dayselect.getOptions();
		
		for(int i=0;i<dayList.size();i++) {
			String text = dayList.get(i).getText();
			if(text.equals(value)) {
				dayList.get(i).click();
				break;
			}
		}
		
		
		
	}
	
	
	
	public void selectChoiceValues(WebDriver driver,By locator,String...value) {
		List<WebElement> choiceList = getElements(driver,locator);
		
		if(!(value[0].equalsIgnoreCase("ALL"))) {
			
			for(int i=0;i<choiceList.size();i++) {
				String text = choiceList.get(i).getText();
				System.out.println(text);
				
				for(int k=0;k<value.length;k++) {
					if(text.equals(value[k])) {
						choiceList.get(i).click();
						break;
					}
				}
				
			}
		}
		
		// select all the values
		
		else {
			try {
				for(int all =0; all<choiceList.size();all++) {
					choiceList.get(all).click();
				}
				
			}catch(Exception e) {
				
			}
		}
		
	}
	
	
	// Action class -utlities
	
	public void doDragAndDrop(WebDriver driver,By source,By target) {
		
		Actions action = new Actions(driver);
		WebElement sourceEle = getElement(driver,source);
		WebElement destEle = getElement(driver,target);
		action.dragAndDrop(sourceEle, destEle).build().perform();
		
	}
	
	// click when ready
	
	public void clickWhenReady(WebDriver driver,By locator,int timeout) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	element.click();
	
	}
	public static void doSelectFrame(WebDriver driver,By frameId) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		}catch(Exception e) {
			System.out.println("user not able to switch to frame..");
		}
		
	}
	
}
