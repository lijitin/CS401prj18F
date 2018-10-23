package menu;

import programADTs.ProgramData;

public class Menu5 implements IMenu{

	public String msg = "";
	public int inputLowerBound, inputUpperBound;
	// constructor
	public Menu5() {
		msg = "";
	}
	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public void performFunction(ProgramData data) {
		System.err.println("MENU5 NOT IMPLEMENTED.");
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