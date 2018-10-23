package menu.submenu;

import customADTs.ABList;
import customADTs.SortedABList;
import menu.IMenu;
import programADTs.GradeEntry;
import programADTs.ProgramData;
import programADTs.GradeEntryComparators.GradeEntryPrjScoreComparator;

public class Menu4_4 implements IMenu{

	// constructor
	public Menu4_4() {	}
	
	@Override
	public void performFunction(ProgramData data) {
		System.out.println("***Menu 4.4***");
		ABList<GradeEntry> students = data.getGrades();
		GradeEntryPrjScoreComparator prjSComp = new GradeEntryPrjScoreComparator();
		SortedABList<GradeEntry> sortedStudents = new SortedABList<GradeEntry>(prjSComp);
		
		for(GradeEntry s: students) {
			sortedStudents.add(s);		// add the entries to the sorted list
		}
		System.out.println("Sorted by Project score...");
		for(GradeEntry s: sortedStudents) {
			System.out.println(s.toString4_4());
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
