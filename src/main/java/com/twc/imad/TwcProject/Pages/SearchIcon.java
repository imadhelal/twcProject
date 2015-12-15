package com.twc.imad.TwcProject.Pages;

import org.openqa.selenium.WebDriver;

import com.twc.imad.TwcProject.utilities.BasePage;

public class SearchIcon extends BasePage {
	public static WebDriver driver=null;
	
	private String searchIcon="//*[@class='section newHeaderIcons']/descendant::a[5]";
	private String webEditsearch="//input[@name='search-q']";
	private String searchGo="//button[@title='search']";
	private String searchRsltXwertXpath=".//*[@ class='twc-box-column']/descendant::p";
	private String searchRsltForCable="What is the USB port on my cable modem used for?";
	private String searchRsltCableXpath="//div[@class='twc-box-column']//descendant::a[20]";
	private String searchRsltForxwert="Your search returned no matches. Please try again or Contact Us for more help.";
	//private String searchGoFromback="//button[@title='search']";

	public void verifySearchforCable(){
		String text=getText(getXpath(), searchRsltCableXpath);
		System.out.println(text);
		if (text.equals(searchRsltForCable)); 
		//assertValue(true);
		assertValue(true, "search result for 'cable'", "no", "cable");
	}
	public void verifySearchforXwert(){
		String text=getText(getXpath(), searchRsltXwertXpath);
		System.out.println(text);
		if (text.equals(searchRsltForxwert)); 
		//assertValue(true);
		assertValue(true, "search result for 'Xwert'", "no", "Xwert");
	}
	
	public SearchIcon(WebDriver driver) {
		this.driver=driver;
	}
	public void clickOnSearchIcon(){
		clickOnButton(getXpath(), searchIcon, "Clicked on search icon", "no", "Element not found");
	}
	public void enterDataIntoSearchField(String enterDataIntoSearch){
		enterDataIntoTextField(getXpath(), webEditsearch, enterDataIntoSearch, "Entered Data into search edit field", "no", "Element not found");
	}
	public void clickOnSearchGo(){
		clickOnButton(getXpath(), searchGo, "clicked on search button", "no", "Element not found");
	}
	/*public void clickOnSearchGoFromBack(){
		clickOnButton(getXpath(), searchGoFromback, "Clicked on search", "no", "Element not found");
	}*/
		
	public void clearText(){
		clearTextField(getXpath(), webEditsearch);
	}
	
	public void navigateBack(){
		   twcHome();
		   getPass("Navigate to home page");
	   }
}
