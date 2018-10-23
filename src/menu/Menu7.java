package menu;

import programADTs.ProgramData;

public class Menu7 implements IMenu{

	public String msg;
	public int inputLowerBound, inputUpperBound;
	// constructor
	public Menu7() {
		msg = "ByeBye!";
		}
	public void performFunction(ProgramData data) {
		System.out.println(getMsg());
	}
	@Override
	public String getMsg() {
		return msg;
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
