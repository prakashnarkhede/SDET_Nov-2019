package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class polymorphism3 extends polymorphism2{
	       //child class           // parent class
		   //subclass              // super class
	public polymorphism3() {
		System.out.println("constructor without any paramters of Polymmorphism 3 class");
	}

	
	public void add(int a, int b) {
		System.out.println("addition is (in child class): "+(a+b));
	}
	
//	public void pAdd() {
//		System.out.println("Private add method from child class");
//	}
 
	public static void main(String[] args) {
		polymorphism3 p3 = new polymorphism3();
		p3.add(33, 33);
		//p3.pAdd();
		//polymorphism2  p2 = new polymorphism2();
	//	p2.add(33, 33);
			
	}

}
