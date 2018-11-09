package programADTs.GradeEntryComparators;

import java.util.Comparator;

import programADTs.GradeEntry;

public class GradeEntryTSComparator implements Comparator<GradeEntry> {

	@Override
	public int compare(GradeEntry o1, GradeEntry o2) {
		if(o2.getTotalScore() > o1.getTotalScore()) {	// compare totalscore
			return 1;
		}else if(o2.getTotalScore() < o1.getTotalScore()) {
			return -1;
		}else {	//compare hw average
			if(o2.getHWAverageScore() > o1.getHWAverageScore()) {
				return 1;
			}else if(o2.getHWAverageScore() < o1.getHWAverageScore()) {
				return -1;
			}else {	// compare site
				if(o2.getSite().compareTo(o1.getSite()) != 0) {
					return o2.getSite().compareTo(o1.getSite());
				}else {	// compare last name
					return o2.getLastName().compareTo(o1.getLastName());
				}
			}
				
		}
	}
}
