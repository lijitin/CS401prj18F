/* "GPAMS.java" (Completed)
 * by Ji Tin Justin Li (22nd Oct 2018)
 * Description - An interactive menu driven GPA Management System(GPAMS).
 * This class is the application main class.
 * This class uses multiple support packages to fulfill its function.
 * The package details are documented in README.md
 */

import menu.*;
import programADTs.*;
import tree.*;

public class GPAMS {
	
	public static void main(String[] args) {
		
		TNode<IMenu> menuTree = TreeLoader.getTree();	// getting the menu tree from the static method
		NodeVisitor reader = new NodeVisitor(menuTree);	// passing the tree to the MenuVisitor class
		ProgramData data = new ProgramData();	// A custom data structure which holds references to the user input data
		reader.run(data);	// parse the tree and modify the data
		
	}

}
