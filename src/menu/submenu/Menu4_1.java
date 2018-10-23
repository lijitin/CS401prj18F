package menu.submenu;

import customADTs.ABList;
import customADTs.SortedABList;
import menu.IMenu;
import programADTs.GradeEntry;
import programADTs.ProgramData;

public class Menu4_1 implements IMenu{

	// constructor
	public Menu4_1() {	}
	
	@Override
	public void performFunction(ProgramData data) {
		System.out.println("YEET 4.1");
		// sort list by last name
		ABList<GradeEntry> students = data.getGrades();
		
		SortedABList<GradeEntry> sortedStudents = new SortedABList<GradeEntry>();
		for(GradeEntry s: students) {	// copying the references to a sorted array-based list
			sortedStudents.add(s);		// the add() method sorts the entries by it's natural order, i.e. lastName
		}
		System.out.println("Sorted by last name...");
		for(GradeEntry s: sortedStudents) {
			System.out.println(s.toString4_1());
		}
		
	}

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInputLowerBound() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInputUpperBound() {
		// TODO Auto-generated method stub
		return 0;
	}
}
