package fr.geairare;

import java.io.File;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import fr.geairare.Config;

import fr.geairare.swing.swing1;

public class PPrincipal {
	private static	String	sourceClass = PPrincipal.class.getName() ;
	private final	static Logger logger = Logger.getLogger(sourceClass);
	private	final	static	String fichierDeConfigurationParDéfaut = "Configuration.xml";
	private	static	Date	currentDate ;
	private	static	Config config ;

	public static void main(String[] args) {
		final String	sourceMethod = "[Main] " ;
		String	configurationFile = fichierDeConfigurationParDéfaut ;
		currentDate = new Date(System.currentTimeMillis()) ;

		logger.entering(sourceClass, sourceMethod);

		if( args.length < 1 ) {
			File configFile = new File(fichierDeConfigurationParDéfaut) ;
			if( ! configFile.exists()) {
				System.out.println(currentDate + " : Nécessite un fichier de configuration " + fichierDeConfigurationParDéfaut + " ...");
				if( Config.getInstance().copyFile(configurationFile) )
					System.out.println( currentDate + " : Successfully created from embedded template.");
				else {
					System.out.println( currentDate + " : Unable to create it from embedded template.");
					System.exit(-1) ;
				}
			}
		} else {
			Options options = new Options();
			options.addOption("c", true, "configuration file");
			options.addOption("h", false, "help");
			CommandLineParser parser = new DefaultParser();
			try {
				CommandLine cmd = parser.parse( options, args);
				if( cmd.hasOption("h")) {
					System.out.println("Usage:");
					System.out.println(" -h: this help");
					System.out.println(" -c file: path to configuration file");
					System.exit(0) ;
				}
				if( cmd.hasOption("c")) {
					configurationFile = cmd.getOptionValue("c") ;
					if( configurationFile == null ) {
						System.out.println("file must follows -c option");
						System.exit(-4) ;
					}
				}
			} catch (ParseException e) {
				System.out.println("Wrong command line option.");
				System.exit(-3) ;
			}

			File configFile = new File(configurationFile) ;
			if( ! configFile.exists()) {
				System.out.println("Configuration file \"" + configurationFile + "\" not found.");
				System.exit(-1) ;
			}
		}
		System.out.println(currentDate +" : started...");

		config = Config.getInstance().loadConfig(configurationFile);

		Locale locale = Locale.getDefault();
		String configLocale = config.getLocale() ;
		if( configLocale != null ) {
			locale = new Locale(configLocale) ;
			logger.fine("Locale de config: " + configLocale );
		}

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
						locale);

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
