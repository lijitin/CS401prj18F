package menu;

import programADTs.ProgramData;

public class Menu3 implements IMenu{
	
	public String msg;
	public int inputLowerBound, inputUpperBound;
	public Menu3() {
		msg = "***Menu 3***\n"
				+ "\t1. Search by first name\n"
				+ "\t2. Search by last name\n"
				+ "\t3. Search by SID\n"
				+ "\t4. Traveling list\n"
				+ "\t5. Main Menu";
		inputLowerBound = 1;
		inputUpperBound = 5;
	}

	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public void performFunction(ProgramData data) {
		
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
