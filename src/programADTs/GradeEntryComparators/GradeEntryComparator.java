package programADTs.GradeEntryComparators;

import java.util.Comparator;

import programADTs.GradeEntry;

public class GradeEntryComparator implements Comparator<GradeEntry> {

	@Override
	public int compare(GradeEntry ge1, GradeEntry ge2) {
		if(ge1.getFirstName().compareTo(ge2.getFirstName()) == 0) {
			if(ge1.getLastName().compareTo(ge2.getLastName()) == 0) {
				return ge1.getSite().compareTo(ge2.getSite());
			}else {
				return ge1.getLastName().compareTo(ge2.getLastName());
			}
		}else{
			return ge1.getFirstName().compareTo(ge2.getFirstName());
		}
	}

}
