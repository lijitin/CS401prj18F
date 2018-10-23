package menu.submenu;

import customADTs.ABList;
import menu.IMenu;
import programADTs.GradeEntry;
import programADTs.ProgramData;
import programADTs.WeightFactor;
import support.ConsolePrompter;

public class Menu4_0 implements IMenu{

	private boolean alreadySet;
	public boolean isAlreadySet() { return alreadySet;	}
	// constructor
	public Menu4_0() {	alreadySet = false;}
	
	@Override
	public void performFunction(ProgramData data) {
		System.out.println("YEET 4.0");
		// prompt 4 integers and store in data
		WeightFactor weights = data.getWeightFactor();
		if(!alreadySet) {
			ConsolePrompter cp = new ConsolePrompter();
			System.out.println("Set the weights for each evaluation.");
			weights.setFinalExamWeight(cp.promptInt("Final Exam \t", 0, 100));
			weights.setMidtermExamWeight(cp.promptInt("Midterm Exam \t", 0, 100));
			weights.setProjectWeight(cp.promptInt("Project \t" , 0, 100));
			weights.setHomeworkWeight(cp.promptInt("Homework \t", 0, 100));
			ABList<GradeEntry> grades = data.getGrades();
			// call setters in grades to calculate Total score, grades, etc..
			for(GradeEntry g: grades) {
				g.setTotalScore(weights);
				g.setGrade(weights);
			}
			alreadySet = true;
		}else {
			System.out.println("The weights are already set.");
			System.out.format("Final Exam \t%1$d\n"
					+ "Midterm Exam \t%2$d\n"
					+ "Project \t%3$d\n"
					+ "Homework \t%4$d\n",
					weights.getFinalExamWeight(), weights.getMidtermExamWeight(),
					weights.getProjectWeight(), weights.getHomeworkWeight());
		}
		System.out.format("Total: \t\t%1$d\n", weights.getTotalWeight());
		
	}

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
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
