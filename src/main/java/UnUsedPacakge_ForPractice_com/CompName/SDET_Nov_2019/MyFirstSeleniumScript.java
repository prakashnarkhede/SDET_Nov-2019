package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstSeleniumScript {

	public static void main(String[] args) {
		
		//launching browser --> Chrome
		//ChromeDriver class --> to launch chrome browser
		//selenium can not talk directly with any browser
		//chromedriver.exe
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\Selenium Online Training\\DriverExecutables\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();

		// open url / navigate to applciation
		driver.get("https://www.google.com/"); // get method --> used to open url
		//driver.navigate().to("url");
		
		// start actual application testing // verify page title
		//get page title of web application
		String aTitle = driver.getTitle();   //actual title
				
		//exepcted title
		String eTitle = "Google";
		
		//do not use == sign for string comparison
		// instead use equals method
		if(aTitle.equals(eTitle)) {
			System.out.println("titles are matching");
		} else {
			System.out.println("titles are not matching");
		}
		
		//closing browser
		driver.close();
	}

}
