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

public class parallelExecutionDemo {
	
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
	
	@Test
	public void TestCase1() throws InterruptedException {	
		System.out.println("Test 1");
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	public void TestCase2() {
		System.out.println("Test 2");
		System.out.println(Thread.currentThread().getId());

	}
	@Test
	public void TestCase3() {
		System.out.println("Test 3");
		System.out.println(Thread.currentThread().getId());

	}
	@Test 
	public void TestCase4() {
		System.out.println("Test 4");
		System.out.println(Thread.currentThread().getId());

		
	}
	@Test 
	public void TestCase5() {
		System.out.println("Test 5");
		System.out.println(Thread.currentThread().getId());

		
	}
	@Test 
	public void TestCase6() {
		System.out.println("Test 6");
		System.out.println(Thread.currentThread().getId());

		
	}
	@Test 
	public void TestCase7() {
		System.out.println("Test 7");
		System.out.println(Thread.currentThread().getId());

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
