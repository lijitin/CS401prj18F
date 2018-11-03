/* "ConsolePrompter.java" 
 * by Ji Tin Justin Li (27th Sep 2018)
 * Description: A helper class which helps in prompting user inputs in console
 * Includes methods which utilize scanner class
 * Prompts and captures user input for: 
 * 	1. floats
 * 	2. Strings (for choice selection)
 * 	3. Colors
 */
package support;

import java.awt.Color;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;

public class ConsolePrompter {

	private static final Logger LOGGER = 
			Logger.getLogger( ConsolePrompter.class.getName() );
	
	public int i;
	public float f;
	public String s;
	public Color c;
	private Scanner in;
	
	// constructor
	public ConsolePrompter() {
		FileHandler fh = null;
		try {
			fh = new FileHandler(System.getProperty("user.dir") + "\\logs\\userInputs" + "\\ConsolePrompterLog");
		}catch(Exception e) {
		}
		fh.setFormatter(new SimpleFormatter());
		LOGGER.addHandler(fh);
		LOGGER.setLevel(Level.ALL);
	}
	// finalize method - equivalent to destructors - methods is ran when garbage collector re-allocates this object's used memory
	public void finalize() {
		System.out.println("ConsolePriompter finalized(), closing file handlers.");
		for(Handler h: LOGGER.getHandlers()) {
			h.close();
		}
	}
	public int promptInt(String msg, int lower, int upper) {	// takes a msg and print it before scanning for input
		in = new Scanner(System.in);
		boolean invalidInput = true;
		do {
			System.out.print(msg);
			if(this.in.hasNextInt()) {
				this.i = this.in.nextInt();
				invalidInput = false;
				if(this.i < lower || this.i > upper) {
					invalidInput = true;
					System.err.println("Input is out of range. Please try again.");
					LOGGER.log(Level.WARNING, "Invalid user input - out of range: {0}", this.i);
					this.in.nextLine();	// skip a line
					continue;
				}
			}else {
				System.err.println("Input is invalid. Please enter an integer.");
				LOGGER.log(Level.WARNING, "Invalid user input - not an integer: {0}", this.in.nextLine());
				invalidInput = true;
				continue;
			}
		}while(invalidInput);
		LOGGER.log( Level.FINE, "Captured and returned user input: {0}", this.i);
		return this.i;
	}
	public float promptFloat(String msg) {	// takes a msg and print it before scanning for input
		in = new Scanner(System.in);
		boolean invalidInput = true;
		do {
			try {
				System.out.print(msg);
				this.f = this.in.nextFloat();
				invalidInput = false;
			}catch(Exception InputMismatchException) {
				System.err.println("Input is invalid. Please try again.");
				this.in.nextLine();
				invalidInput = true;
			}
		}while(invalidInput);
		return this.f;
	}
	
	public String promptString(String msg) {
		this.in = new Scanner(System.in);
		boolean invalidInput = true;
		do {
			try {
				System.out.print(msg);
				this.s = this.in.nextLine();
				invalidInput = false;
			}catch(Exception InputMismatchException) {
				System.err.println("Invalid input. Please try again.");
				this.in.nextLine();
				invalidInput = true;
			}
		}while(invalidInput);
		return this.s;
	}
	
	public Color promptColor(String msg) {
		this.in = new Scanner(System.in);
		boolean invalidInput = true;
		int r = 0, g = 0, b = 0;
		do {
			try {
				System.out.print(msg);
				System.out.println("Input 3 integers to represent a color. [r g b] range:(0-255) (e.g. 255 0 0) ");
				r = this.in.nextInt();
				g = this.in.nextInt();
				b = this.in.nextInt();
				if(r > 255 | g > 255 | b > 255 | r < 0 | g < 0| b < 0) {	// handles invalid rgb values
					System.err.println("Integers out of range. Try again. (0-255)");
					invalidInput = true;
				} else {
					invalidInput = false;
				}
			}catch(Exception InputMismatchException) {
				System.err.println("Invalid input. Please try again.");
				this.in.nextLine();
				invalidInput = true;
			}
		}while(invalidInput);
		this.c = new Color(r, g, b);
		return this.c;
	}
	
}
