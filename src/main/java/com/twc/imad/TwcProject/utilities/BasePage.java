package com.twc.imad.TwcProject.utilities;


import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TimeBombSkipException;
import com.google.common.base.Function;

public class BasePage extends AbstractDriver {
	
	private final static String xpath="xpath";
	private final static String id ="id";
	private final static String cssSelector="css";
	private final static String name="name";
	public static FluentWait<WebDriver> wait = null;
	public static Function<WebDriver, WebElement> fwait = null;
	
	
	
	public static String getXpath() {
		return xpath;
	}
	
	public static String getID(){
		return id;
	}
	
	
	
	public static String getCssSelector(){
		return cssSelector;
	}
	
	public static String getName(){
		return name;
	}
	private void getShowStopperStatus(String blocker, String errorMessage) {

		String showStopper = blocker;

		if (showStopper.equalsIgnoreCase("yes")) {
			twcHome();
			getWarning("Exception : "
					+ new NoSuchElementException(errorMessage));
			throw new NoSuchElementException(errorMessage);
		} else if (showStopper.equalsIgnoreCase("no")) {
			getWarning("Exception : "
					+ new NoSuchElementException(errorMessage));
			Reporter.log(errorMessage);
		}

	}
	// This method is used to click button with hover
		public void clickButtonWithHover(String parentLocator,
				String parentAttribute, String childLocator, String childAttribute,
				String passMessage, String blocker, String errorMessage) {
			try {
				WebElement parent = getElement(parentLocator, parentAttribute);
				WebElement child = getElement(childLocator, childAttribute);

				Actions action = new Actions(driver);
				action.moveToElement(parent).moveToElement(child).click().build()
						.perform();
				getPass(passMessage);
			} catch (NoSuchElementException | TimeoutException e) {
				getShowStopperStatus(blocker, errorMessage);
			}
		}
		// This method is used for entering text on text field with hover
				public void enterDataIntoTextFieldWithHover(String parentLocator,
						String parentAttribute, String childLocator, String childAttribute, String value,
						String passMessage, String blocker, String errorMessage) {

					try {
						WebElement parent = getElement(parentLocator, parentAttribute);
						WebElement child = getElement(childLocator, childAttribute);

						Actions action = new Actions(driver);
						//Action act = action.moveToElement(parent).build();
						
						action.moveToElement(parent).moveToElement(child).click().sendKeys(value).build().perform();
						getPass(passMessage);
					} catch (NoSuchElementException | TimeoutException e) {
						getShowStopperStatus(blocker, errorMessage);
					}

				}
	
	
	//click on button
	public void clickOnButton(String locator, String attributeOfLocator,
			String passMessage, String blocker, String errorMessage) {
		try {
			WebElement ele = getElement(locator, attributeOfLocator);
			ele.click();
			getPass(passMessage);
		} catch (NoSuchElementException | TimeoutException e) {
			getShowStopperStatus(blocker, errorMessage);
		}
	}
	/*public void clickOnButton(String locator, String attributeLocator){
		try{
			WebElement ele= getElement(locator, attributeLocator);
			ele.click();
		} catch (NoSuchElementException e){
			e.printStackTrace();
			Reporter.log("No Such Element Found Exception Occured on: "
			+locator +"  " +attributeLocator);
		}
		
	}*/
	
	public String getText(String locator, String attributeLocator){
		try{
			WebElement ele= getElement(locator, attributeLocator);
			return ele.getText();
		} catch (NoSuchElementException e){
			e.printStackTrace();
			Reporter.log("No Such Element Found Exception Occured on: "
			+locator +"  " +attributeLocator); 
			return locator;
		}
		
	}
	//Clear Text field
	public void clearTextField(String locator, String attributeLocator){
		WebElement ele=getElement(locator, attributeLocator);
		ele.clear();
	}
	public void enterDataIntoTextField(String locator,
			String attributeOfLocator, String value, String passMessage,
			String blocker, String errorMessage) {

		try {
			WebElement ele = getElement(locator, attributeOfLocator);
			ele.sendKeys(value);
			getPass(passMessage);
		} catch (NoSuchElementException | TimeoutException e) {
			getShowStopperStatus(blocker, errorMessage);
		}

	}
	//Fluent Wait
		public void fluentWait(By locator){
			
			wait = new FluentWait<WebDriver>(driver);
			wait.withTimeout(30, TimeUnit.SECONDS);
			wait.pollingEvery(3, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			
			fwait = new Function<WebDriver, WebElement>() {

				@Override
				public WebElement apply(WebDriver arg0) {
					return arg0.findElement(locator);
				}

				
			};
		}
	
	/*//Enter data into text field
	public void enterDataIntoTextField(String locator, String attributeLocator,
			String value){
		WebElement ele= getElement(locator, attributeLocator);
		ele.sendKeys(value);
	}*/
	
		
		// This method is use assert value from web Page
		public  void assertValue (WebElement expected, String actualResult) {
			Assert.assertEquals(expected, actualResult);
		}

		public void assertValue(String expected, String actualResult) {
			Assert.assertEquals(expected, actualResult);
		}

		public void assertValue(boolean expected, String actualResult) {
			Assert.assertEquals(expected, actualResult);
		}
		public void assertValue(boolean expected) {
			Assert.assertTrue(expected);
		}
		//=============
		public void assertValue(String actualResult, String expected,
				String passMessage, String blocker, String errorMessage) {

			try {
				Assert.assertEquals(actualResult, expected);
				getPass(passMessage);
			} catch (NoSuchElementException | TimeoutException | AssertionError e) {
				getShowStopperStatus(blocker, errorMessage);
				e.printStackTrace();
			}
		}
		public void assertValue(boolean expected, String passMessage,
				String blocker, String errorMessage) {

			try {
				Assert.assertTrue(expected);
				getPass(passMessage);
			} catch (NoSuchElementException | TimeoutException | AssertionError e) {
				getShowStopperStatus(blocker, errorMessage);
				e.printStackTrace();
			}
		}
		 /*public void selectDropDown (String locator, String attributeLocator,
		 String value){
	     WebElement ele = getElement(locator, attributeLocator);
	     Select dropDown = new Select(ele);
	     dropDown.selectByValue(value);
         }*/

    public Select selectDropDown (String locator, String attributeLocator){
	WebElement ele = getElement(locator, attributeLocator);
	Select dropDown = new Select(ele);
	return dropDown;
			
}

    public void expectedCondition(By locator){
	WebDriverWait expectedWaits = new WebDriverWait(driver, 30);
	expectedWaits.pollingEvery(2, TimeUnit.SECONDS);
	expectedWaits.until(ExpectedConditions.visibilityOfElementLocated(locator));

	
}

	   
	
	

}
