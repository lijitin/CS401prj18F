package menu;

import programADTs.ProgramData;

public class Menu4 implements IMenu{

	public String msg;
	public int inputLowerBound, inputUpperBound;
	// constructor
	public Menu4() {
		msg = "***Menu 4***\n"
				+ "\t0. Scoring Weight per item\n"
				+ "\t1. Sorted list by last name\n"
				+ "\t2. Rankings by total score\n"
				+ "\t3. Rankings by homework average\n"
				+ "\t4. Rankings by project score\n"
				+ "\t5. Rankings by grade\n"
				+ "\t6. Main Menu";
		inputLowerBound = 0;
		inputUpperBound = 6;
		}
	public void performFunction(ProgramData data) {
		System.out.println("Not implemented");
	}
	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return msg;
	}
	@Override
	public int getInputLowerBound() {
		// TODO Auto-generated method stub
		return inputLowerBound;
	}
	@Override
	public int getInputUpperBound() {
		// TODO Auto-generated method stub
		return inputUpperBound;
	}
}
