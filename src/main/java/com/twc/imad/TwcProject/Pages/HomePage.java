package com.twc.imad.TwcProject.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.inject.spi.DependencyAndSource;
import com.twc.imad.TwcProject.utilities.BasePage;

public class HomePage extends BasePage{
	public static WebDriver driver=null;

	public String yourHome="//div[@class='section list']/ul/li[1]/div/a";  //deafultPage
	public String yourBusiness="//div[@class='section list']/ul/li[2]/div/a";
	public String TwcCentral="//div[@class='section list']/ul/li[3]/div/a";
	public String AboutUs="//div[@class='section list']/ul/li[4]/div/a";
	public String InvestorRelations="//div[@class='section list']/ul/li[5]/div/a";
	public String careers="//div[@class='section list']/ul/li[6]/div/a";
	public String Espanol="//div[@class='section list']/ul/li[7]/div/a";
	public String xpathDefaultPage="//div[@class='section list']/ul/li[1]/div/a";
	public String stringDefaultPage="Your Home";
	
	public String manueList="//div[@class='section list']/ul/li";
	public String[] headerList={"Your Home","Your Business","TWC Central","About Us","Investor Relations","Careers","Español"};
	
	
	
	
	
    public HomePage(WebDriver driver) {
    	this.driver=driver;
		
	}
    
    public void alternateVerifyHome(){
    	List<WebElement> list=driver.findElements(By.xpath(manueList));
    	if(list.size()>0){
    		/*for(WebElement item :list){
    			String expected =headerList[list.indexOf(item)];
    			assertValue(item.getText(), expected, expected+" Found", "no", expected+"not Found");
    			
    		}*/
    		for(int i=0; i<list.size(); i++){
    			String expected =headerList[i];
    			assertValue(list.get(i).getText(), expected, expected+" Found", "no", expected+"not Found");
    			
    		}
    	}
    	
    }
    
	public void verifyYourHome(){
	//assertValue("Your Home", getText(getXpath(), yourHome));
	assertValue(getText(getXpath(), yourHome), "Your Home", "'Your Home' manue exist", "no", "Your_Home manue not exist");
	
	//assertValue( "Your Business", getText(getXpath(), yourBusiness));
	assertValue(getText(getXpath(), yourBusiness), "Your Business", "'Your Business' manue exist", "no", "Your Business manue not exist");
	
	//assertValue("TWC Central",getText(getXpath(), TwcCentral) );
	assertValue(getText(getXpath(), TwcCentral), "TWC Central", "'TWC Central' manue exist", "no", "'TWC Central' manue not exist");
	
	//assertValue("About Us", getText(getXpath(), AboutUs));
	assertValue(getText(getXpath(), AboutUs), "About Us", "'About Us' manue exist", "no", "'About Us' manue not exist");
	
	//assertValue("Investor Relations", getText(getXpath(), InvestorRelations));
	assertValue(getText(getXpath(), InvestorRelations), "Investor Relations", "'Investor Relations' manue exist", "no", "'Investor Relations' not exist");
	
	//assertValue("Careers", getText(getXpath(), careers));
	assertValue(getText(getXpath(), careers), "Careers", "'Careers' manue exist", "no", "'Careers' manue not exist");
	
	//assertValue("Español", getText(getXpath(), Espanol));
	assertValue(getText(getXpath(), Espanol), "Español", "'Español' manue exist", "no", "'Español' manue not exist");
	
	}
	
	public void verifyDefultPage(){
		
	 assertValue(stringDefaultPage, getText(getXpath(), xpathDefaultPage));
	}
	
	public void clickOnAboutUs(){
		clickOnButton(getXpath(), AboutUs, "click on about us","No" , "link not found");
	}
	
   public void navigateBack(){
	   twcHome();
	   getPass("Navigate to home page");
   }
     
	
}
