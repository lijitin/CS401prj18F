package support;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import customADTs.ABList;
import programADTs.GradeEntry;

public class GradeParser{
	
	public static void main(String[] args) {
		// test program for GradeParser.
		String filePath = "C:\\iit\\2018Fall\\CS401\\eclipse-workspace-cs401\\CS401prj18F\\src\\grades.txt";
		GradeParser gp = new GradeParser(filePath);
		gp.parse();
	}
	public String path = null;	// Contains the file path
	public ABList<GradeEntry> GradeList;	// Contains the arrayList of employees parsed from the file
	
	public GradeParser(String filePath) {
		this.path = filePath;
		this.GradeList = new ABList<GradeEntry>();
	}
	
	// setters and getters
	public void setPath(String path) { this.path = path;	}
	public ABList<GradeEntry> getParsedList(){	
		this.parse();
		return this.GradeList;
	}
	
	public void parse() 
	// parses the from the file with the path this.path, 
	// stores the parsed data into employeeList
	{	// (code refractored from Lab4 optional exercise.)
		System.out.format("Reading from filepath: %1$s\n ...\n", this.path);
		File f = new File(this.path);
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Parsing...");
		ABList<GradeEntry> gList = new ABList<GradeEntry>();
		GradeEntry student = null;
		while(sc.hasNextLine()) {	// while there are still lines to read
			try {
				String[] tmp = sc.nextLine().split(" "); // split the entry into a string[]
				// first 5 can be extracted -> stored in student
				// last 3 -> stored in student
				// what's left are integer homework scores.
				student = new GradeEntry();
				// the first 5 strings
				student.setStudentInfo(tmp[0], tmp[1], tmp[2]); // firstName, lastName, SID
				student.setClassInfo(tmp[3], tmp[4]);	//
				// the homework scores in the middle
				ABList<Integer> hwScores = new ABList<Integer>(); 
				for(int i = 5; i<tmp.length-3; i++) {	// looping index from 5 to the end-3
					hwScores.add(Integer.parseInt(tmp[i]));
				}
				student.setHomeworkScores(hwScores);
				// the last 3 strings
				student.setProjectScore(Float.parseFloat(tmp[tmp.length-3]));
				student.setMidtermScore(Integer.parseInt(tmp[tmp.length-2]));
				student.setFinalScore(Integer.parseInt(tmp[tmp.length-1]));
			}catch(Exception e) {
				System.out.println("Cannot obtain grades info from file.");
			}
			gList.add(student);
		}
		this.GradeList = gList;
		System.out.format("Parse successful. %d lines parsed. \n", this.GradeList.size());
	}
		

}
