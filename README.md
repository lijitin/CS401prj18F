# CS401prj18F
A data structure exercise with java.
Read the included .pdf file for problem details.

## Application description
A CLI program which supports file parsing, search, sort. 


### Package brief description
#### Package - tree
- a package which helps in creating a tree data structure for holding menu objects.
- works closely with the menu package

"TNode.java"
 - the tree node class. Each node has a single parent or none(null). A node can have multiple child or none.
 - implementation details can be be found in the file.
 
"TreeLoader.java"
 - a helper class which "ties" the Menu objects into a Tree structure. Uses TNode<T> and the menu package.
 - exports a TNode reference which points to the root of the created tree ADT.

"NodeVisitor.java"
 - the "main program" of the application
 - handles the logic and the transversing of the created menuTree ADT.
   
#### Package - menu
- a package with the details of each "page" of the menu interface.
- each class (MenuX.java, MenuX_X.java) represents a page in the interface
- menus provides a performFunction() method which acts as an API that can link to external function calls.
- reorganized with subpackage - submenu for second "layer" menus
  
#### Package - customADTs
- includes reusable data structure components
- ABList is an Unsorted-Array-Based-List ADT for intermediate storing for input data
- SortedABList is a Sorted-ArrayBase-List ADT that support sorting of elements.
- DLLNode is for demonstration of traveling within a linked list instance
 	
#### Package - employees
- a refactored package from previous CS401 lab assignments, for demonstration in traveling within linked lists.
- implemented with Doubly-Linked-List Nodes (customADTs.DLLNode) to support forward and backward traveling.

#### Package - programADTs
- a package which stores program specific data types/classes
- the input data is parsed into different types of declared objects, and are all stored in a ProgramData object.
"ProgramData.java"
 - ProgramData class holds the references to all input data and their declared references 
  		i.e. all the input data can be accessed with the ProgramData data object
 - the declared reference to this data object is passed on to the menu objects within the menuTree
  
#### Package - support
 - contains helper classes for certain functionalities
"ConsolePrompter.java"
 - helper class which uses Java Scanner class, helps in parsing user input data
 - Contains error checking and re-prompting functionalities. (for more robustness)
"DataSearcher.java"
 - Only used by Menu3 and its submenus
 - Reorganized to search the GradeEntries from data in multiple ways.
   
#### Progress tracking:
(17th Oct 2018) Rough design of the class structure is drafted.

(18th Oct 2018) Menu interface API completed. Operations/ functionalities are already linked to the API classes in the menu package. Default menu messages completed. TreeLoader implemented. menuTree construction via static method in TreeLoader successful. menuTree transverion with NodeVisitor class implemented. Transversion within the menuTree is completed.

(19th Oct 2018) Newly implemented ProgramdData class for holding user input data references. Implemented Roster class for holding
Roster data. Menu1, Menu1_1, and Menu1_2 implementation completed. Helper parser.GradeParser class implemented together with class Menu2. GradeParser parses the given file into GradeEntry objects, and are stored in ProgramData.

(20th Oct 2018) Menu3 and submenus of menu3 implemented. Reorganized into DataSearcher class in the support package. Refactored employee package from previous CS401 lab. For Menu3_4 linked-list traveling demonstration. (ok.)

(21st Oct 2018) Implemented Comparators classes for GradeEntry class. Implemented Sorted-ArrayBased-List for sorting GradeEntries. Added new toString methods to suit different printing variants for menu4 submenus. Modified linear search (find) method in SortedABList to support recursive binary search. Added unimplemented menus (5,6).

(22nd Oct 2028) Program Completed. Menus(1-4) and respected functionalities completed. 

### Project Self-Evaluation: 
I spent a lot of time revising previously completed classes. Lots of modifications are made. 
Poorly thought-out during the design phase.
e.g. Where/how do i store the data? How can instantiated menus access the stored data?
 -> led to massive code rewrite in Menu and submenu classes.
Could've spent more time in design, and perhaps ask for design reviews from others.
