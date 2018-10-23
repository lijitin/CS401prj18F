package menu.submenu;

import programADTs.ProgramData;
import support.ConsolePrompter;

import java.util.ArrayList;

import customADTs.DLLNode;
import employees.*;
import menu.IMenu;

public class Menu3_4 implements IMenu{

	// constructor
	public Menu3_4() {
	}
	
	@Override
	public void performFunction(ProgramData data) {
		System.out.println("YEET 3.4");
		// (I'm feeling lazy so lets just create a linked list of employee objects from emp.txt)
		// uses the employees package.
		String filePath = "C:\\iit\\2018Fall\\CS401\\eclipse-workspace-cs401\\CS401prj18F\\emp.txt";
		EmployeeParse parser = new EmployeeParse(filePath);
		ArrayList<Employee> employeeList = parser.getEmployeeList();
		// create a custom doubly-linked-list of employees
		DLLNode<Employee> employeeDLList = null;
		
		for(Employee e: employeeList) {
			DLLNode<Employee> newNode = new DLLNode<Employee>();
			newNode.setInfo(e);
			if(employeeDLList == null) {
				employeeDLList = newNode;
			}else {
				employeeDLList.setBack(newNode);
				newNode.setForward(employeeDLList);
				employeeDLList = newNode;
			}
		}
		
		// + >> go forward, - >> go backward
		ConsolePrompter cp = new ConsolePrompter();
		boolean exitFlag = false;
		DLLNode<Employee> tmp = employeeDLList; // a tmp reference to move around the employeeDLList.
		while(!exitFlag) {	
			System.out.println("Current location is: " + tmp.getInfo());
			String command = cp.promptString("Menu3.4 where to travel? [x] to exit. ");
			if(command.contentEquals("x")) {
				break;
			}
			// checking input validity
			if(!command.matches("[0-9]?[0-9][ ][+|-]")) {
				System.err.println("Command invalid. Please try again.");
				continue;
			}
			String[] cmd = command.split(" "); // [0] for the number of nodes to travel, [1] for the direction.
			int i = Integer.parseInt(cmd[0]);
			if(cmd[1].contentEquals("+")) {
				System.out.format("\nGoing forward for %1$s nodes... \n", i);
				System.out.println("curr >> " + tmp.getInfo());
				while(i > 0) {
					if(tmp.getForward() == null) {				
						System.out.format("%1$d >> NULL, CANNOT GO THAT FAR FORWARD.\n", i);
						break;
					}
					tmp = tmp.getForward();
					System.out.format("%1$d >> " + tmp.getInfo() + "\n", i);
					i--;
				}
			}else if(cmd[1].contentEquals("-")) {
				System.out.format("\nGoing backward for %1$s nodes... \n", i);
				System.out.println("curr >> " + tmp.getInfo());
				while(i > 0) {
					if(tmp.getBack() == null) {
						System.out.format("%1$d >> NULL, CANNOT GO THAT FAR BACK.", i);
						break;
					}
					tmp = tmp.getBack();
					System.out.format("%1$d >> " + tmp.getInfo() + "\n", i);
					i--;
				}
			}
			
		}
		
		
		
	}

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInputLowerBound() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInputUpperBound() {
		// TODO Auto-generated method stub
		return 0;
	}
}
