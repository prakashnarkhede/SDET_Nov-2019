package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class framesDemo {

	public static void main(String[] args) throws InterruptedException {
		

		
		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtalks.com/DemoQAapplication/DemoQa/demoqa.com/frames/index.html"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		//to enter text in input box
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Prakash");
		
		//move driver focus to frame
		driver.switchTo().frame(0);
		
		//click on checkbox
		driver.findElement(By.id("a")).click();
		
		driver.switchTo().parentFrame();
		//clear input textbox and send "John"
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("john");

		
	}

}
