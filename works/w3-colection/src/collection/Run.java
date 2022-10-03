package collection;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Listeleri istediðimiz gibi siralamamizi saglayan sort() metodu.
 */

public class Run {

	public static void main(String[] args) {
		ArrayList <Integer> list =new ArrayList <Integer>() ;
		list.add(50);
		list.add(40);
		list.add(25);
		list.add(85);
		list.add(100);
		list.add(258);
		
		System.out.println("Before Sort:" + list); 
		
		Collections.sort(list);
		
		System.out.println("After Sort:"+ list); //Collection sort listedeki deðerleri kucukten buyuge siraladi

	}

}
