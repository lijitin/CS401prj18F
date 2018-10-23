package employees;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee>
/*	Contains a method that takes two Employee objects as arguments. 
 * 	Compares the name member of the two Employees.
 */
{
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
	
}