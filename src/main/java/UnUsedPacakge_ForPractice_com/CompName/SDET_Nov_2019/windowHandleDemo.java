package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandleDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); // manage driver executables	
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtalks.com/DemoQAapplication/DemoQa/demoqa.com/automation-practice-switch-windows/index.html"); // get method --> used to open url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize chrome browser
		
		//click on OPen new tab
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/button[3]")).click();
	
		//how to switch to new window? 
		String parentWindow  = driver.getWindowHandle();
		System.out.println("parentWindow: "+parentWindow);
		
		Set<String> setOfWindows = driver.getWindowHandles();
		System.out.println("setOfWindows: "+setOfWindows);
		
		String childWindow = null;
		//how to go to child window now? 
		for (String st : setOfWindows) {
			//if my window id is parent window
			if(!st.equals(parentWindow)) {
				childWindow = st;		
				}
		}
		
		//swith to child window
		driver.switchTo().window(childWindow);
		
		//go to new tab & then enter text in some text box
		driver.findElement(By.name("q")).sendKeys("Search something");
		
		//come back to parent window
		driver.switchTo().window(parentWindow);
				
		System.out.println("Text from parent window is: "+driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText());
		
		
		//windowHandle
		//windowHandles
		driver.close(); // to close the window on which driver has focus currently
		driver.quit(); // closes all the window are launched by driver instance
	}

}
