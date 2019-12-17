package com.iPivot.InsuranceCalculator.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillVehicleDataPage {
	
		@FindBy(id="make")
		WebElement dd_make;
		
		@FindBy(id="model")
		WebElement dd_model;
		
		@FindBy(xpath="//input[@id='cylindercapacity']")
		WebElement txt_cylindercapacity;
		
		@FindBy(id="engineperformance")
		WebElement txt_engineperformance;
		
		@FindBy(id="dateofmanufacture")
		WebElement date_dateofmanufacture;
		
		@FindBy(id="numberofseats")
		WebElement dd_numberofseats;
		
		@FindBy(xpath="//input[@name='Right Hand Drive']")
		List<WebElement> rdo_isRightHandDrive;
		
		@FindBy(id="numberofseatsmotorcycle")
		WebElement dd_numberofseatsmotorcycle;
		
		@FindBy(id="fuel")
		WebElement dd_fuel;
		
		@FindBy(id="payload")
		WebElement txt_payload;
		
		@FindBy(id="totalweight")
		WebElement txt_totalweight;
		
		@FindBy(id="listprice")
		WebElement txt_listprice;
		
		@FindBy(id="annualmileage")
		WebElement txt_annualmileage;
		
		@FindBy(id="nextenterinsurantdata")
		WebElement btn_Next;
		
		
		//Initialize web elements from this page with driver
		//constructor of current Class, use PageFactory class
		public FillVehicleDataPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
		public void fillActualVehicalData() {
			
		}
}
