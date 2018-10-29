package support;

import java.io.PrintStream;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TiedOutputStream extends PrintStream{
	
	private static final Logger LOGGER = 
			Logger.getLogger( TiedOutputStream.class.getName() );
	
	public TiedOutputStream(PrintStream console) {
		super(console);
		FileHandler fh = null;
		try {
			fh = new FileHandler("ConsolePrintLog.txt");
		}catch(Exception e) {
		}
		LOGGER.addHandler(fh);
		LOGGER.setLevel(Level.ALL);
	}
	
	@Override
	public void print(String obj) {
		super.print(obj);	// print on the console
		LOGGER.log(Level.FINE, obj);
	}
	
	@Override
	public void println(String obj) {
		super.println(obj);	// this calls to this.print()
		//log.println(obj);
	}
	
	@Override
	public PrintStream format(String format, Object... args) {
		super.format(format, args);
		return this;
	}
	
}
