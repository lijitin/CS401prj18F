package programADTs;

public class WeightFactor {
	
	private int finalExamWeight;
	private int midtermExamWeight;
	private int projectWeight;
	private int homeworkWeight;
	private int totalWeight;
	
	public WeightFactor() { }
	public WeightFactor(int finals, int midterms, int projects, int homeworks) {
		setFinalExamWeight(finals);
		setMidtermExamWeight(midterms);
		setProjectWeight(projects);
		setHomeworkWeight(homeworks);
	}
	
	public int getTotalWeight() {
		this.totalWeight = this.getFinalExamWeight() + this.getMidtermExamWeight() + 
				this.getProjectWeight() + this.getHomeworkWeight();
		return this.totalWeight;
	}
	public int getFinalExamWeight() {
		return finalExamWeight;
	}
	public void setFinalExamWeight(int finalExamWeight) {
		this.finalExamWeight = finalExamWeight;
	}
	public int getMidtermExamWeight() {
		return midtermExamWeight;
	}
	public void setMidtermExamWeight(int midtermExamWeight) {
		this.midtermExamWeight = midtermExamWeight;
	}
	public int getProjectWeight() {
		return projectWeight;
	}
	public void setProjectWeight(int projectWeight) {
		this.projectWeight = projectWeight;
	}
	public int getHomeworkWeight() {
		return homeworkWeight;
	}
	public void setHomeworkWeight(int homeworkWeight) {
		this.homeworkWeight = homeworkWeight;
	}
	
	
	

}
