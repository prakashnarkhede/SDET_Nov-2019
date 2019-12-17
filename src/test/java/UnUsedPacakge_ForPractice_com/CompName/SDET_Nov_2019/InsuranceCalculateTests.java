package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsuranceCalculateTests {
	
	@BeforeClass
	public void setUpBeforeClass() {
		//initialize excel  object
		//read data from properties  file
		System.out.println("Before Class contents");
	}
	
	
	@BeforeMethod
	public void setUpBeforeMethod() {
		System.out.println("Before Method Contents");
		
	}
	
	@Test(priority = 1, timeOut = 3, description = "any ")
	public void verifyPageTitle() throws InterruptedException {	
		System.out.println("Test 1");
		Thread.sleep(2000);
	}
	
	@Test(priority = 2, dependsOnMethods = "verifyPageTitle")
	public void verifycurrentURL() {
		System.out.println("Test 2");
	}
	@Test (priority = 3, invocationCount = 5)
	public void TestCase3() {
		System.out.println("Test 3");
	}
	@Test (priority = 4, enabled = false)
	public void TestCase4() {
		System.out.println("Test 4");
		
		
		SoftAssert sa = new SoftAssert();
		//fff
		//fff
		sa.assertEquals("google", "facebbook");
		//dd
		//dd
		sa.assertEquals("fb", "gt");
		sa.assertAll();
		
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("After Method conents");
		
	}
	@AfterClass
	public void setUpAfterClass() {
		//initialize excel  object
		//read data from properties  file
		System.out.println("After Class contents");
	}
}
