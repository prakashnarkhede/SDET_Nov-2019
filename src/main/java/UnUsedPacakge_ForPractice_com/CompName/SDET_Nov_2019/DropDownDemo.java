package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/dummyProject/index.html"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		
		//how to click on link - .click() method on webElement
		//how to click on button - .click() method on webElement
		//how to enter text in input box -   .sendKeys("text") method on webelement
		//how to select radio button --> .click() method on respective webelemt.
		
		
		//how to select value from dropdown.
		// dropdown will be coded using select tag
		//few time, dropdowns might be coded using div tag only
		
		WebElement makeDD = driver.findElement(By.id("make"));
		//to  select value from dropdown --> Select class.
		Select selectMakeDD = new Select(makeDD);
		selectMakeDD.selectByVisibleText("BMW");
		
		
		WebElement modelDD = driver.findElement(By.id("model"));
		Select selectModelDD = new Select(modelDD);
		selectModelDD.selectByIndex(4);
		
		//get list of all values from make dd
		List<WebElement> listOfoptions = selectMakeDD.getOptions();
		System.out.println("Total no of items in to list: "+listOfoptions.size());
		//listOfoptions ==> contains webelements (not text directly)
		for(int i = 0; i < listOfoptions.size(); i++) {
			System.out.println("List items are: "+listOfoptions.get(i).getText());
		}
		
		
		
		System.out.println("selected option in make dd is: "+selectMakeDD.getFirstSelectedOption());

				
	}

}
