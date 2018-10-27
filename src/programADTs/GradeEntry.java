package programADTs;

import customADTs.ABList;

public class GradeEntry implements Comparable<GradeEntry> {
	
	private String firstName, lastName;
	private String SID;
	private String classNumber;
	private String site;
	private ABList<Integer> homeworkScores;
	private float projectScore;
	private int midtermScore;
	private int finalScore;
	private float totalScore;
	private char grade;
	
	
	
	// setting grades
	public void setGrade(WeightFactor weights) {
		if(this.totalScore >= 90) {
			this.grade = 'A';
		}else if(this.totalScore >= 80) {
			this.grade = 'B';
		}else if(this.totalScore >= 70) {
			this.grade = 'C';
		}else if(this.totalScore < 70) {
			this.grade = 'E';
		}
	}
	public char getGrade() {
		return this.grade;
	}
	
	// calculate average homework score
	public float getHWAverageScore() {
		float homeworkTotal = 0;
		for(int i: this.getHomeworkScores()) {
			homeworkTotal = homeworkTotal + i;
		}
		return homeworkTotal/homeworkScores.size();
	}
	
	// calculate total score
	public void setTotalScore(WeightFactor weights) {
		this.totalScore = (weights.getFinalExamWeight()*finalScore/100 + weights.getMidtermExamWeight()*midtermScore/100 + 
				weights.getProjectWeight()*projectScore/20);
		float homeworkTotal = 0;
		for(int i: this.getHomeworkScores()) {
			homeworkTotal = homeworkTotal + i;
		}
		homeworkTotal = homeworkTotal/homeworkScores.size()/10;
		this.totalScore = totalScore + weights.getHomeworkWeight()*homeworkTotal;
	}
	public float getTotalScore() { return this.totalScore;	}
	
	// compareTo method
	public int compareTo(GradeEntry g1) {
		return this.lastName.compareTo(g1.getLastName());	// sets the natural order according to the lastname
	}
	
	// constructor
	public GradeEntry(){ }
	public GradeEntry(String firstName, String lastName, String SID) {
		setStudentInfo(firstName, lastName, SID);
	}
	
	// toString methods
	public String toString() { // default
		String s = "[ firstName: %1$s, lastName: %2$s, SID: %3$s, classNumber: %4$s ]";
		s = String.format(s, firstName, lastName, SID, classNumber );
		return s;
	}
	public String toString4_1() {	// print according to menu4_1 requirements, i.e. printing everything.
		String s = "[ lastName: %1$s, firstName: %2$s, SID: %3$s, site: %4$s, homeworkAverage: %5$.2f,"
				+ " project: %6$s, midterm: %7$s, final: %8$s, totalScore: %9$s, Grade: %10$s ]";
		s = String.format(s, lastName, firstName, SID, site, getHWAverageScore(), this.getProjectScore(),
				this.getMidtermScore(), this.getFinalScore(), this.getTotalScore(), this.getGrade());
		return s;
	}
	public String toString4_2() {	// lastName, firstName, site, TS
		String s = "[ lastName: %1$s, firstName: %2$s, site: %4$s, totalScore: %9$s ]";
		s = String.format(s, lastName, firstName, SID, site, getHWAverageScore(), this.getProjectScore(),
				this.getMidtermScore(), this.getFinalScore(), this.getTotalScore(), this.getGrade());
		return s;
	}
	public String toString4_3() {	// lastName, firstName, site, HA
		String s = "[ lastName: %1$s, firstName: %2$s, site: %4$s, homeworkAverage: %5$.2f ]";
		s = String.format(s, lastName, firstName, SID, site, getHWAverageScore(), this.getProjectScore(),
				this.getMidtermScore(), this.getFinalScore(), this.getTotalScore(), this.getGrade());
		return s;
	}
	public String toString4_4() {	// lastName, firstName, site, project
		String s = "[ lastName: %1$s, firstName: %2$s, site: %4$s, project: %6$s ]";
		s = String.format(s, lastName, firstName, SID, site, getHWAverageScore(), this.getProjectScore(),
				this.getMidtermScore(), this.getFinalScore(), this.getTotalScore(), this.getGrade());
		return s;
	}
	public String toString4_5() {	// classNumber, grade, lastname, firstname
		String s = "[ classNumber: %1$s, Grade: %2$s, lastName: %3$s, firstName: %4$s ]";
		s = String.format(s, this.getClassNumber(), this.getGrade(), lastName, firstName);
		return s;
	}
	
	
	// setters
	public void setStudentInfo(String firstName, String lastName, String SID) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setSID(SID);
	}
	public void setClassInfo(String classNumber, String classSite) {
		this.setClassNumber(classNumber);
		this.setSite(classSite);
	}
	public void setScores(ABList<Integer> hwScores, float prjScore, int midtermScore, int finalScore) {
		this.setHomeworkScores(hwScores);
		this.setProjectScore(prjScore);
		this.setMidtermScore(midtermScore);
		this.setFinalScore(finalScore);
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public ABList<Integer> getHomeworkScores() {
		return homeworkScores;
	}
	public void setHomeworkScores(ABList<Integer> homeworkScores) {
		this.homeworkScores = homeworkScores;
	}
	public String getSID() {
		return SID;
	}
	public float getProjectScore() {
		return projectScore;
	}
	public int getMidtermScore() {
		return midtermScore;
	}
	public int getFinalScore() {
		return finalScore;
	}
	public void setSID(String SID) { this.SID = SID;	}
	public void setClass(String classNumber, String site) {	
		this.classNumber = classNumber;	this.site = site;
	}
	public void setHWScore(ABList<Integer> HWScore) { this.homeworkScores = HWScore;	}
	public void setProjectScore(float f) { this.projectScore = f;	}
	public void setMidtermScore(int i) {	this.midtermScore = i;	}
	public void setFinalScore(int i) {	this.finalScore = i;	}
	
}
