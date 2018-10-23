package employees;

public class Employee implements Comparable<Employee>{
	//	Class variables
	private int id;
	private String name;
	
	//	constructor
	public Employee(int id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	//	Getters
	public int getId(){		return this.id;		}
	public String getName() {	return this.name;	}
	
	//	Setters
	public void setId(int id) {
		this.id = id;		return;
	}
	public void setName(String name) {
		this.name = name;	return;
	}
	
	public String toString() 
	//	toString method for output
	{
		return "[Employee id: \"" + this.getId() + "\" "
				+ "   Employee name: \"" + this.getName() + "\"]";
	}
	
	@Override
	public int compareTo(Employee e) 
	//	Compares this employee object with the other by their id
	{
		//	returns the difference in id. Returns int = 0 if the ids are the same.
		return this.id - e.id;	
	}
	
	public boolean equals(Employee e)
	//	Shortcut function which returns true if both ids and names matches, else returns false 
	{
		return this.id == e.id && this.name.equals(e.name);
	}

}



