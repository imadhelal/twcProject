package com.twc.imad.TwcProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

import com.twc.imad.TwcProject.utilities.BasePage;

public class MyAccountPage extends BasePage {
	public static WebDriver driver=null;
	
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String myAccountTab="//div[@class='twc-new-nav list']/ul/li[4]/div";
	public String userName="username";
	public String password="password";
	public String submitSignIn="form_submit";
	public String errorMsgXpath="//div[@class='alert alert-warning']/div[@class='message'";
	public String loginErrorMsg1="Sorry, that username and password combination does not exist. Would you like to try again?";
	public String loginErrormsg2="Sorry, we are still unable to validate that username and password combination. If you're not sure of your username or password, you can recover them below. ";
	public String loginErrormsg3="Sorry, you've tried to sign in too many times. To protect your information, we've locked your account. Please recover your username or reset your password to continue.";
    public String xpathForErrormsg="//div[@class='message']";

	public void verifyLoginErrorMsg(){
	String errorTxt =getText(getXpath(), xpathForErrormsg);
	System.out.println(errorTxt);
	if (errorTxt.equals(loginErrorMsg1)||errorTxt.equals(loginErrormsg2)||errorTxt.equals(loginErrormsg3)) {
		//assertValue(true);
		assertValue(true, "Verify login message", "no", "login");
	}
	else assertValue(false, "Verify login message", "no", "login");;
	
	}

	public void clickOnMyAccount(){
		clickOnButton(getXpath(), myAccountTab, "Clicked on Account Tab", "no", "Acoount Tab should open");
	}
	

	public void enterUserName(String enterDataIntoWebEdit){
		enterDataIntoTextField(getID(), userName, enterDataIntoWebEdit, "Entered User Name", "no", "Please check your user Id and Password");
	}
	public void enterPassword(String enterDataIntoWebEdit){
		enterDataIntoTextField(getID(), password, enterDataIntoWebEdit, "Password Entered", "no", "Please check your user Id and Password");
	}
	
	public void clickOnsubmitSignIn() {
		clickOnButton(getID(),submitSignIn, "Id and Password Entered", "no", "Id and Password should correct");
	}
	
	public void enterUserNameWithHover(String value){
			
		enterDataIntoTextFieldWithHover(getXpath(), myAccountTab, getID(), userName, value,"User id entered",  "no", "Unable to enterd user ID"); 
	   
	}
	public void navigateBack(){
		   twcHome();
		   getPass("Navigate to home page");
	   }


}
