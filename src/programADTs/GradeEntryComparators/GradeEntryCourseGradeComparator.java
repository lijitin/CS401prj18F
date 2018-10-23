package programADTs.GradeEntryComparators;

import java.util.Comparator;

import programADTs.GradeEntry;

public class GradeEntryCourseGradeComparator implements Comparator<GradeEntry>{

	@Override
	public int compare(GradeEntry o1, GradeEntry o2) {
		if(o2.getClassNumber().compareTo(o1.getClassNumber()) == 0) {
			return o1.getGrade() - o2.getGrade();
		}else {

			return o2.getClassNumber().compareTo(o1.getClassNumber());
		}
	}

}
