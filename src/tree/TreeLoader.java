/* "TreeLoader.java"
 * exports a single static method which returns a menuTree. 
 * i.e. a Tree structure of TNodes, with Menu objects stored in the nodes.
 * 
 * 
 * This class is closely related to the menu package.
 * -> the whole menu falls apart if the declaration sequence is modified without care.
 * Menus and NodeVisitors have multiple checks for handling choice out of bound cases, 
 * but I highly doubt that alone would save the application from crashing...
 * I have no idea.
 */

package tree;

import java.util.ArrayList;

import menu.*;
import menu.submenu.Menu1_1;
import menu.submenu.Menu1_2;
import menu.submenu.Menu3_1;
import menu.submenu.Menu3_2;
import menu.submenu.Menu3_3;
import menu.submenu.Menu3_4;
import menu.submenu.Menu3_5;
import menu.submenu.Menu4_0;
import menu.submenu.Menu4_1;
import menu.submenu.Menu4_2;
import menu.submenu.Menu4_3;
import menu.submenu.Menu4_4;
import menu.submenu.Menu4_5;
import menu.submenu.Menu4_6;

public class TreeLoader {

	public static TNode<IMenu> menuTree;
	
	public static TNode<IMenu> getTree() {
		// building the tree from top to bottom, manually.
		// my brain physically hurts reading and writing this :(((
		menuTree = new TNode<IMenu>(null, new MainMenu());

		// menu1 subtree
		TNode<IMenu> TN1 = new TNode<IMenu>(menuTree, new Menu1());	// the most "readable" way to add nodes to the tree (?)
		TNode<IMenu> TN1_1 = new TNode<IMenu>(null, new Menu1_1());
		TNode<IMenu> TN1_2 = new TNode<IMenu>(null, new Menu1_2());
		TN1.addChild(TN1_1);
		TN1.addChild(TN1_2);
		
		// menu2 subtree
		new TNode<IMenu>(menuTree, new Menu2());	// Don't really need a reference for this line.
		
		// menu3 subtree
		TNode<IMenu> TN3 = new TNode<IMenu>(menuTree, new Menu3());	// making use of the constructor for handling links.
		new TNode<IMenu>(TN3, new Menu3_1());
		new TNode<IMenu>(TN3, new Menu3_2());
		new TNode<IMenu>(TN3, new Menu3_3());
		new TNode<IMenu>(TN3, new Menu3_4());
		new TNode<IMenu>(TN3, new Menu3_5());
		
		// menu4 subtree
		ArrayList<TNode<IMenu>> child4 = new ArrayList<TNode<IMenu>>();	// child4 is a subtree without the "root"
		child4.add(new TNode<IMenu>(null, new Menu4_1()));		// <-- this is actually ridiculously hard to read LOL
		child4.add(new TNode<IMenu>(null, new Menu4_2()));
		child4.add(new TNode<IMenu>(null, new Menu4_3()));
		child4.add(new TNode<IMenu>(null, new Menu4_4()));
		child4.add(new TNode<IMenu>(null, new Menu4_5()));
		child4.add(new TNode<IMenu>(null, new Menu4_6()));
		child4.add(new TNode<IMenu>(null, new Menu4_0()));	// special menu for setting weights. index = 6.
		new TNode<IMenu>(menuTree, new Menu4(), child4);	// using the overloaded, 2nd constructor here
		
		// menu5
		new TNode<IMenu>(menuTree, new Menu5());	// leaf
		
		// menu6
		new TNode<IMenu>(menuTree, new Menu6());	// leaf
		
		// menu7
		new TNode<IMenu>(menuTree, new Menu7());	// leaf, exit menu

		// LINK MORE NODES TO THE TREE HERE IF YOU WANT MORE FUNCTIONALITES, OKAY??
		
		return menuTree;
	}
}
