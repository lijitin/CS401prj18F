/* "GPAMS.java" (Completed)
 * by Ji Tin Justin Li (22nd Oct 2018)
 * Description - An interactive menu driven GPA Management System(GPAMS).
 * This class is the application main class.
 * This class uses multiple support packages to fulfill its function.
 * The package details are documented in README.md
 */

import java.io.*;



import menu.*;
import programADTs.*;
import tree.*;

import support.TiedOutputStream;

public class GPAMS {
	
	public static void main(String[] args) {

		// set the standard output stream to a customized stream
		// which would print on System.out and write on ConsolePrintLog.txt
		PrintStream console = System.out;
		TiedOutputStream tos = new TiedOutputStream(console);
		System.setOut(tos);	
		
		TNode<IMenu> menuTree = TreeLoader.getTree();	// getting the menu tree from the static method
		NodeVisitor reader = new NodeVisitor(menuTree);	// passing the tree to the MenuVisitor class
		ProgramData data = new ProgramData();	// A custom data structure which holds references to the user input data
		reader.run(data);	// parse the tree and modify the data
	}

}
