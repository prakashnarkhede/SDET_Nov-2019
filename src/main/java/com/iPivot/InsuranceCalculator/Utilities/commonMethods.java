package com.iPivot.InsuranceCalculator.Utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class commonMethods {
	
	
	public void selectValueFromDropDown(WebElement ele, String valueToBeSelected) {
		Select oselect = new Select(ele);
		oselect.selectByVisibleText(valueToBeSelected);
	}
	
	
	public void SelectRadioButtonValue(List<WebElement> Listele, String valueToBeSelected) {
		for(int i = 0; i < Listele.size(); i++) {
			if(Listele.get(i).getText().equalsIgnoreCase(valueToBeSelected)) {
				Listele.get(i).click();
			}
		}
		
	}
	
	public void selectCheckBoxes(List<WebElement> ele, List<String> hobbies) {
		
		for (String hobby : hobbies) {
			
			for(int i = 0; i < ele.size(); i++) {	
				if(ele.get(i).getText().equalsIgnoreCase(hobby)) {
					ele.get(i).click();
					break;
				}
			}
		}
		
	}
	

	
	
	
	
	
	
	
}
