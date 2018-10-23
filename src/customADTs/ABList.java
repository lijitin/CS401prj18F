/* ----------------------------------------------
 * "ABList.java" - Array-Based List
 * CS401 Fall 2018, Refer to Textbook "Object-Oriented Data Structures Using Java" - Ch.6.2 Array-Based implementation of List
 *  
 * An unbounded array list.
 * Null elements are not permitted.
 * Two constructors, one creates a default capacity list, another int param sets the starting capacity.
 * ----------------------------------------------
 */

package customADTs;

import java.util.Iterator;

public class ABList<T> implements ListInterface<T> {

	protected final static int DEFCAP = 100;	// default capacity of the list
	protected int origCap;				// original capacity
	protected T[] elements;				// the array which holds the list elements
	protected int numElements = 0;		// current number of elements in this list
	
	// variables used by find helper method
	protected boolean found;	// true if target is found
	protected int location;		// index location of found target
	public ABList() {
		this(DEFCAP);
	}
	@SuppressWarnings("unchecked")
	public ABList(int origCap) {
		elements = (T[]) new Object[origCap];
		this.origCap = origCap;
	}
	protected void enlarge() 
	// increase the capacity of the current array by original capacity
	{
		// create a larger array
		@SuppressWarnings("unchecked")
		T[] larger = (T[]) new Object[elements.length + origCap];
		for(int i = 0; i < numElements; i++) {
			larger[i] = elements[i];
		}
		elements = larger;
	}
	protected void find(T target)
	// Searches elements for the occurrence of an element e such that e.equals(target)
	// if success, sets found to true and location to index of e. else found -> false
	{	// linear search
		location = 0; found = false;
		while (location < numElements) {
			if(elements[location].equals(target)) {
				found = true;
				return;
			}else {
				location++;
			}
		}
	}
	@Override
	public boolean add(T element) { // adds an element to this list
		if(numElements == elements.length) {	// current array is full
			this.enlarge(); // enlarge the array
		}
		elements[numElements] = element;	// assign the element to the array
		numElements++;
		return true;
	}

	@Override
	public T get(T target) {
		find(target);
		if(found) {
			return elements[location];
		}else {
			return null;
		}
	}

	@Override
	public boolean contains(T target) {
		find(target);
		return found;
	}

	@Override
	public boolean remove(T target) {
		this.find(target);
		if(found) {
			for(int i = location; i < numElements - 1; i++) {
				elements[i] = elements[i+1];
			}
			elements[numElements - 1] = null;	// last element in the array 
			numElements--;
		}
		return found;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public int size() {
		return numElements;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int previousPos = -1;
			
			public boolean hasNext() { // returns true if the iteration has more elements
				return (previousPos < (size() - 1));
			}

			@Override
			public T next()
			// returns the next element in the iteration
			// throws IndexOutOfBoundExceptoin if the iteration has no more elements.
			{
				if(!hasNext()) {
					throw new IndexOutOfBoundsException("Illegal invocation of next in ABList iterator. \n");
				}
				previousPos++;
				return elements[previousPos];
			}
			
		};
	}

	@Override
	public void add(int index, T element) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Illegal index of " + index + " passed to ABList add method.\n");
		}
		if(numElements == elements.length) {
			enlarge();
		}
		for(int i = numElements; i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		numElements++;
	}

	@Override
	public T set(int index, T newElement) {
		if ((index < 0) || (index >= size()))
		      throw new IndexOutOfBoundsException("Illegal index of " + index + 
		                             " passed to ABList set method.\n");
		 
		    T hold = elements[index];
		    elements[index] = newElement;
		    return hold;
	}

	@Override
	public T get(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Illegal Index of " + index + "passed to ABList get method.\n");
		}
		return elements[index];
	}

	@Override
	public int indexOf(T target) {
		find(target);
		if(found) {
			return location;
		}
		return -1;
	}

	@Override
	public T remove(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Illegal index of " + index + " passed ABList remove method.\n");
		}
		T hold = elements[index];
		for(int i = index; i < numElements-1; i++) {
			elements[i] = elements[i+1];
		}
		elements[numElements-1] = null;
		numElements --;
		return hold;
		
	}

}
