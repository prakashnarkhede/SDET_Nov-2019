package com.iPivot.InsuranceCalculator.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillInsurantDataPage {

	@FindBy(id="firstname")
	WebElement txt_firstname;
	
	@FindBy(id="lastname")
	WebElement txt_lastname;
	
	@FindBy(id="birthdate")
	WebElement date_birthdate;
	
	@FindBy(xpath="//input[@name='Gender']/following-sibling::span")
	List<WebElement> rdo_gender;
	
	@FindBy(id="country")
	WebElement txt_country;
	
	
	@FindBy(id="zipcode")
	WebElement txt_zipcode;
	
	@FindBy(id="city")
	WebElement txt_city;
	
	@FindBy(id="occupation")
	WebElement dd_occupation;
	
	@FindBy(xpath="//input[@name='Hobbies']/following-sibling::span")
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
}
