/* CS401 Helper to parse emp.txt
 * file format: .txt, each line contains one employee data in this format:
 * "{name} {id}"
 * e.g.
 * Reince 1005856211
 * Juan 1785450388
 * ...
 */

package employees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeParse {
	
	public String path = null;	// Contains the file path
	public ArrayList<Employee> employeeList;	// Contains the arrayList of employees parsed from the file
	
	public EmployeeParse(String filePath) {
		this.path = filePath;
		this.employeeList = new ArrayList<Employee>();
	}
	
	// setters and getters
	public void setPath(String path) { this.path = path;	}
	public ArrayList<Employee> getEmployeeList(){	
		this.parse();
		return this.employeeList;
	}
	
	public void parse() 
	// parses the from the file with the path this.path, 
	// stores the parsed data into employeeList
	{	// (code refractored from Lab4 optional exercise.)
		System.out.format("Reading from filepath: %1$s\n ...\n", this.path);
		File f = new File(this.path);
		Scanner scanner = null;
		try {
			scanner = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Integer> id = new ArrayList<Integer>();	//	Integer: Wrapper class for ints
		for(int i = 0; scanner.hasNextLine(); i++) {
			try {
				String[] tmp = scanner.nextLine().split(" ");	//	Split up the string into two, and store in tmp stringarray
				name.add(tmp[0]);
				id.add(Integer.parseInt(tmp[1]));	//	string to int conversion
			}catch(Exception e) {
				System.err.format("Error when scanning. (%1$s line %2$d)\n", this.path, i);
			}
		}
		
		for(int i=0; i < name.size(); i++) 
		// create Employee instances one by one, and fill up employeeList
		{
			this.employeeList.add(new Employee(id.get(i), name.get(i)));
		}
		System.out.format("Parse successful. %d Employee objects parsed. \n", this.employeeList.size());
	}
		

}
