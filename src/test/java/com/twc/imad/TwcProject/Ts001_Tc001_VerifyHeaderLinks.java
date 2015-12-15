package com.twc.imad.TwcProject;

import org.testng.annotations.Test;


import com.twc.imad.TwcProject.utilities.AbstractDriver;

public class Ts001_Tc001_VerifyHeaderLinks extends AbstractDriver {
	
	private String testName="Ts001_Tc001_VerifyHeaderLinks";
	private String Category="Regression Testing";
	
	@Test (description="Verify Header Links")
	
	private void verifyLinks(){
	startTest(testName, Category);
	//twcHomePage().verifyYourHome();
	twcHomePage().alternateVerifyHome();
	twcHomePage().verifyDefultPage();
	twcHomePage().clickOnAboutUs();
	twcHomePage().navigateBack();
		 
	endTestWithPassStatus("Ts001_Tc001_VerifyHeaderLinks");
	}
	
    
	
}
