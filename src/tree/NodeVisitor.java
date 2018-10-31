/* "NodeVisitor.java"
 * A class which takes in a tree object and traverse in it based on user input.
 * Works in conjunction with Menu classes.
 * Hopefully the comments helps in reading this messy code :(
 * 
 */

package tree;

import menu.*;
import menu.submenu.Menu1_1;
import menu.submenu.Menu1_2;
import menu.submenu.Menu3_5;
import menu.submenu.Menu4_0;
import menu.submenu.Menu4_6;
import programADTs.*;
import support.ConsolePrompter;

public class NodeVisitor {
	
	public TNode<IMenu> menuTree; 	// the root node of the menu tree
	public TNode<IMenu> currTNode;	// current node
	
	// constructor
	public NodeVisitor(TNode<IMenu> menuTree) {
		this.menuTree = menuTree;
	}
	
	public void run(ProgramData data)
	// Traverse the tree
	{
		ConsolePrompter prompter = new ConsolePrompter();
		int choice = 0;
		currTNode = menuTree;
		while(currTNode != null) {
			if(currTNode.isRoot()) {
				System.out.println("***ROOT_NODE***");
			}
			IMenu menu = currTNode.getInfo();
			if(currTNode.isLeaf()) 
			{
				// if the node is a leaf node (contains functional options for the user)
				menu.performFunction(data); // perform the action for that node on the passed data object
				
				if(currTNode.getInfo() instanceof Menu7) {	// if is exit node
					currTNode = null;
				}else if(currTNode.getInfo() instanceof Menu1_1 || currTNode.getInfo() instanceof Menu1_2){
					// get back to the root node (since menu 1 does not have an exit menu 1_3 somehow)
					// and i'm too lazy to add an extra menu, and modifying the documentation. Welp.
					currTNode = menuTree;	
				}else if(currTNode.getInfo() instanceof Menu3_5 || currTNode.getInfo() instanceof Menu4_6) {
					currTNode = menuTree;
				}else {
					currTNode = currTNode.getParent();	// get back to previous node
				}
				
			}else {
				// the current node is an intermediate menu page
				System.out.println(menu.getMsg());
				choice = prompter.promptInt("Select? ", menu.getInputLowerBound(), menu.getInputUpperBound());
				if(choice == 0) 
				// special case for the special menu option
				// the node of the special option will always be at the end of the arraylist in TNode children
				{	
					choice = currTNode.getNoOfChildren();
					currTNode = currTNode.getChild(choice-1);
					continue;
				}

				// locking out menu 4 options 1 to 5 if haven't set the weights via Menu4_0
				if(currTNode.getInfo() instanceof Menu4) {	// if on menu4
					if(choice == 6) { // let the user to choose menu4_6
						currTNode = currTNode.getChild(choice-1);
						continue;
					}
					// check if menu4_0 isAlreadySet
					Menu4_0 menu4_0 = (Menu4_0) currTNode.getChild(currTNode.getNoOfChildren()-1).getInfo(); // cast to Menu4_0. // absolute doodoo code
					if(!menu4_0.isAlreadySet()) {	// have not set the weights yet
						// print out error message
						System.err.println("Please set the score weights via Menu4 option 0 before attempting to sort the data entries.");
						continue;	// stay on Menu4
					}
				}
				currTNode = currTNode.getChild(choice-1);
			}
			
		}
		
	}

}
