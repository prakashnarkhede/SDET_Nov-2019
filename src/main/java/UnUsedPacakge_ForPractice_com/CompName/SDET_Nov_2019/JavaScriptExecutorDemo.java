package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {
	


	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables		
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtalks.com"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		//webelement for next button
		WebElement nextButtonEle = driver.findElement(By.id("nextenterinsurantdata"));
		
		//click on button
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('nextenterinsurantdata').click()");
		
		String currenttutle = (String) js.executeScript("return document.title");
		
		
	}

}
