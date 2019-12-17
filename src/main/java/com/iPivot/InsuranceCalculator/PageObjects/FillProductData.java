package com.iPivot.InsuranceCalculator.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillProductData {
	
	
	@FindBy(id="startdate")
	WebElement date_startdate;
	
	@FindBy(id="insurancesum")
	WebElement dd_insurancesum;
	
	@FindBy(id="meritrating")
	WebElement dd_meritrating;
	
	@FindBy(id="damageinsurance")
	WebElement dd_damageinsurance;
	
	@FindBy(xpath="//input[@name='Optional Products[]']/following-sibling::span")
	List<WebElement> chk_optionalProducts;
	
	@FindBy(id="courtesycar")
	WebElement dd_courtesycar;
	
	@FindBy(id="nextselectpriceoption")
	WebElement btn_Next;
	
	
	//Initialize web elements from this page with driver
	//constructor of current Class, use PageFactory class
	public FillProductData(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
