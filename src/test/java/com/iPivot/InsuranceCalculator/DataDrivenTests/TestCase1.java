package com.iPivot.InsuranceCalculator.DataDrivenTests;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.iPivot.InsuranceCalculator.PageObjects.ChoosePriceOptionsPage;
import com.iPivot.InsuranceCalculator.PageObjects.FillInsurantDataPage;
import com.iPivot.InsuranceCalculator.PageObjects.FillProductData;
import com.iPivot.InsuranceCalculator.PageObjects.FillVehicleDataPage;
import com.iPivot.InsuranceCalculator.TestBase.TestBaseClass;
import com.iPivot.InsuranceCalculator.Utilities.excelRead;


@Listeners(com.iPivot.InsuranceCalculator.Utilities.ListenerClass.class)
public class TestCase1 {
	TestBaseClass tb = new TestBaseClass();
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	FillVehicleDataPage vehData;
	FillInsurantDataPage insData;
	FillProductData prodData;
	ChoosePriceOptionsPage priceOptions;
	excelRead excel = new excelRead();
	
	//logger class object
	Logger log = Logger.getLogger(TestCase1.class.getName());

	
	@BeforeClass
	public void reportSetup() {
	//setup details for extent report.
		ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\test-output\\ExtentReport.html"); 
		 extent = new ExtentReports();
		extent.attachReporter(html);
		html.config().setDocumentTitle("Test Automation Report - Execution Report - Insurance Calculator Project");
		 html.config().setReportName("Test Automation Report - Execution Report - Insurance Calculator Project");
		 html.config().setTheme(Theme.DARK);
		 log.info("Extent report setting is completed !!!!!");
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
	
	@Test (dataProvider = "insuranceCalcData", enabled = true)
	public void Test1(Map mapdata) throws InterruptedException {
		
		log.info("Test case exeuction started !!!!");
		//one common line you need to write in each and every test case which should be reported in extent report.
	    logger = extent.createTest("Test1");
	    //enter vehicle data

	    vehData.fillActualVehicalData(mapdata);
	    vehData.clickOnNextButton();
	    
	    //enter insurant data
	    insData.fillActualInsurantData(mapdata);
	    insData.clickOnNextButton();
	    
	    //enter product data
	    prodData.fillActualProductData(mapdata);
	    prodData.clickOnNextButton();
	    
	    //verify price options
	    priceOptions.verifySilverPlanPrice(mapdata.get("PriceValidation_Silver").toString());
	    priceOptions.verifyGoldPlanPrice(mapdata.get("PriceValidation_Gold").toString());
	    priceOptions.verifyPlatinumPlanPrice(mapdata.get("PriceValidation_Platinum").toString());
	    priceOptions.verifyUltimatePlanPrice(mapdata.get("PriceValidation_Ultimate").toString());
	    if(mapdata.get("SelectOption").toString().equalsIgnoreCase("Silver")) {
	        priceOptions.selectSilverPlan();    	
	    }
	    if(mapdata.get("SelectOption").toString().equalsIgnoreCase("Gold")) {
	        priceOptions.selectGoldrPlan();    	
	    }
	    if(mapdata.get("SelectOption").toString().equalsIgnoreCase("Platinum")) {
	        priceOptions.selectPlatinumPlan();    	
	    }
	    priceOptions.clickOnNextButton();
	   log.info("Test execution is finished"); 
	}
	
	
	@DataProvider(name= "insuranceCalcData")
	public Object[][] dataProviderMethod() throws Exception {
		Object[][] arr = excel.ExcelDataInObjectArray();
		return arr;
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
