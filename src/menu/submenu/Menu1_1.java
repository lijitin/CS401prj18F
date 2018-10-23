/* "Menu1_1.java"
 * in package menu.submenu
 * Prompts the user to input roster data. Uses provided transformers in ProgramData 
 * to store the manually input user data.
 */

package menu.submenu;

import menu.IMenu;
import programADTs.ProgramData;
import programADTs.Roster;
import support.ConsolePrompter;

public class Menu1_1 implements IMenu{

	public String msg = "";
	// constructor
	public Menu1_1() {
	}
	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public void performFunction(ProgramData data) {
		System.out.println("***Menu 1.1***");
		ConsolePrompter cp = new ConsolePrompter();
		System.out.print("***Manual Data Input***\n");
		Roster r = data.getRoster();
		int noOfSites;
		noOfSites = cp.promptInt("Number of sites? ", 1, 5); // limit the number of sites to be within 1-5
		r.setNoOfSites(noOfSites);
		int[] studentsPerSite = new int[noOfSites];
		for(int i = 0; i<r.getNoOfSites(); i++) {
			String s = "Numbers of student per site 0%1$d? ";
			s = String.format(s, i+1);
			studentsPerSite[i] = cp.promptInt(s, 0, 100);	// limit the number of students per site to be within 0-100
		}
		r.setStudentsPerSite(studentsPerSite);
		
		System.out.format("\nTotal class size: %1$d \n\n", r.getTotalClassSize());
		r.setNoOfAssignments(cp.promptInt("Numbers of Assignments? ", 0, 20));
		r.setNoOfProjects(cp.promptInt("Numbers of Projects? ", 0, 10));
		r.setNoOfExams(cp.promptInt("Number of Exams? ", 0, 3));
		
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
