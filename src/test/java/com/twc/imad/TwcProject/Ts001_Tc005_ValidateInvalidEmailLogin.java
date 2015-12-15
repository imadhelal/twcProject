package com.twc.imad.TwcProject;

import org.testng.annotations.Test;

import com.twc.imad.TwcProject.utilities.AbstractDriver;

public class Ts001_Tc005_ValidateInvalidEmailLogin extends AbstractDriver {
	private String testName="Ts001_Tc005_ValidateInvalidEmailLogin";
	private String Category="Regression Testing";
	
	@Test (description="Email Verification")
	
	    private void emailValidation(){
		startTest(testName, Category);
		email().clickonEmail();
		startHandleWindow();
		email().enterEmailId("technosoft@gmail.com");
		email().enterEmailPassword("test1234");
		email().clickonLogIn();
		email().verifyInvalidLogin();
		endHandleWindow();
		endTestWithPassStatus("Ts1Tc5ValidateInvalidEmailLogin");
	}

}
