package menu;

import programADTs.ProgramData;

public class MainMenu implements IMenu {

	public String msg;
	public int inputLowerBound, inputUpperBound;
	
	
	// constructor
	public MainMenu() {
		msg = "IIT CS01 GPAMS Main Menu\n"
				+ "\t1. Roaster Creation\n"
				+ "\t2. Grade Input\n"
				+ "\t3. Record Search\n"
				+ "\t4. Show list\n"
				+ "\t5. Change record (NOT IMPLEMENTED)\n"
				+ "\t6. Statistics (NOT IMPLEMENTED)\n"
				+ "\t7. Exit\n";
		inputLowerBound = 1;
		inputUpperBound = 7;
	}

	@Override
	public String getMsg() {
		return msg;
	}
	@Override
	public void performFunction(ProgramData data) {
		System.out.println("Not implemented");
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
