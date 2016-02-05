package fr.geairare;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PPrincipal {

	private static Logger logger = Logger.getLogger("fr.geairare.test");
	public static void main(String[] args) {
		logger.info("On y va...");
		
	    Handler fh;
		try {
			fh = new FileHandler("logs/Test1.log");
		    Logger.getLogger("").addHandler(fh);
		    Logger.getLogger("fr.geairare").setLevel(Level.INFO);

			logger.info("On y va...");
			
			logger.info("Terminé.");
		} catch (SecurityException e) {
			logger.warning("SecurityException..." + e.getMessage());
		} catch (IOException e) {
			logger.warning("IOException..." + e.getMessage());
		}
		
		logger.info("Terminé.");
	}

}
