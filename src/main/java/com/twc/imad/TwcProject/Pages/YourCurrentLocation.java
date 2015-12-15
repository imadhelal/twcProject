package com.twc.imad.TwcProject.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.twc.imad.TwcProject.utilities.BasePage;

public class YourCurrentLocation extends BasePage {
	public static WebDriver driver=null;

	private String currentLocationTab="//*[@class='section newHeaderIcons']/descendant::a[4]";
	private String editZipcode="//div[@class='message-box']/descendant::input[position()=1]";
	private String goButton="//button[@type='submit']";
	private String xpathForZipcode="//div[@class='newIcons horizontal list']/descendant::div[4]/a/span[2]";
	private String valueOfZipcode="10037";
	private String xpathMsgForInvalidZip="//div[@class='parsys oof-error-content']/self::div//p[2]";
	public YourCurrentLocation(WebDriver driver) {
			this.driver=driver;
		
	}

		public void clickOnZipcodeLogo(){
			//expectedCondition(By.xpath(currentLocationTab));
			clickOnButton(getXpath(), currentLocationTab, "Clicked on Zip Code Link", "no", "Zip Code web Edit Box Should Open");
			//System.out.println("click on location");
		}
		
		public void enterZipcode(String enterDataIntoZipCode){
			enterDataIntoTextField(getXpath(), editZipcode, enterDataIntoZipCode, "Data Entered into zip code", "no", " zipcode entered ");
		}		
		
		public void clearZipCode(){
		clearTextField(getXpath(), editZipcode);
		getPass("Clear text field");
		}
		public void clickOnGoButton(){
			clickOnButton(getXpath(), goButton, "clicked on Go button", "no", "null");
		}
		/*public void clickOnGoButton2(){
			clickOnButton(getXpath(), goButton, "clicked on Go button", "no", "null");
			twcHome();
		}*/
		
		public void verifyUpdatedZipCode(){
			String zipCodeName=getText(getXpath(), xpathForZipcode);
			assertValue(valueOfZipcode, zipCodeName, "Verified updated zipcode", "no", "Zipcode not updated");
			
		}
		
		public void verifyErrorMsgForInvalidZip(){
			String errorMsg=getText(getXpath(), xpathMsgForInvalidZip);
			String zipCode= getText(getXpath(), xpathForZipcode);
			String errorMsgForInvalidZipCode="Our services may not be available in "+zipCode+". If this is not your ZIP Code, please enter your ZIP Code here. If it is correct, visit cablemover.com to contact the cable provider that serves your area or call 1-855-394-6832 FREE.";
		    System.err.println(zipCode);
		    System.out.println(errorMsg);
			assertValue(errorMsgForInvalidZipCode, errorMsg);
		}
		
		public void conditionalWait(){
			//expectedCondition(By.xpath(currentLocationTab));
			fluentWait(By.xpath(xpathForZipcode));
			wait.until(fwait).getText();
		}
		public void navigateBack(){
			   twcHome();
			   getPass("Navigate to home page");
		   }
}
