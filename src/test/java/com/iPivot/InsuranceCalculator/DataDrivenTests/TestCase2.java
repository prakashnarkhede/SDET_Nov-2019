package com.iPivot.InsuranceCalculator.DataDrivenTests;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;
import com.iPivot.InsuranceCalculator.PageObjects.ChoosePriceOptionsPage;
import com.iPivot.InsuranceCalculator.PageObjects.FillInsurantDataPage;
import com.iPivot.InsuranceCalculator.PageObjects.FillProductData;
import com.iPivot.InsuranceCalculator.PageObjects.FillVehicleDataPage;
import com.iPivot.InsuranceCalculator.TestBase.TestBaseClass;
import com.iPivot.InsuranceCalculator.Utilities.excelRead;

public class TestCase2 {
	TestBaseClass tb = new TestBaseClass();
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	FillVehicleDataPage vehData;
	FillInsurantDataPage insData;
	FillProductData prodData;
	ChoosePriceOptionsPage priceOptions;
	excelRead excel = new excelRead();

	
	
	@BeforeClass
	public void reportSetup() {
	//setup details for extent report.
		ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\test-output\\ExtentReport.html"); 
		 extent = new ExtentReports();
		extent.attachReporter(html);
		html.config().setDocumentTitle("Test Automation Report - Execution Report - Insurance Calculator Project");
		 html.config().setReportName("Test Automation Report - Execution Report - Insurance Calculator Project");
		 html.config().setTheme(Theme.DARK);
	}
	
	
	@BeforeMethod
	public void TestSetup() throws Exception {
		//launch and navigate to url
		 driver = tb.launchAndNagivateBrowser();
		 vehData = new FillVehicleDataPage(driver);
		 insData = new FillInsurantDataPage(driver);
		 prodData = new FillProductData(driver);
		 priceOptions = new ChoosePriceOptionsPage(driver);
		 
	}
	
	@Test
	public void Test1() throws InterruptedException, Exception {
		
		//create some method who will give specifc row data in map for respectivc test case
	    Map mapdata = excel.getMapDataFromRow(1);
		
		vehData.fillActualVehicalData(mapdata);
	    vehData.clickOnNextButton();
	    
File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(f, new File(""));
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.linkText(""))).build().perform();
	}
	
	@Test 
	public void Test2(Map mapdata) throws InterruptedException {
	    Map mapdata1 = excel.getMapDataFromRow(2);

	    vehData.fillActualVehicalData(mapdata1);
	    vehData.clickOnNextButton();
	}
	
	
	@Test 
	public void Test3(Map mapdata) throws InterruptedException {
	    vehData.fillActualVehicalData(mapdata);
	    vehData.clickOnNextButton();
	}
	

	
	@Test (enabled =  true) 
	public void Test2() {
		logger = extent.createTest("Test2");
		System.out.println("test case 2");
		Assert.assertEquals("ddd", "kkk");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException{
		 if(result.getStatus() == ITestResult.FAILURE){
		 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case Failed.", ExtentColor.RED));
		 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "Test Case Failed.", ExtentColor.RED));
		
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String screenshotPath = System.getProperty("user.dir")+"\\ScreenShots\\"+result.getName()+".jpeg";
		 FileUtils.copyFile(src, new File(screenshotPath));
		 
		 logger.fail("Test Case is failed, Screenshot is attached. "+logger.addScreenCaptureFromPath(screenshotPath));
		 }
		 else if(result.getStatus() == ITestResult.SKIP){
		 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ "- Test Case is SKipped.", ExtentColor.ORANGE));
		 }
		 else if(result.getStatus() == ITestResult.SUCCESS){
			 logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "- Test Case is Passed.", ExtentColor.GREEN));
			 }
		 if(driver!= null) {
			 driver.quit();
		 }
		 
		 }
	
		 @AfterClass
		 public void endReport(){
		     extent.flush();
		    }

}
