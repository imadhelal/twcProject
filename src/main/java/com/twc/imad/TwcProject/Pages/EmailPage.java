package com.twc.imad.TwcProject.Pages;

import org.openqa.selenium.WebDriver;

import com.twc.imad.TwcProject.utilities.BasePage;

public class EmailPage extends BasePage {
	public static WebDriver driver=null;
	
	public EmailPage(WebDriver driver) {
		this.driver=driver;
		}
	
	private String emailIcon="//*[@class='section newHeaderIcons']/descendant::a[3]";
	private String emailId="//input[@name='account']";
	private String password="//input[@name='password']";
	private String submit="//input[@id='loginButton']";
	private String xpathForErrorMsg="//div[@class='webmailErrorInfoTxt']";
	private String errorMsg="The email address or password is incorrect.";
	public void clickonEmail(){
		clickOnButton(getXpath(), emailIcon, "clicked on email", "no", "Email page open");
	}
	
	public void enterEmailId(String id){
		enterDataIntoTextField(getXpath(), emailId, id, "clicked on", "no", "Please entered correct Email ID ");
		
	}
	
	public void enterEmailPassword(String pass){
		enterDataIntoTextField(getXpath(), password, pass, "Email's Password Entered", "no", "invalid password");
		
	}
	public void clickonLogIn(){
		clickOnButton(getXpath(), submit, "clicked on email login", "no", "Email Id and Password should be match");
	}
	
	public void verifyInvalidLogin(){
		System.out.println( getText(getXpath(), xpathForErrorMsg));
		//assertValue(errorMsg, getText(getXpath(), xpathForErrorMsg));
		assertValue(getText(getXpath(), xpathForErrorMsg), errorMsg, "Email Id or Password maybe incorrect", "yes", "loged in");
	}
}
