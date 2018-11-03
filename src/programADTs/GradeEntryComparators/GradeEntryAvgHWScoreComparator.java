package programADTs.GradeEntryComparators;

import java.util.Comparator;

import programADTs.GradeEntry;

public class GradeEntryAvgHWScoreComparator implements Comparator<GradeEntry> {

	@Override
	public int compare(GradeEntry o1, GradeEntry o2) {
		if(o2.getHWAverageScore() > o1.getHWAverageScore()) {
			return 1;	// returns positive int if o2 is larger
		}else {
			return -1;	// else returns negative
		}
	}

}
