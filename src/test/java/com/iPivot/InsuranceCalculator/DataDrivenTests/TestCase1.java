package com.iPivot.InsuranceCalculator.DataDrivenTests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.iPivot.InsuranceCalculator.TestBase.TestBaseClass;

public class TestCase1 {
	TestBaseClass tb = new TestBaseClass();
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	
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
		
	}
	
	@Test
	public void Test1() {
		//one common line you need to write in each and every test case which should be reported in extent report.
	    logger = extent.createTest("Test1");
	    
		System.out.println("test case 1");
	}
	@Test
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
		
		// File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// String screenshotPath = System.getProperty("user.dir")+"\\ScreenShots\\"+result.getName()+".jpeg";
		// FileUtils.copyFile(src, new File(screenshotPath));
		// logger.fail("Test Case is failed, Screenshot is attached. "+logger.addScreenCaptureFromPath(screenshotPath));
		 }
		 else if(result.getStatus() == ITestResult.SKIP){
		 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ "- Test Case is SKipped.", ExtentColor.ORANGE));
		 }
		 else if(result.getStatus() == ITestResult.SUCCESS){
			 logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "- Test Case is Passed.", ExtentColor.GREEN));
			 }
		 if(driver!= null) {
			 driver.close();
			// driver.quit();
		 }
		 
		 }
	
		 @AfterClass
		 public void endReport(){
		     extent.flush();
		    }

}
