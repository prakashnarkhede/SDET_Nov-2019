package com.CompName.SDET_Nov_2019;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkBoxesDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
		driver.get("http://services.smartbear.com/samples/TestComplete14/smartstore/"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		
		driver.findElement(By.xpath("//*[@id=\"menubar-my-account\"]/div/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"content-center\"]/div/div[2]/div[2]/div[2]/div/div/a")).click();
		driver.findElement(By.id("Newsletter")).click();
		driver.findElement(By.id("gender-male")).click();
		}

}
