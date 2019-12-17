package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import com.iPivot.InsuranceCalculator.PageObjects.FillVehicleDataPage;

public class ConstructorDmeo {
	
	int a;
	int b;
	//constructor --> special method whose name is same as class name
	public ConstructorDmeo(int x, int y) {
		//this is constructor, initilize variables
		a = x;
		b = y;
	}
	
	
	public void add() {
		System.out.println("Addition is: "+(a+b));
	}
	
	public static void main(String[] args) {
		ConstructorDmeo c = new ConstructorDmeo(10, 20);
		ConstructorDmeo c1 = new ConstructorDmeo(100, 300);
		c.add();
		c1.add();

	}

}
