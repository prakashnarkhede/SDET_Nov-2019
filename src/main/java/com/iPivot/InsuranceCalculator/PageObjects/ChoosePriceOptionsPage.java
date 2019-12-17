package com.iPivot.InsuranceCalculator.PageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChoosePriceOptionsPage {
	
	//Pagefactory
	
	@FindBy(id="make")
	WebElement dd_make;
	
	@FindBy(id="model")
	WebElement dd_model;
	
	@FindBy(xpath="//input[@id='cylindercapacity']")
	WebElement txt_cylindercapacity;
	
	@FindBy(xpath="//input[@name='Right Hand Drive']")
	List<WebElement> isRightHandDrive;
	
	
	@FindBy(name="Next (Enter Insurant Data)")
	WebElement btn_Next;
	
	
	//inittialize web elements from this page with driver
	//constructor of current Class
	public ChoosePriceOptionsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
}
