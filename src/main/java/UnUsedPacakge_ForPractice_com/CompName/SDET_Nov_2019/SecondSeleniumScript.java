package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondSeleniumScript {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\Selenium Online Training\\DriverExecutables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://sites.google.com/a/chromium.org/chromedriver/downloads");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//if browser by default does not open in maximize mode??
		driver.manage().window().maximize();
		
		//read text file
		//wait for some time
		//write text file
		
		
		//wait for 3 second
		Thread.sleep(3000); // hardcoded wait
		
		//refresh webpage
		driver.navigate().refresh();
		
		Thread.sleep(3000);

		//navigate backword
		driver.navigate().back();
		
		//wait for 3 second
		Thread.sleep(3000);
		//navigate forward
		driver.navigate().forward();
		
		//close browser
		driver.close();
	}

}
