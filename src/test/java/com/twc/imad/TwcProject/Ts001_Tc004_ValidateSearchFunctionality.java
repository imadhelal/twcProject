package com.twc.imad.TwcProject;

import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import com.twc.imad.TwcProject.Pages.SearchIcon;
import com.twc.imad.TwcProject.utilities.AbstractDriver;

public class Ts001_Tc004_ValidateSearchFunctionality extends AbstractDriver {
	private String testName="Ts001_Tc004_ValidateSearchFunctionality";
	private String Category="Regression Testing";

	
	@Test (description="Validate Search Functionality")
	
	private void verifySearchFunctionForKnownString(){
    startTest(testName, Category);
	search().clickOnSearchIcon();
	search().enterDataIntoSearchField("Cable");
	search().clickOnSearchGo();
	search().verifySearchforCable();
	search().clickOnSearchIcon();
	search().clearText();
	search().enterDataIntoSearchField("xwert");
	search().clickOnSearchGo();
	search().verifySearchforXwert();
	search().navigateBack();
	endTestWithPassStatus("Ts1Tc4ValidateSearchFunctionality");
	}
	
	
}
