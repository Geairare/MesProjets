package fr.geairare;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import fr.geairare.swing.swing1;

public class PPrincipal {
	private static	String	sourceClass = PPrincipal.class.getName() ;
	private final	static Logger logger = Logger.getLogger(sourceClass);

	public static void main(String[] args) {
		Locale defaultLocale = Locale.getDefault();
		Locale fr_FR = new Locale("fr", "FR") ;
		Locale en_EN = new Locale("en", "EN") ;

		logger.info("Lancement de l'application.");
		logger.info( "Thread.activeCount: " + Thread.activeCount()) ;

		Runnable r = new Runnable() {
			public void run() {
				Object o = new Object();
				try {
					synchronized (o) {
						o.wait();
					}
				} catch (InterruptedException ie) {
				}
			}
		};
		Thread t = new Thread(r);
		t.setDaemon(false);
		t.start();		



		logger.info( "Thread.activeCount: " + Thread.activeCount()) ;



		ResourceBundle bundle = 
				ResourceBundle.getBundle("messages",
						fr_FR);

		JFrame frame = new swing1(bundle);
		frame.setVisible(true);

		while( frame.isShowing() ) {
			try {
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				logger.log(Level.INFO, "Interruption :", e ) ;
			}
			logger.info( "Thread.activeCount: " + Thread.activeCount()) ;
		}
		logger.info( "Thread.activeCount: " + Thread.activeCount()) ;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		logger.info( "Thread.activeCount: " + Thread.activeCount()) ;
		logger.info("Sortie de l'application.");
		System.exit(0);
	}

}
