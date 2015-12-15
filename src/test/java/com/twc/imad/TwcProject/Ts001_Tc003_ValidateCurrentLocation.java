package com.twc.imad.TwcProject;



import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.twc.imad.TwcProject.Pages.HomePage;
import com.twc.imad.TwcProject.utilities.AbstractDriver;

public class Ts001_Tc003_ValidateCurrentLocation extends AbstractDriver{
	private String testName="Ts001_Tc003_ValidateCurrentLocation";
	private String Category="Regression Testing";

	@Test //(priority=1, description="Verify your location")
	
	   public void verifyCurrentLocation() throws InterruptedException {
		startTest(testName, Category);
		currentLocation().clickOnZipcodeLogo();
		currentLocation().clearZipCode();
		currentLocation().enterZipcode("10037");
		currentLocation().clickOnGoButton();
		//currentLocation().conditionalWait();
	    Thread.sleep(5000);
		currentLocation().clickOnZipcodeLogo();
		currentLocation().verifyUpdatedZipCode();
		currentLocation().clearZipCode();
		currentLocation().enterZipcode("32432");
		currentLocation().clickOnGoButton();
		Thread.sleep(10000);
		currentLocation().verifyErrorMsgForInvalidZip();
		currentLocation().navigateBack();
		endTestWithPassStatus("Ts1Tc3ValidateCurrentLocation");
	}
	
	
	
}

