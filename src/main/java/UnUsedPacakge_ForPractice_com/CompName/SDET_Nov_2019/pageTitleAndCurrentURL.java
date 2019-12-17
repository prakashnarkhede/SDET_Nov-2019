package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pageTitleAndCurrentURL {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtalks.com/"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		//verify page title
		String expectedPageTitle = "Facebook";
		String currentPageTitle = driver.getTitle();
		
		if(currentPageTitle.equals(expectedPageTitle)) {
			System.out.println("Page title is matching");
		}else {
			System.out.println("page title is not matching");
		}
		//Asserts
		
		//current URL
		String currentURL = driver.getCurrentUrl();
		System.out.println("currentURL is: "+currentURL);
		

	}

}
