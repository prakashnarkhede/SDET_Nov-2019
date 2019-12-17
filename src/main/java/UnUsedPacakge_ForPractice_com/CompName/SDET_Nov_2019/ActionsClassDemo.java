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

public class ActionsClassDemo {
	


	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables		
		
		WebDriver driver = new ChromeDriver();
		

		//WebDriver --> interface
		//chromeDriver --> class
		driver.get("http://demo.automationtalks.com/DemoQAapplication/DemoQa/demoqa.com/tooltip-and-double-click/index.html"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		WebElement mouseHover = driver.findElement(By.id("tooltipDemo"));
		//Actions class
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).build().perform();
		
		String toolTip = driver.findElement(By.xpath("//*[@id=\"tooltipDemo\"]/span")).getText();
		System.out.println("Tooltip message is: "+toolTip);
		
		
		//double click demo
		WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
		act.doubleClick(doubleClickBtn).build().perform();
		
		Alert al = driver.switchTo().alert();
		al.accept();
		
		Thread.sleep(2000);
		
		WebElement rightClickBtn  = driver.findElement(By.id("rightClickBtn"));
		act.contextClick(rightClickBtn).build().perform();
		
		driver.navigate().to("http://demo.automationtalks.com/DemoQAapplication/DemoQa/demoqa.com/droppable/index.html");
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions act2 = new Actions(driver);
		act2.dragAndDrop(draggable, droppable).build().perform();
		
		//keyboard actions
		act2.keyDown(Keys.F5);
		act2.keyUp(Keys.F5);
		
		WebElement ele = driver.findElement(By.id("someid"));
		act2.moveToElement(ele).click(ele).build().perform();
		
		
		
		String expectedPageTitle = "Facebook";
		String cTitle = driver.getTitle();
		
		Assert.assertEquals(cTitle, expectedPageTitle);
		
		
	}

}
