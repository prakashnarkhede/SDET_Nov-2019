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

import io.github.bonigarcia.wdm.WebDriverManager;

public class testngTestMethodsDemo {
	WebDriver driver;
	//annotation
	
	@BeforeClass
	public void setUpBeforeClass() {
		//initialize excel  object
		//read data from properties  file
		System.out.println("Before Class contents");
	}
	
	
	@BeforeMethod
	public void setUpBeforeMethod() {
		System.out.println("Before Method Contents");
		WebDriverManager.chromedriver().setup(); // manage driver executables		
		driver = new ChromeDriver();
		driver.get("http://demo.automationtalks.com"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
	}
	
	@Test
	public void verifyPageTitle() {	
		System.out.println("Test 1");
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	
	@Test
	public void verifycurrentURL() {
		System.out.println("Test 2");
		Assert.assertEquals(driver.getCurrentUrl(), "google.com");		
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("After Method conents");
			driver.close();
		
	}
	@AfterClass
	public void setUpAfterClass() {
		//initialize excel  object
		//read data from properties  file
		System.out.println("After Class contents");
	}
}
