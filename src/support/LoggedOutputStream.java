package support;

import java.io.PrintStream;
import java.util.logging.*;

public class LoggedOutputStream extends PrintStream{
	
	private static final Logger LOGGER = 
			Logger.getLogger( LoggedOutputStream.class.getName() );
	
	public LoggedOutputStream(PrintStream console) {
		super(console);
		FileHandler fh = null;
		try {
			fh = new FileHandler(System.getProperty("user.dir") + "\\logs\\OutputStreamLog.txt");
		}catch(Exception e) {
		}
		fh.setFormatter(new SimpleFormatter());	// set the format of the log file
		LOGGER.addHandler(fh);
		LOGGER.setLevel(Level.ALL);
	}
	
	public Logger getLogger() {
		return LOGGER;
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
