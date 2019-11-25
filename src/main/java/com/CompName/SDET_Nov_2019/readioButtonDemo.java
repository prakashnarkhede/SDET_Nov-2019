package com.CompName.SDET_Nov_2019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class readioButtonDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/dummyProject/app.html"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		String righthandDrive = "No";
		//click on radio button
		
		if(righthandDrive.equals("Yes")) {
			//click on Yes
			driver.findElement(By.xpath("//input[@id='righthanddriveyes']/following-sibling::span")).click();
		} else {
			//click on No
			driver.findElement(By.xpath("//input[@id='righthanddriveno']/following-sibling::span")).click();

		}
		
		
		//check if webElement is display on webpage
		//find that webElement
		WebElement radioYes = driver.findElement(By.xpath("//input[@id='righthanddriveyes']/following-sibling::span"));
		System.out.println("is radio button displayed: "+radioYes.isDisplayed());
		System.out.println("is radio button enabled: "+radioYes.isEnabled());
		System.out.println("is radio button Selected: "+radioYes.isSelected());

		boolean radioButtonSelectedValue = radioYes.isSelected();
		if(radioButtonSelectedValue) {
			System.out.println("print something");
		}
		
		//check if webElement is enabled
		//check if radio button is selected.
		
		//how to click on link - .click() method on webElement
		//how to click on button - .click() method on webElement
		//how to enter text in input box -   .sendKeys("text") method on webelement
		//how to select radio button --> .click() method on respective webelemt.
		//how to select value from dropdown.
		
		
				
	}

}
