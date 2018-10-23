package menu.submenu;

import customADTs.ABList;
import customADTs.SortedABList;
import menu.IMenu;
import programADTs.GradeEntry;
import programADTs.ProgramData;
import programADTs.GradeEntryComparators.GradeEntryTSComparator;

public class Menu4_2 implements IMenu{

	// constructor
	public Menu4_2() {	}
	
	@Override
	public void performFunction(ProgramData data) {
		System.out.println("YEET 4.1");
		// set the total score values in GradeEntries
		// create a TS comparator
		// add the GradeEntries in a sortedABList with the comparator
		ABList<GradeEntry> students = data.getGrades();
		GradeEntryTSComparator TScomp = new GradeEntryTSComparator();
		SortedABList<GradeEntry> sortedStudents = new SortedABList<GradeEntry>(TScomp);
		for(GradeEntry s: students) {
			sortedStudents.add(s);						// add them to the sorted list
		}
		System.out.println("Sorted by total score...");
		for(GradeEntry s: sortedStudents) {
			System.out.println(s.toString4_2());
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
