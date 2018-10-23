package menu;

import programADTs.ProgramData;

public class Menu1 implements IMenu{

	public String msg = "";
	public int inputLowerBound, inputUpperBound;
	// constructor
	public Menu1() {
		msg = "1. Manual Data Feed\n"
				+ "2. Default\n";
		inputLowerBound = 1;
		inputUpperBound = 2;
	}
	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public void performFunction(ProgramData data) {
		System.out.println("Menu 1");
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