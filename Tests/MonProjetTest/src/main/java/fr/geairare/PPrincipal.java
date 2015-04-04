package fr.geairare;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import fr.geairare.swing.swing1;


public class PPrincipal {
	static	Logger logger = Logger.getLogger(PPrincipal.class.getName()) ;

	public static void main(String[] args) {
		
	     logger.info("Entering application.");
			logger.info( "Thread.activeCount: " + Thread.activeCount()) ;

			ResourceBundle bundle = 
					   ResourceBundle.getBundle("messages",
					        Locale.getDefault());
			
					JFrame frame = new swing1(bundle);
					frame.setVisible(true);
 
			while( frame.isShowing() ) {
				try {
					Thread.sleep(1000l);
				} catch (InterruptedException e) {
					logger.info("Interruption :", e ) ;
				}
				logger.info( "Thread.activeCount: " + Thread.activeCount()) ;
			}
			logger.info( "Thread.activeCount: " + Thread.activeCount()) ;
	     logger.info("Exiting application.");

	}

}
