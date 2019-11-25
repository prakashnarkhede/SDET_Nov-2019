package com.CompName.SDET_Nov_2019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithHTmlPage_LoginTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
	// open url / navigate to applciation
		driver.get("http://demowebshop.tricentis.com/"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		
		//how to interact
		//to click on login link
		//WebElement loginLink = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
		//loginLink.click();
		//use relative XPath to click on login link
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		
		//enter email id in email field.
		driver.findElement(By.id("Email")).sendKeys("test@testautomator.in");
		
		//enter password
		driver.findElement(By.name("Password")).sendKeys("password");
		
		//click on login link
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
		
	}

}
