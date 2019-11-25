package com.CompName.SDET_Nov_2019;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {

		//array
		String[] str = new String[5];
	
		//new version of array ==> expandable array / dynamic array == arrylist
		List<String> l1 = new ArrayList<String>();
		l1.add("one");
		l1.add("two");
		l1.add("three");
		
		//retrivce items from list
		l1.get(0);
		
	}

}
