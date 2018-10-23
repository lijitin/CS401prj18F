package menu;

import programADTs.*;

public interface IMenu {
	
	public String getMsg();	// return the formatted string message to be printed on console
	
	public void performFunction(ProgramData data); // specific for menus in leaf nodes only
	
	public int getInputLowerBound();	// get the input options limiter for the menu
	
	public int getInputUpperBound();	// the the input options limiter for the menu

}
