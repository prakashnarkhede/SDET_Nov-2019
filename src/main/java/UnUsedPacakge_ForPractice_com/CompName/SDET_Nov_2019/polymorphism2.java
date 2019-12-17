package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class polymorphism2 {
	
	//defualt constructor
public polymorphism2() {
	System.out.println("constructor without any paramters of Polymmorphism 2 class");
}
//parameterised constructor.
public polymorphism2(String name) {
	System.out.println("constructor with name paramters");
}

private void pAdd() {
	System.out.println("Private add method from parent class");
}
	public void add() {
		System.out.println("methood without any parm");
	}
	public void add(int a, int b) {
		System.out.println("addition is: "+(a+b));
	}

	
	public void add(int a, int b, int c) {
		System.out.println("addition is: "+(a+b+c));

	}
	public void add(String name) {
		System.out.println("name is: "+name);
	}
	
	public void add(String name, int age) {
		System.out.println("name is: "+name + " age is: "+age);
	}
	
	public static void main(String[] args) {
		
		//compile time polymorphism
		//method overloading
		//early binding
		//static binding
		
		
		//for creating instance of class --> class should have constructor (special method
		//whose name is same as class & it does not return any value)
		//if no explicit constructor --> then JVM will create it for class
		polymorphism2 p = new polymorphism2();
		p.add(10, 20);
		p.add(10, 20, 10);
		p.add();
		p.add("Praksh", 30);
		
		System.out.println(3);
		System.out.println("string");
		
		
		//interface
		//there is no cosntructor & even doesnt create any constructor
		//WebDriver driver = new WebDriver();
	//	Assert.assertEquals("String", "");
		
		
		///// constructor overloading
		WebDriver driver =new ChromeDriver();
		
	}

}
