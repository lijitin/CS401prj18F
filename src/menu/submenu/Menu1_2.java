/* "Menu1_2.java"
 *  Sets the default values for Roster data. 
 */

package menu.submenu;

import menu.IMenu;
import programADTs.ProgramData;
import programADTs.Roster;

public class Menu1_2 implements IMenu{

	public String msg = "";
	// constructor
	public Menu1_2() {
	}
	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public void performFunction(ProgramData data) {
		System.out.println("***Menu 1.2***");
		System.out.println("Setting default values for the roster...");
		Roster r = data.getRoster();
		int noOfSites = 3;
		r.setNoOfSites(noOfSites);
		int[] studentsPerSite = new int[]{
				10, 5, 5
		};
		r.setStudentsPerSite(studentsPerSite);
		r.setNoOfAssignments(10);
		r.setNoOfProjects(1);
		r.setNoOfExams(2);
		System.out.println("Completed.");
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
