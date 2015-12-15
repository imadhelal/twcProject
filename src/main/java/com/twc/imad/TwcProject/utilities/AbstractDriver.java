package com.twc.imad.TwcProject.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.twc.imad.TwcProject.Pages.EmailPage;
import com.twc.imad.TwcProject.Pages.HomePage;
import com.twc.imad.TwcProject.Pages.MyAccountPage;
import com.twc.imad.TwcProject.Pages.SearchIcon;
import com.twc.imad.TwcProject.Pages.YourCurrentLocation;


public abstract class AbstractDriver {
	public static WebDriver driver=null;
	private String url= "http://www.timewarnercable.com";
	public static ExtentReports extentReport = null;
	public static ExtentTest extentTest = null;
	private File locaFilePath = new File("screenshot").getAbsoluteFile();
	private String parentWindow=null;
	private Set<String> handles=null;
	//private String localFilePath="C:\Users\Imad\workspace-09-01-15\TwcProject\screenShot";

	@BeforeSuite
	public void setUp(){
		getInstance();
		driver= new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "C:/Users/Imad/workspace-09-01-15/TwcProject/chrome/chromedriver.exe");
		//driver=new ChromeDriver();
		twcHome();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.manage().deleteAllCookies();
	}   
	
	@AfterMethod(enabled = true)
	public void handleScreenShot(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenShot_path = captureScreenShot(driver, result.getName());
			String image = extentTest.addScreenCapture(screenShot_path);
			extentTest.log(LogStatus.FAIL,
					"Failed Method name : " + result.getName(), image);
			extentReport.endTest(extentTest);
		}

		extentReport.flush();
	}
	@AfterSuite(alwaysRun=true)
	public void closeBrowser(){
		extentReport.close();
		driver.close();
	}
	private ExtentReports getInstance() {

		extentReport = new ExtentReports("Extent_Reports/textExtent.html", true);
		extentReport.config().documentTitle("Automation Report")
				.reportName("Regression Result")
				.reportHeadline("Report for built #101");
		return extentReport;
	}

public static ExtentTest startTest(String testName, String testGroup){
	extentTest = extentReport.startTest(testName).assignCategory(testGroup);
	return extentTest;
}

public static void endTestWithPassStatus(String message){
	extentTest.log(LogStatus.PASS, message);
	extentReport.endTest(extentTest);
}

public static void getPass(String message){
	extentTest.log(LogStatus.PASS, message);
}

public static void getWarning(String message){
	extentTest.log(LogStatus.WARNING, message);
}

public static void getFail(String message){
	extentTest.log(LogStatus.FAIL, message);
}

public static void getInfo(String info){
	extentTest.log(LogStatus.INFO, info);
}

	public String captureScreenShot(WebDriver driver, String screenShotName) {

		try {
			TakesScreenshot screenShot = (TakesScreenshot) driver;
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			String dest = locaFilePath + "/" + screenShotName + ".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot Taken");
			return dest;
		} catch (IOException e) {
			System.out.println("Exception while taking Screenshot "
					+ e.getMessage());
			return e.getMessage();
		}
	}

	
	
	public static WebElement getElement(String locator, String attributeOfLocator){
		if(locator.equalsIgnoreCase("id")){
			return driver.findElement(By.id(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("className")){
			return driver.findElement(By.className(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("name")){
			return driver.findElement(By.name(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("xpath")){
			return driver.findElement(By.xpath(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("css")){
			return driver.findElement(By.cssSelector(attributeOfLocator));
		}else
			throw new NoSuchElementException("No Such Element" + attributeOfLocator);
	}
	
	
	
	//Object for Home Screen
	 public HomePage twcHomePage(){
		HomePage twchome = new HomePage(driver);
		return twchome;
	}
	
	public MyAccountPage myAcc(){
		MyAccountPage acc= new MyAccountPage(driver);
		return acc;
	}
	
	public YourCurrentLocation currentLocation(){
		YourCurrentLocation zipcode= new YourCurrentLocation(driver);
		return zipcode;
	}
	
	public SearchIcon search(){
		SearchIcon string= new SearchIcon(driver);
		return string;
	}
	
	public EmailPage email(){
		EmailPage email= new EmailPage(driver);
		return email;
	}
	
	public void startHandleWindow(){
		parentWindow=driver.getWindowHandle();
		handles=driver.getWindowHandles();
		for(String windowhandle: handles){
			if (!windowhandle.equals(parentWindow)){
				driver.switchTo().window(windowhandle);
				break;
			}
		}
	}
	
	public void endHandleWindow(){
	   handles=driver.getWindowHandles();
	   for(String windowhandle: handles){
			if (!windowhandle.equals(parentWindow)){
				driver.switchTo().window(windowhandle);
				driver.close();
			}
	   }
		
		driver.switchTo().window(parentWindow);
	}
	
	public void cleanUP() {
		driver.close();
	}
	
	public void twcHome(){
		driver.navigate().to(url);
	}


}
