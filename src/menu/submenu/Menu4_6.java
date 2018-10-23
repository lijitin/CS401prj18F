package menu.submenu;

import menu.IMenu;
import programADTs.ProgramData;

public class Menu4_6 implements IMenu{

	// constructor
	public Menu4_6() {	}
	
	@Override
	public void performFunction(ProgramData data) {
		System.out.println("***Back to MainMenu***");
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
