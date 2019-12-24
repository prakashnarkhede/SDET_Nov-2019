package com.iPivot.InsuranceCalculator.PageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iPivot.InsuranceCalculator.Utilities.commonMethods;

public class FillProductData {
		commonMethods cm = new commonMethods();
	
	@FindBy(id="startdate")
	WebElement date_startdate;
	
	@FindBy(id="insurancesum")
	WebElement dd_insurancesum;
	
	@FindBy(id="meritrating")
	WebElement dd_meritrating;
	
	@FindBy(id="damageinsurance")
	WebElement dd_damageinsurance;
	
	@FindBy(xpath="//input[@name='Optional Products[]']/parent::label")
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

	public void fillActualProductData(Map m) {
		
		date_startdate.sendKeys("09/26/2021");
		cm.selectValueFromDropDown(dd_insurancesum, "5.000.000,00");
		cm.selectValueFromDropDown(dd_meritrating, "Bonus 1");
		cm.selectValueFromDropDown(dd_damageinsurance, "Full Coverage");
		
		List<String> l = new ArrayList<String>();
		l.add("Euro Protection");
		cm.selectCheckBoxes(chk_optionalProducts, l);
		cm.selectValueFromDropDown(dd_courtesycar, "Yes");
	}
	
	public void clickOnNextButton() {
		btn_Next.click();
	}
}
 