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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtalks.com/WebDriverWait%20Demo/practice/wait.html"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();  // maximize chrome browser
		
		//click on alert demo
		driver.findElement(By.id("alert")).click();
		
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert al = driver.switchTo().alert();
		al.accept();
		
		
		//cliuck on display button after 10 sec
		driver.findElement(By.id("display-other-button")).click();
		WebElement hiddenButton = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("hidden1")));
		hiddenButton.click();
		
		
		//fluent
//		FluentWait wait1 = new FluentWait<T>
//		wait1.pollingEvery(100);
//		wait1.withTimeout(20);
//		wait1.withMessage("")
//		wait1.ignoring(Exception.class)
//		
//		wait1.until(ExpectedConditions.alertIsPresent())
		
			
	}

}
