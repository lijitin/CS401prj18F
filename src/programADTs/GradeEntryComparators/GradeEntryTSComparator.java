package programADTs.GradeEntryComparators;

import java.util.Comparator;

import programADTs.GradeEntry;

public class GradeEntryTSComparator implements Comparator<GradeEntry> {

	@Override
	public int compare(GradeEntry o1, GradeEntry o2) {
		return (int) (o2.getTotalScore() - o1.getTotalScore());
	}
}
