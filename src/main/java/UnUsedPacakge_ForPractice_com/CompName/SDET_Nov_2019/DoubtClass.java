package UnUsedPacakge_ForPractice_com.CompName.SDET_Nov_2019;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DoubtClass {

	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		String currentDate = dtf.format(localDate);
		System.out.println(currentDate);
		//    11/27/2019
		
		String[] d = currentDate.split("/");								
		String Month = d[0];
		int newIntMonth = Integer.valueOf(Month)+1;
		System.out.println(newIntMonth);
		String newDate = newIntMonth+"/"+d[1]+"/"+d[2];
		System.out.println(newDate);
				
	
		
	}

}
