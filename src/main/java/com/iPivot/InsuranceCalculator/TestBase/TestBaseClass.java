package com.iPivot.InsuranceCalculator.TestBase;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.iPivot.InsuranceCalculator.Utilities.propertyOperations;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBaseClass {

	//logger class object
	Logger log = Logger.getLogger(TestBaseClass.class.getName());
	
	propertyOperations propOps = new propertyOperations();
	
	//reading properties file to check which browser i need to launch
	//launching respecting browser
	//navigation
	//other setting

	WebDriver driver;
	
	public WebDriver launchAndNagivateBrowser() throws Exception {
		String browser = propOps.getPropertyValueByKey("browser");
		String url = propOps.getPropertyValueByKey("url");	
		log.info("Browser selcted for test execution is: "+browser);
		log.info("URL used for testing is: "+url);
		
		if(browser == null || browser == "") {
			log.fatal("Browser value is not specified. terminating execution.");
			throw new Exception("Browser value is not set in properties file");
		}
		if(browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			 driver = new ChromeDriver();
			DesiredCapabilities capability = DesiredCapabilities.chrome();
            WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.105:4444/wd/hub"), capability);

		} else if(browser.equalsIgnoreCase("firefox")) {
			
			DesiredCapabilities capability = DesiredCapabilities.firefox();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			log.error("Browser should be set to chrome / firefox / ie in properties file");
			throw new Exception("Browser should be set to chrome / firefox / ie in properties file");
		}
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
