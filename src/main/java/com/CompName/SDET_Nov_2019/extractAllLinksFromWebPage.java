package com.CompName.SDET_Nov_2019;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extractAllLinksFromWebPage {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtalks.com/"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		driver.findElement(By.xpath("//a[text()='Other Web-Elements']")).click();
		 
		//all links begin with tagname = a
		//store in to List --> java collection
		
		//findElement --> single webelement, returns webelemnt, if not found then, exception like noSuchElement Exception
		//findElements --> get multiple webelements, return a list <WebElement>, not found --> returns empty list
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		for (int i = 0; i < allLinks.size(); i++) {
			System.out.println("URL using simple for loop is: "+allLinks.get(i).getAttribute("href"));
			
		}
		
		//for each loop
		for (WebElement webLink : allLinks) {
			System.out.println("URL using Advanced for loop is: "+webLink.getAttribute("href"));
		}
		

		//reatime --> check if all links are working  ---> using HttpURLConnection
		
	}

}
