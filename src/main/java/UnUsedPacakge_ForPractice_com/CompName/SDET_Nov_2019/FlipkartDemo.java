package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartDemo {
	


	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables		
		
		WebDriver driver = new ChromeDriver();
		

		//WebDriver --> interface
		//chromeDriver --> class
		driver.get("https://www.flipkart.com/"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		try {
			driver.findElement(By.xpath("//button[text()='✕']")).click();
		} catch(Exception e) {
			
		}
		WebElement mouseHover = driver.findElement(By.xpath("//div[@class='zi6sUf']//span[text()='Electronics']"));
		//Actions class
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).build().perform();

		//click on mobile
		driver.findElement(By.xpath("//div[@class='zi6sUf']//a[text()='Mobiles']")).click();
		
		//click on network type
		driver.findElement(By.xpath("//div[text()='Network Type']")).click();
		
			//check 4G checBox
		driver.findElement(By.xpath("//input[@type='checkbox']/parent::label//div[text()='4G']/preceding-sibling::div")).click();
		
		//select MI checkBox:
				driver.findElement(By.xpath("//input[@type='checkbox']/parent::label//div[text()='Mi']/preceding-sibling::div")).click();
				Thread.sleep(4000);

		List<WebElement> l = driver.findElements(By.xpath("//div[starts-with(@data-id, 'MOB')]/div/a/div[2]/div[1]/div[1]"));
		for (WebElement webElement : l) {
			System.out.println(webElement.getText());
		}
		
		Thread.sleep(4000);
		boolean isNextButtonDisplayed = driver.findElement(By.xpath("//span[text()='Next']")).isDisplayed();
		while(isNextButtonDisplayed) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			List<WebElement> l1 = driver.findElements(By.xpath("//div[starts-with(@data-id, 'MOB')]/div/a/div[2]/div[1]/div[1]"));
			for (WebElement webElement : l1) {
				for(int i = 0; i < 4; i++) {
					try{
						System.out.println(webElement.getText());
											
					}catch(Exception e) {
						
					}
				}
			}
			try {
			 isNextButtonDisplayed = driver.findElement(By.xpath("//span[text()='Next']")).isDisplayed();
			}catch(Exception e) {
				
			}
		}
	}

}
