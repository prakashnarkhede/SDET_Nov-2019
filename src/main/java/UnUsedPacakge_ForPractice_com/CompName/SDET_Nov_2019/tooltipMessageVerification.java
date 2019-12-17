package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tooltipMessageVerification {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtalks.com/index.html"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		driver.findElement(By.id("engineperformance")).click();
		String Message = driver.findElement(By.xpath("//input[@id='engineperformance']/following-sibling::span")).getText();
		System.out.println("tooltip message is: "+Message);
		
		
		List<WebElement> ele = driver.findElements(By.xpath("//label[text()='Hobbies']/following-sibling::p//span"));
			for (WebElement webEle : ele) {
				if(webEle.getText().equals("Other")){
					webEle.click();	
				}
			}
			
			
			
			
			
			
	}

}
