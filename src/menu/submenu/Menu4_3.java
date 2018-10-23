package menu.submenu;

import customADTs.ABList;
import customADTs.SortedABList;
import menu.IMenu;
import programADTs.GradeEntry;
import programADTs.ProgramData;
import programADTs.GradeEntryComparators.GradeEntryAvgHWScoreComparator;

public class Menu4_3 implements IMenu{

	// constructor
	public Menu4_3() {	}
	
	@Override
	public void performFunction(ProgramData data) {
		System.out.println("YEET 4.3");
		ABList<GradeEntry> students = data.getGrades();
		GradeEntryAvgHWScoreComparator AvgHWScomp = new GradeEntryAvgHWScoreComparator();
		SortedABList<GradeEntry> sortedStudents = new SortedABList<GradeEntry>(AvgHWScomp);
		
		for(GradeEntry s: students) {
			sortedStudents.add(s);		// add the entries to the sorted list
		}
		System.out.println("Sorted by Average Homework score...");
		for(GradeEntry s: sortedStudents) {
			System.out.println(s.toString4_3());
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
