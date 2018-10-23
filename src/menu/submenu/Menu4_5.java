package menu.submenu;

import customADTs.ABList;
import customADTs.SortedABList;
import menu.IMenu;
import programADTs.GradeEntry;
import programADTs.ProgramData;
import programADTs.GradeEntryComparators.GradeEntryCourseGradeComparator;

public class Menu4_5 implements IMenu{

	// constructor
	public Menu4_5() {	}
	
	@Override
	public void performFunction(ProgramData data) {
		System.out.println("***Menu 4.5**");
		ABList<GradeEntry> students = data.getGrades();
		GradeEntryCourseGradeComparator cgcomp = new GradeEntryCourseGradeComparator();
		SortedABList<GradeEntry> sortedStudents = new SortedABList<GradeEntry>(cgcomp);
		
		for(GradeEntry s: students) {
			s.setTotalScore(data.getWeightFactor());
			sortedStudents.add(s);		// add the entries to the sorted list
		}
		System.out.println("Sorted by Course and Grade...");
		for(GradeEntry s: sortedStudents) {
			System.out.println(s.toString4_5());
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
