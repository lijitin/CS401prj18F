package menu;

import programADTs.ProgramData;

public class Menu6 implements IMenu{

	public String msg = "";
	public int inputLowerBound, inputUpperBound;
	// constructor
	public Menu6() {
		msg = "";
	}
	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public void performFunction(ProgramData data) {
		System.err.println("MENU6 NOT IMPLEMENTED.");
	}
	@Override
	public int getInputLowerBound() {
		return inputLowerBound;
	}
	@Override
	public int getInputUpperBound() {
		return inputUpperBound;
	}
	
}