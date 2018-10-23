package menu.submenu;

import menu.IMenu;
import programADTs.*;

import support.ConsolePrompter;
import support.DataSearcher;

public class Menu3_1 implements IMenu{
	public Menu3_1() {	}
	public void performFunction(ProgramData data) {
		System.out.println("***Menu 3.1***");
		ConsolePrompter cp = new ConsolePrompter();
		String targetFirstName = cp.promptString("Target first name? ");
		
		DataSearcher ds = new DataSearcher(data, 0, targetFirstName);
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
