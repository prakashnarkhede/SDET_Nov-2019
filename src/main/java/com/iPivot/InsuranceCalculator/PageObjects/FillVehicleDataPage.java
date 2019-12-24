package com.iPivot.InsuranceCalculator.PageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.iPivot.InsuranceCalculator.Utilities.commonMethods;

public class FillVehicleDataPage {
	commonMethods cm = new commonMethods();

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
		
		@FindBy(xpath="//input[@name='Right Hand Drive']/parent::label")
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
		
		
		public void fillActualVehicalData(Map m) {			
			cm.selectValueFromDropDown(dd_make, m.get("Vehicle_Make").toString());
			cm.selectValueFromDropDown(dd_model, m.get("Vehicle_Model").toString());
			txt_cylindercapacity.sendKeys(m.get("Vehicle_CylinderCapacity").toString());
			txt_engineperformance.sendKeys(m.get("Vehicle_Enging Performance").toString());
			date_dateofmanufacture.sendKeys(m.get("Vehicle_Date of Manufacture").toString());
			cm.selectValueFromDropDown(dd_numberofseats, m.get("Vehicle_No of Seats").toString());
			
			//select radio button
			cm.SelectRadioButtonValue(rdo_isRightHandDrive, m.get("Vehicle_RightHandDrive").toString());
			cm.selectValueFromDropDown(dd_numberofseatsmotorcycle, m.get("Vehicle_No of Seats_motorcycle").toString());
			cm.selectValueFromDropDown(dd_fuel, m.get("Vehicle_Fuel Type").toString());
			txt_payload.sendKeys(m.get("Vehicle_PayLoad").toString());
			txt_totalweight.sendKeys(m.get("Vehicle_Total Weight").toString());
			txt_listprice.sendKeys(m.get("Vehicle_List Price").toString());
			txt_annualmileage.sendKeys(m.get("Vehicle_Annual Mileage").toString());
		}
		
		public void clickOnNextButton() {
			btn_Next.click();
		}
}
