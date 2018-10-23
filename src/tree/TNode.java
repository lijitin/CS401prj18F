// possible improvement for TNode.java - write up an interface, then implementation
// more levels of abstraction -> good

/* "TNode.java"
 * by Ji Tin Justin Li (18th Oct 2018)
 * Linked nodes that suppport a singular parent node, and multiple child nodes (implemented with java.util.ArrayList)
 * Check "TreeLoader.java" for usage example.
 * Methods included:
 * 	Provides 2 constructors that links parents and child node during node creation.
 * 	 	- TNode<T>(TNode<T> parent, T info)
 * 			-> sets the parent node and info
 * 	getters/setters - 
 * 		getInfo(), setInfo(...), getParent(), setParent(...);
 * 		getChild(...), getChildren(), addChild(...), 
 * 		isRoot(), isLeaf(), getNoOfChildren().
 * 
 */

package tree;

import java.util.ArrayList;

public class TNode<T> {
	protected T info;
	protected TNode<T> parent;
	protected ArrayList<TNode<T>> children;
	
	public int noOfChildren; // the number of children this node currently has
	
	// constructor
	public TNode() {
		
	}
	public TNode(TNode<T> parent, T info)
	// sets the parent node,and info
	{
		this.parent = parent;
		this.children = new ArrayList<TNode<T>>();
		this.noOfChildren = this.children.size();
		this.info = info;
		// add this node as a child for the parent
		if(parent != null) {
			parent.addChild(this);
		}
	}
	
	public TNode(TNode<T> parent, T info, ArrayList<TNode<T>> children)
	// sets the parent node, and children array
	{
		// linking for the parent node
		parent.addChild(this);
		// linking for this node
		this.parent = parent;
		this.children = children;
		// setting internal attributes
		this.noOfChildren = children.size();
		this.info = info;
		// don't forget to set the parent links for the children!
		for(TNode<T> child: children) {
			child.setParent(this);
		}
	}
	
	public T getInfo() {	// returns the information stored in this node
		return this.info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public void setParent(TNode<T> parent) { // set the parent node for this node
		this.parent = parent;
	}
	public TNode<T> getParent(){
		return this.parent;
	}
	
	public void addChild(TNode<T> child)
	// adds a child node to this tree node
	{
		this.noOfChildren ++;
		this.children.add(child);
		child.setParent(this);
	}
	
	public ArrayList<TNode<T>> getChildren() {
		return this.children;
	}
	
	public TNode<T> getChild(int index){
		return this.children.get(index);
	}
	
	public int getNoOfChildren() {	// returns the number of children, useful for accessing the last child node
		return this.noOfChildren;
	}
	
	public boolean isRoot() {
		return (this.parent == null);
	}
	
	public boolean isLeaf() {
		return (this.noOfChildren == 0);
	}
	
}
