package menu.submenu;

import menu.IMenu;
import programADTs.ProgramData;
import support.ConsolePrompter;
import support.DataSearcher;

public class Menu3_2 implements IMenu{

	// constructor
	public Menu3_2() {	}
	
	@Override
	public void performFunction(ProgramData data) {
		System.out.println("***Menu 3.2***");
		ConsolePrompter cp = new ConsolePrompter();
		String targetLastName = cp.promptString("Target last name? ");
		
		DataSearcher ds = new DataSearcher(data, 1, targetLastName);
		ds.printResult();
	}

	@Override
	public String getMsg() {
		return "";
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
