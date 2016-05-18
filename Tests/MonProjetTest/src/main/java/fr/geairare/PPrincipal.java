package fr.geairare;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import org.apache.log4j.Logger;

import fr.geairare.swing.swing1;


public class PPrincipal {
	static	Logger logger = Logger.getLogger(PPrincipal.class.getName()) ;

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
						en_EN);

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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		logger.info( "Thread.activeCount: " + Thread.activeCount()) ;
		logger.info("Sortie de l'application.");

	}

}
