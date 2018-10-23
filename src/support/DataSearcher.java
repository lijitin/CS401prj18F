/* "DataSearcher.java"
 * Implemented with Menu3 submenus.
 * This helper class takes in program data, an int search option, and a matching string.
 * Exports a method which Prints out the matching grade entries. 
 * 
 */

package support;

import java.util.ArrayList;
import java.util.Collections;

import customADTs.ABList;
import programADTs.GradeEntry;
import programADTs.ProgramData;
import programADTs.GradeEntryComparators.GradeEntryComparator;

public class DataSearcher {
	
	private ProgramData data;
	private int searchOption;
	private String matchString;
	
	public DataSearcher(ProgramData data, int searchOption, String matchString) {
		this.data = data;
		this.searchOption = searchOption;
		this.matchString = matchString;
	}
	
	public void printResult() {
		ArrayList<GradeEntry> matches = new ArrayList<GradeEntry>();	
		ABList<GradeEntry> grades = this.data.getGrades();
		// check search options 0,1,2
		for(GradeEntry g: grades) {
			if(searchOption == 0) {	// search according to firstName
				if(g.getFirstName().contains(matchString)) {
					matches.add(g);
				}
			}else if(searchOption == 1) { // search according to lastName
				if(g.getLastName().contains(matchString)) {
					matches.add(g);
				}
			}else if(searchOption == 2) {	// search according to site
				if(g.getSite().contains(matchString)) {
					matches.add(g);
				}
			}else {
				System.err.println("Search option input for DataSearch class not supported! ");
				return;
			}
		}
		// sorts and prints the matched entries nicely
		// using java library here. Could implement the sort with SortedABList.
		Collections.sort(matches, new GradeEntryComparator());	
		if(matches.isEmpty()) {
			System.out.println("No entries matched.");
			return;
		}else {
			System.out.println("Found entries:");
			for(GradeEntry g: matches) {
				System.out.println(g.toString());
			}
		}
		
	}
	
}
