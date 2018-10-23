/* "Menu2.java"
 * Takes in a String filePath for grade entries.
 * Uses helper class in package parser to parse the file into GradeEntry objects.
 * Stores the parsed objects into the method given param ProgramData data.
 */
package menu;

import programADTs.GradeEntry;
import programADTs.ProgramData;
import support.ConsolePrompter;
import support.GradeParser;
import customADTs.ABList;

public class Menu2 implements IMenu{

	public String msg = "";
	
	public Menu2() {	}
	
	public void performFunction(ProgramData data) {
		System.out.println("***Menu 2***");
		ConsolePrompter cp = new ConsolePrompter();
		String filePath = cp.promptString("Enter data file: ");
		if(filePath.equals("")) {
			// filePath = "C:\\iit\\2018Fall\\CS401\\eclipse-workspace-cs401\\CS401prj18F\\src\\grades.txt";
			// default path
			filePath = System.getProperty("user.dir") + "\\grades.txt";
		}
		GradeParser gp = new GradeParser(filePath);
		ABList<GradeEntry> grades = gp.getParsedList();
		for(GradeEntry g: grades) {	// appending the parsed grade entries to the existing list.
			data.getGrades().add(g);
		}
	}

	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public int getInputLowerBound() {
		return 0;
	}

	@Override
	public int getInputUpperBound() {
		return 0;
	}
}
