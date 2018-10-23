/* "ProgramData.java"
 * A class which holds all the instantiated data references from the user input.
 * An instantiated data object that can be passed to menus from the NodeVisitor.
 */

package programADTs;

import customADTs.*;

public class ProgramData {

	private Roster r;
	private ABList<GradeEntry> g;
	private WeightFactor w;
	
	
	public ProgramData() {
		r = new Roster();
		g = new ABList<GradeEntry>(); 
		w = new WeightFactor();
	}
	
	public void setRoster(Roster r) { this.r = r;	}
	public Roster getRoster() { return r;	}
	
	public void setGrades(ABList<GradeEntry> grades) { this.g = grades;	}
	public ABList<GradeEntry> getGrades(){ return this.g;	}
	
	public void setWeightFactor(WeightFactor weights) {	this.w = weights;	}
	public WeightFactor getWeightFactor() { return this.w;	}
	
}
