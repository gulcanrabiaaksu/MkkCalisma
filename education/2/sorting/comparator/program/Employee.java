package com.mkk.ugd.sorting.comparator.program;


public class Employee
{
	private static final int EMPLOYEE_ID_DIGIT = 6;

	private static int DEFAULT_EMPLOYEE_ID = 100000;
	
	private int employeeID;
	public String firstName;
	public String lastName;
	public double salary;
	
	
	public Employee(int employeeID, String firstName, String lastName, double salary)
	{
		super();
		setEmployeeID(employeeID);
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) 
	{
		if(employeeID < 0)
		{
			System.out.println("\nEmployee ID can not be negative.");
			
			if(this.employeeID == 0)
			{
				this.employeeID = DEFAULT_EMPLOYEE_ID++;
			}
			
		}
		else
		{
			if( String.valueOf(employeeID).length() != EMPLOYEE_ID_DIGIT )
			{
				System.out.println("\nEmployee ID must have " + EMPLOYEE_ID_DIGIT + " digits.");
				
				if(this.employeeID == 0)
				{
					this.employeeID = DEFAULT_EMPLOYEE_ID++;
				}
			}
			else
			{
				this.employeeID = employeeID;
			}
		}
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeID != other.employeeID)
			return false;
		return true;
	}
}
