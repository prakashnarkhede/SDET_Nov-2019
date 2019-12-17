package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadUsingRobotClass {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtalks.com"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		driver.findElement(By.id("nextenterinsurantdata")).click();
		
		//1st Way to Upload file / image 
		//if webelement has type = file
		//driver.findElement(By.id("picturecontainer")).sendKeys("C:\\Users\\Lenovo\\Desktop\\What happens when Implicit Wait and Explicit Wait is used together in Selenium WebDriver.png");
		
		
		//file upload using robot class
		//robot class ==> 
		//sikuli --> API to automate desktop application --> image based automation
		//AutoIT --> 
		
		//click on open button
		driver.findElement(By.id("open")).click();
		
		//step1: take image location to clipboard
		  //put path to your image in a clipboard
	     StringSelection ss = new StringSelection("C:\\Users\\Lenovo\\Desktop\\What happens when Implicit Wait and Explicit Wait is used together in Selenium WebDriver.png");
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
	     System.out.println("ClipBoard contents: "+Toolkit.getDefaultToolkit().getSystemClipboard().toString());
		//step2: paste using cntrol+V (from robot class)
	     Robot rb = new Robot();
	     rb.delay(3000);
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	     
	     rb.keyRelease(KeyEvent.VK_CONTROL);
	     rb.keyRelease(KeyEvent.VK_V);
	     rb.delay(3000);

			//step3: hit enter key using robot class
	     rb.keyPress(KeyEvent.VK_ENTER);
	     rb.keyRelease(KeyEvent.VK_ENTER);
		
			}

}
