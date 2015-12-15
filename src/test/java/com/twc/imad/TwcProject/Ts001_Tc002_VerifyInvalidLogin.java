package com.twc.imad.TwcProject;

import org.testng.annotations.Test;

import com.twc.imad.TwcProject.Pages.MyAccountPage;
import com.twc.imad.TwcProject.utilities.AbstractDriver;

public class Ts001_Tc002_VerifyInvalidLogin extends AbstractDriver {


private String testName="Ts001_Tc002_VerifyInvalidLogin";
private String Category="Regression Testing";

@Test (description="Verify invalid Login")
  private void verifylogin(){
	startTest(testName, Category);
	myAcc().clickOnMyAccount();
	//myAcc().enterUserName("Technosoft");
	myAcc().enterUserNameWithHover("Technosoft");
	myAcc().enterPassword("Test1233");
	myAcc().clickOnsubmitSignIn();
	myAcc().verifyLoginErrorMsg();
	myAcc().navigateBack();
	endTestWithPassStatus("Ts1Tc2VerifyInvalidLogin");
}
 
}
