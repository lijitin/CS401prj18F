package programADTs;

import java.util.InputMismatchException;

public class Roster {

	private int noOfSites;
	private int[] studentsPerSite;
	private int totalClassSize;
	private int noOfAssignments;
	private int noOfProjects;
	private int noOfExams;
	
	// constructor
	public Roster() {
		// empty constructor
	}
	// setters
	public void setNoOfSites(int i) { this.noOfSites = i; }
	public void setStudentsPerSite(int[] studentsPerSite) throws InputMismatchException { 
		if(studentsPerSite.length != this.noOfSites) {
			throw new InputMismatchException("Site number mismatch studentsPerSite length.");
		} else {
			this.studentsPerSite = studentsPerSite;	
			for(int noOfStudents: studentsPerSite) {
				this.totalClassSize = totalClassSize + noOfStudents;
			}
		}
	}
	public void setNoOfAssignments(int i) { this.noOfAssignments = i;	}
	public void setNoOfProjects(int i) { this.noOfProjects = i;	}
	public void setNoOfExams(int i)	{ this.noOfExams = i;	}
	
	// getters
	public int getNoOfSites() { return noOfSites;	}
	public int[] getStudentsPerSite() { return studentsPerSite;	}
	public int getTotalClassSize() { return totalClassSize;	}
	public int getNoOfAssignments() { return noOfAssignments;	}
	public int getNoOfProjects() { return noOfProjects;	}
	public int getNoOfExams() { return noOfExams;	}
	
}
