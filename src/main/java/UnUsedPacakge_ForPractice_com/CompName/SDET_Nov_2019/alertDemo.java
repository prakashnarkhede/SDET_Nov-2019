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

public class alertDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtalks.com/DemoQAapplication/DemoQa/demoqa.com/AlertMessage/index.html"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		//click on generate alter box
		driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div[1]/div[2]/div[1]/p[1]/button")).click();
		//handle alerts
		//swith from webpage to alert
		Alert al = driver.switchTo().alert();
		// accept alert / click on OK button
		Thread.sleep(2000);
	//	al.accept(); // --> used to accept alert
		
		//i want to read alert text
		String alertText = al.getText();
		System.out.println("alertText: "+alertText);
		//how to dismiss alert / cancel alert
		al.dismiss();
		
		String message = driver.findElement(By.id("demo")).getText();
		System.out.println("Message: "+message);
		// read alert text
		
		//click on prompt alert --> in order to enter text in alert
			driver.findElement(By.id("promptBox")).click();
		//enter value in alert
			
			
			Alert al1 = driver.switchTo().alert();
			al1.sendKeys("AutomationTalks");
			Thread.sleep(5000);
			al1.accept();
		
			//current date
			//past date = current date - 1M;
			//future date = current date + 1M;
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate localDate = LocalDate.now();
			String currentDate = dtf.format(localDate);
			
			
	}

}
