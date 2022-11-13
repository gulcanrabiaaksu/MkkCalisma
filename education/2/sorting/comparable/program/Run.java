package com.mkk.ugd.sorting.comparable.program;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Run 
{

	public static void main(String[] args) 
	{
		int[] arr1 = {278, -76, 73, -555, 91, 2};
		System.out.println("arr1: " + Arrays.toString(arr1));
		
		Arrays.sort(arr1);
		System.out.println("Siralanmis arr1: " + Arrays.toString(arr1));
		
		String[] isimDizisi1 = {"Deniz", new String("Ayse"), "Veli", new String("Burak")};
		System.out.println("isimDizisi1: " + Arrays.toString(isimDizisi1));
		
		//Arrays.sort(isimDizisi1);
		
		Collections.sort( Arrays.asList(isimDizisi1) );
		System.out.println("Siralanmis isimDizisi1: " + Arrays.toString(isimDizisi1));
		
		
		
		Employee[] employeeArr1 = new Employee[5];
		employeeArr1[0] = new Employee(555543, "Sinem", "Soylemez", 12200);
		employeeArr1[1] = new Employee(555541, "Sinem", "Bilir", 12200);
		employeeArr1[2] = new Employee(555547, "Hasan", "Caliskan", 12100);
		employeeArr1[3] = new Employee(555549, "Mahmut", "Ucmak", 12350);
		employeeArr1[4] = new Employee(555544, "Arif", "Gider", 12000);
		
		
		 							 // Arrays.sort tek param. versiyon													   	
		Arrays.sort(employeeArr1);   // Burada, Comparable arayuzunu implement etmezsek,
									 // calisma zamaninda ClassCastException meydana gelmektedir.
		
		
		System.out.println("Siralanmis employeeArr1: " + Arrays.toString(employeeArr1));
		
																   // Collections.sort tek param. versiyon
		List<Employee> employeeList1 = Arrays.asList(employeeArr1);// Burada, Comparable arayuzunu implement etmezsek
		Collections.sort(employeeList1);                           // derleme zamani hatasi aliriz;
																   // dolayisiyla calisma zamanina gecemeyiz.

		System.out.println("Siralanmis employeeList1: " + employeeList1);
	}

}
