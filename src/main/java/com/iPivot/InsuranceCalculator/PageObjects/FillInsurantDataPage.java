package com.iPivot.InsuranceCalculator.PageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iPivot.InsuranceCalculator.Utilities.commonMethods;

public class FillInsurantDataPage {
	commonMethods cm = new commonMethods();

	@FindBy(id="firstname")
	WebElement txt_firstname;
	
	@FindBy(id="lastname")
	WebElement txt_lastname;
	
	@FindBy(id="birthdate")
	WebElement date_birthdate;
	
	@FindBy(xpath="//input[@name='Gender']/parent::label")
	List<WebElement> rdo_gender;
	
	@FindBy(id="country")
	WebElement dd_country;
	
	
	@FindBy(id="zipcode")
	WebElement txt_zipcode;
	
	@FindBy(id="city")
	WebElement txt_city;
	
	@FindBy(id="occupation")
	WebElement dd_occupation;
	
	@FindBy(xpath="//input[@name='Hobbies']/parent::label")
	List<WebElement> chk_hobbies;
	
	@FindBy(id="website")
	WebElement txt_website;
	
	@FindBy(id="open")
	WebElement btn_PictureOpenButton; 
	
	@FindBy(id="nextenterproductdata")
	WebElement btn_Next;
	
	//Initialize web elements from this page with driver
	//constructor of current Class, use PageFactory class
	public FillInsurantDataPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fillActualInsurantData(Map m) throws InterruptedException {
		txt_firstname.sendKeys("Prakahs");
		txt_lastname.sendKeys("Narkhede");
		date_birthdate.sendKeys("12/03/1989");
		
		cm.SelectRadioButtonValue(rdo_gender, "Male");

		cm.selectValueFromDropDown(dd_country, "Aruba");
		txt_zipcode.sendKeys("411061");
		txt_city.sendKeys("Pune");
		cm.selectValueFromDropDown(dd_occupation, "Farmer");
		
		String hobboesData = m.get("Insurant_Hobby").toString();
		// hobbiesData = Speeding;Other
		 // var = EuroProtection
		String[] arr = hobboesData.split(";");
		//temp arrangement for list of hobbies
				List<String> hobbies = new ArrayList<String>();
		for (String s : arr) {
			hobbies.add(s);
		}
		
		
		
	//	hobbies.add("Speeding");
	//	hobbies.add("Other");
		//handle checkBoxes here
		cm.selectCheckBoxes(chk_hobbies, hobbies);
		txt_website.sendKeys("www.google.com");
	
	}
	
	public void clickOnNextButton() {
		btn_Next.click();
	}
}
