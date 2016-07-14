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
				System.out.println(currentDate + " : Nécessite un fichier de configuration \"" + fichierDeConfigurationParDéfaut + "\" ...");
				if( Config.getInstance().copyFile(configurationFile) )
					System.out.println( currentDate + " : a pu être créé depuis le modèle embarqué.");
				else {
					System.out.println( currentDate + " : n'a pas pu être créé depuis le modèle embarqué.");
					System.exit(-1) ;
				}
			}
		} else {
			Options options = new Options();
			options.addOption("c", true, "fichier de configuration");
			options.addOption("h", false, "aide");
			CommandLineParser parser = new DefaultParser();
			try {
				CommandLine cmd = parser.parse( options, args);
				if( cmd.hasOption("h")) {
					System.out.println("Usage:");
					System.out.println(" -h: cette aide");
					System.out.println(" -c fichier: chemin du fichier de configuration");
					System.exit(0) ;
				}
				if( cmd.hasOption("c")) {
					configurationFile = cmd.getOptionValue("c") ;
					if( configurationFile == null ) {
						System.out.println("un fichier doit suivre l'option -c");
						System.exit(-4) ;
					}
				}
			} catch (ParseException e) {
				System.out.println("Mauvaise option de ligne de commande.");
				System.exit(-3) ;
			}

			File configFile = new File(configurationFile) ;
			if( ! configFile.exists()) {
				System.out.println("Fichier de configuration \"" + configurationFile + "\" introuvable.");
				System.exit(-1) ;
			}
		}
		System.out.println(currentDate +" : démarrage...");

		config = Config.getInstance().loadConfig(configurationFile);

		Locale locale = Locale.getDefault();
		logger.fine(locale.toString());
		String configLocale = config.getLocale() ;
		if( configLocale != null ) {
			locale = new Locale(configLocale) ;
			logger.fine("Locale de config: " + configLocale );
		}

		logger.info("Lancement de l'application.");
		logger.info( "Nombre de fils d'éxécution: " + Thread.activeCount()) ;

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



		logger.info( "Nombre de fils d'éxécution: " + Thread.activeCount()) ;



		ResourceBundle bundle = 
				ResourceBundle.getBundle("messages",
						locale);

		logger.info("Bundle " + bundle.getBaseBundleName());
		
		JFrame frame = new swing1(bundle);
		frame.setVisible(true);

		while( frame.isShowing() ) {
			try {
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				logger.log(Level.INFO, "Interruption :", e ) ;
			}
			logger.info( "Nombre de fils d'éxécution: " + Thread.activeCount()) ;
		}
		logger.info( "Nombre de fils d'éxécution: " + Thread.activeCount()) ;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		logger.info( "Nombre de fils d'éxécution: " + Thread.activeCount()) ;
		logger.info("Sortie de l'application.");
		System.exit(0);
	}

}
