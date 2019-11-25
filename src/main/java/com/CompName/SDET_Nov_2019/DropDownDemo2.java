package com.CompName.SDET_Nov_2019;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtalks.com/"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		//click on other web elements
		WebElement otherWebElement = driver.findElement(By.xpath("//a[text()='Other Web-Elements']"));
		otherWebElement.click();
		//driver.findElement(By.xpath("//a[text()='Other Web-Elements']")).click();	
		
		driver.findElement(By.xpath("//div[@id='sidebar']//a[text()='Selectmenu']")).click();
		
		//click on jquery dd
		driver.findElement(By.id("number-button")).click();
		String numberToBeSelected = "1";
		driver.findElement(By.xpath("//ul[@id='number-menu']//div[text()='"+ numberToBeSelected+"']")).click();
	
//		Select mselect = new Select(driver.findElement(By.id("selenium_suite")));
//		mselect.selectByValue("RC");
//		mselect.deselectByIndex(1);
//		
//		mselect.deselectAll();
//		mselect.deselectByIndex(1);
	}

}
