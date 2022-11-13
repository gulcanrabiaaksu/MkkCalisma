package com.mkk.ugd.sorting.comparator.program;

import java.util.Arrays;

public class Run 
{

	public static void main(String[] args) 
	{
		Employee[] employeeArr1 = new Employee[5];
		
		employeeArr1[0] = new Employee(555543, "Sinem", "Soylemez", 12200);
		employeeArr1[1] = new Employee(555541, "Sinem", "Bilir", 12200);
		employeeArr1[2] = new Employee(555547, "Hasan", "Caliskan", 12100);
		employeeArr1[3] = new Employee(555549, "Mahmut", "Ucmak", 12350);
		employeeArr1[4] = new Employee(555544, "Arif", "Gider", 12000);
		
		for (int i = 0; i < employeeArr1.length; i++) 
		{
			System.out.println( (i+1) + "'inci eleman: " + employeeArr1[i] );
		}
		
		
		// Maasa gore siralanacak (sagidan yukariya - "ascending order")
		// Eger maaslar ayni ise, isme bakilacak. Isimler de ayni ise soyisme bakilacak.
		Arrays.sort(employeeArr1, new EmployeeComparator());
		
		System.out.println("\nSiralanmis employeeArr1");
		
		for (Employee employee : employeeArr1) 
		{
			System.out.println(employee);
		}
	}

}
