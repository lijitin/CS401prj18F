# MANUAL.md
This file contains the instructions on how to use the application.

## What is the application?
This java application allows user interaction via console inputs. 
A text-based menu is displayed on the console with multiple choices available to the user.
The user is allowed to navigate through the menus through integer inputs.

## How do I use/run this application?
Well, since it is java source code, you shouldbe ablt to compile with javac. The code is written in Eclipse IDE, 
and all the source code is located in ~/src folder. 

Navigate to the src directory, compile and run:

```
~/src > dir /s /B "*.java" > sources.txt  // finding the path to all source files
~/src > javac -d bin @sources.txt
```

```
~/src > cd ../bin
~/bin > java GPAMS
```

In the main menu, 7 menu options are presented to the user.
Entering the menu number in the console would navigate to the corresponding menu.

### Menu 1
Menu 1.1 lets the user input roster data manually, and Menu 1.2 enters the default values of the roster data automatically when selected.

### Menu 2
Menu 2 lets the user input student grade data to the system. The user has to input a filepath to the program and the program will read and parse from the external file. The example format of the file is shown below:
```
//example lines of data file
Michael Jordan 9998887777 CS401 01 10 9 8 10 9 9 8 7 7 9 10 9 18 88 95 
Cindy Crawford 9995671234 CS401 03 9 8 7 6 6 7 8 9 9 10 8 8 10 97 85 
```

### Menu 3
Menu 3 supports searching of the input grade entries from the 
