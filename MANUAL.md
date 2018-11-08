# MANUAL.md
This file contains the instructions on how to use the application.

## What is this application about?
This java application allows user interaction via console inputs. 
A text-based menu is displayed on the console with multiple choices available to the user.
The user is allowed to navigate through the menus through integer inputs.

## How do I use/run this application?
The pre-compiled .class files are included in the CS401prj18F/bin folder. 
In cmd, Navigate to the project folder and run with basic java command:
```
~/CS401prj19F> java -cp bin GPAMS
```
(Please refrain from running the program from other working directories as all the paths for external files are dependent on the current working directory.)

If that doesn't work, you might need to compile it again with the included java source code.
All the source code is located in CS401prj18F/src folder. 

To compile from source code, navigate to the src directory and run:

```
~/CS401prj19F> dir /s /B "*.java" > sources.txt  // finding the path to all source files
~/CS401prj19F> mkdir bin
~/CS401prj19F> javac -d bin @sources.txt
```
And then you can run the program with:
```
~/CS401prj19F> java -cp bin GPAMS
```

Running these commands should open up the main menu of the program.
```
***ROOT_NODE***
IIT CS01 GPAMS Main Menu
        1. Roaster Creation
        2. Grade Input
        3. Record Search
        4. Show list
        5. Change record (NOT IMPLEMENTED)
        6. Statistics (NOT IMPLEMENTED)
        7. Exit

Select? 
```
In the main menu, 7 menu options are presented to the user.
Entering the menu number in the console would navigate to the corresponding menu.

### Menu 1
Menu 1.1 lets you input roster data manually, and Menu 1.2 enters the default values of the roster data automatically when selected.
```
//
Select? 1
1. Manual Data Feed
2. Default

Select? 1
***Menu 1.1***
***Manual Data Input***
Number of sites? 3
Numbers of student per site 01? 10
Numbers of student per site 02? 5
Numbers of student per site 03? 5

Total class size: 20

Numbers of Assignments? 2
Numbers of Projects? 1
Number of Exams? 2
//
```
### Menu 2
Menu 2 lets you input student grade data to the system. You have to input a filepath to the program and the program will read and parse from the external file. When proceeded without entering a path, the program reads the file in the project folder.

```
~/CS401prj18F/grades.txt
```
An example output for using this default filepath is shown below:
```
//
Select? 2
***Menu 2***
Enter data file:
Reading from filepath: {%WORKING DIRECTORY%}\CS401prj18F\grades.txt
 ...
Parsing...
Parse successful. 4 lines parsed.
//
```


The example format of the grades.txt file is shown below:
```
//example lines of data file
Michael Jordan 9998887777 CS401 01 10 9 8 10 9 9 8 7 7 9 10 9 18 88 95 
Cindy Crawford 9995671234 CS401 03 9 8 7 6 6 7 8 9 9 10 8 8 10 97 85 
```
Each line in the file should contain one grade entry.
The lines should be Strings separated by a single space (" ").
From the start to the end, the data should be presented sequentially, starting from:
```
{firstName} {lastName} {SID} {classNumber} {siteNumber} {HWScore1} {HWScore2} ... {HWScoreN} {projectScore} {midtermScore} {finalScore}
```
There is no limit on the total number of lines in the file.
Repeatedly using the function of Menu 2 would append the data to the program, without overriding the previously entered data.

### Menu 3
Menu 3 supports searching of the input grade entries from Menu 2. Multiple search options are provided.
1. by first name
2. by last name
3. by Student Id
```
//
Select? 3
***Menu 3***
        1. Search by first name
        2. Search by last name
        3. Search by SID
        4. Traveling list
        5. Main Menu
Select?
//
```
Selecting 1, 2 or 3 would prompt you to enter a string. The program will search all the grade entry input, and print out  all matched grade entries.

Menu 3.4 demonstrates travelling along a doubly linked list.
Accepted inputs are an Integer following a +/- sign. 
``` 
{Integer} {+/-}
```
Example usage:
```
//
Current location is: [Employee id: "1495098740"    Employee name: "Uribe"]
Menu3.4 where to travel? [x] to exit. 4 +

Going forward for 4 nodes... 
curr >> [Employee id: "1495098740"    Employee name: "Uribe"]
4 >> [Employee id: "1370816203"    Employee name: "Ida"]
3 >> [Employee id: "1417016681"    Employee name: "Sebastian"]
2 >> [Employee id: "171743618"    Employee name: "Rivest"]
1 >> [Employee id: "977162711"    Employee name: "Edward"]
Current location is: [Employee id: "977162711"    Employee name: "Edward"]
Menu3.4 where to travel? [x] to exit. 
//
```

Selecting 5 will bring you back to the main menu.

### Menu 4
Menu 4 provides options to sort the input grade entries, and display it to you.
To use menu 4 and its sorting functions, first you have to input the weight factors through menu 4.0.
```
...
Select? 0
***Menu 4.0***
Set the weight of each class component.
... // Set the weight factors
```
Other options in menu 4 simply prints the sorted grade entries to the console output. Sort options include:
1. last name
2. total score
3. homework average
4. project score
5. grade
Example usage:
```
//
***Menu 4***
	0. Scoring Weight per item
	1. Sorted list by last name
	2. Rankings by total score
	3. Rankings by homework average
	4. Rankings by project score
	5. Rankings by grade
	6. Main Menu
Select? 2
***Menu 4.2***
Sorted by total score...
[ lastName: Jordan, firstName: Michael, site: 01, totalScore: 89.5 ]
[ lastName: Crawford, firstName: Cindy, site: 03, totalScore: 79.83333 ]
[ lastName: Moon, firstName: Moon, site: 02, totalScore: 64.181816 ]
[ lastName: Ketchum, firstName: Ash, site: 02, totalScore: 60.545456 ]
//
```

The last option takes you back to the main menu.

### Unimplemented Menus and functionalities 
The functions in Menu 5 and 6 have not been implemented. Selecting them simply gives you an error message,
and kicks you back to the main menu.

### Menu 7
Selecting this option exits the program. All the input data will be lost.
Current version does not support persistent data.



