# CS401prj18F
~ Ji Tin Justin Li (29th Oct 2018) ~ jli208@hawk.iit.edu ~

A data structure exercise with java.
An interactive java console program that takes input from user and manipulates parsed data. 
Please read the included .pdf file for problem details.

## Application description
A CLI program which supports file parsing, search, sort. 

### Package brief description
#### Package - tree
- a package which helps in creating a tree data structure for holding menu objects.
- works closely with the menu package

__"TNode.java"__
 - the tree node class. Each node has a single parent or none(null). A node can have multiple child or none.
 - implementation details can be be found in the file.
 
__"TreeLoader.java"__
 - a helper class which "ties" the Menu objects into a Tree structure. Uses TNode<T> and the menu package.
 - exports a TNode reference which points to the root of the created tree ADT.

__"NodeVisitor.java"__
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

__"ProgramData.java"__
 - ProgramData class holds the references to all input data and their declared references 
  		i.e. all the input data can be accessed with the ProgramData data object
 - the declared reference to this data object is passed on to the menu objects within the menuTree
  
#### Package - support
 - contains helper classes for certain functionalities

__"ConsolePrompter.java"__
 - helper class which uses Java Scanner class, helps in parsing user input data
 - Contains error checking and re-prompting functionalities. (for more robustness)
 - Uses java library Logger package for logging user inputs.
 - Logged file is named as "ConsolePrompterLog.txt"

__"DataSearcher.java"__
 - Only used by Menu3 and its submenus
 - Reorganized to search the GradeEntries from data in multiple ways.
 
 __"GradeParser.java"__
 - Used by Menu2 for parsing grades.txt into GradeEntry objects
 
 __"LoggedOutputStream.java"__
 - A standard output stream substitude for printing.
 - Logs all console outpus via System.out.print(s) to a file named "ConsolePrintLog.txt"
 
#### Progress tracking:
(17th Oct 2018) Rough design of the class structure is drafted.

(18th Oct 2018) Menu interface API completed. Operations/ functionalities are already linked to the API classes in the menu package. Default menu messages completed. TreeLoader implemented. menuTree construction via static method in TreeLoader successful. menuTree transverion with NodeVisitor class implemented. Transversion within the menuTree is completed.

(19th Oct 2018) Newly implemented ProgramdData class for holding user input data references. Implemented Roster class for holding
Roster data. Menu1, Menu1_1, and Menu1_2 implementation completed. Helper parser.GradeParser class implemented together with class Menu2. GradeParser parses the given file into GradeEntry objects, and are stored in ProgramData.

(20th Oct 2018) Menu3 and submenus of menu3 implemented. Reorganized into DataSearcher class in the support package. Refactored employee package from previous CS401 lab. For Menu3_4 linked-list traveling demonstration. (ok.)

(21st Oct 2018) Implemented Comparators classes for GradeEntry class. Implemented Sorted-ArrayBased-List for sorting GradeEntries. Added new toString methods to suit different printing variants for menu4 submenus. Modified linear search (find) method in SortedABList to support recursive binary search. Added unimplemented menus (5,6).

(22nd Oct 2018) Program Completed. Menus(1-4) and respected functionalities completed. 

(29th Oct 2018) Newly added logging functionalities in "GPAMS.java" and "support.ConsolePrompter.java". Documentation updated and completed (for now ._.)

### Project Self-Evaluation: 
Lots of time revisiting previously completed classes due to poorly thought-out designs. 
e.g. Where/how do i store the data? How can instantiated menus access the stored data? which led to massive code rewriting in Menu and submenu classes.
Should have spent more time in design, and perhaps ask for design reviews from others.

Regarding logging functionalities: I was not thorough enough when reading the requirement documentation, which leads to missing out this component. Luckily my design was modular (enough) such that adding this function afterwards was not too difficult.

Overall, it was rather refreshing experience to write a full-blown program following (well, as much as I could) proper software development methods (i.e. Analysis, Design, Implementation, Documentation ... etc) as previously I only have experience in writing code snippets for solving smaller problem sets. 
With multiple targets/requirements to fulfill, I realized how important code organization is, and am really glad that I did comment my code during implementation phase.

#### Further improvements: 
Menu 5 and 6 is not implemented at all. They could be implemented rather quickly (I suppose) as the used classes already contains the required functions for removing and adding new elements.

The sorting method implemented is rather inefficient. Although it does get the job done, the inefficiency would really show when a large 
dataset is provided. (I believe it's __n^2 log n__ for the current implementation, generally speaking) Implementing mergesort or anything else would be miles better than the current one.


