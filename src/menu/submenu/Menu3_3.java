package menu.submenu;

import menu.IMenu;
import programADTs.ProgramData;
import support.ConsolePrompter;
import support.DataSearcher;

public class Menu3_3 implements IMenu{

	// constructor
	public Menu3_3() {	}
	
	@Override
	public void performFunction(ProgramData data) {
		System.out.println("YEET 3.3");
		ConsolePrompter cp = new ConsolePrompter();
		String targetSite = cp.promptString("Target site? ");
		
		DataSearcher ds = new DataSearcher(data, 2, targetSite);
		ds.printResult();
	}

	@Override
	public String getMsg() {
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