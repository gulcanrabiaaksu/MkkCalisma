package com.mkk.ugd.sorting.comparator.program;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>
{

	@Override
	public int compare(Employee employee1, Employee employee2) 
	{
		if(employee1.salary < employee2.salary)
		{
			return -1;
		}
		else if(employee1.salary > employee2.salary)
		{
			return 1;
		}
		else
		{
			// firstName'ler birbirine esit ise, lastName kiyaslama sonucu döndürülecek;
			// aksi halde, firstName kiyaslama sonucu döndürülecek.
			return employee1.firstName.compareTo(employee2.firstName) == 0 
					? employee1.lastName.compareTo(employee2.lastName) 
					: employee1.firstName.compareTo(employee2.firstName);
		}
		
	}

	
	
}
