package fr.geairare;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaderSAX2Factory;


public class Config {
	private static	String	sourceClass = Config.class.getName() ;
	private static Logger logger = Logger.getLogger(sourceClass);

	private	int	displayKpiDelay = 10 ;
	private	String	localisation = null ;

	private static final Config instance = new Config();

	/**
	 * Should not be call from outside as singleton
	 */
	private Config() {
	}	

	/**
	 * Get the singleton instance
	 */
	public static Config getInstance() {
		return instance;
	}

	public Config loadConfig(String filename) { 
		final String	sourceMethod = "[loadConfig]" ;

		try {
			Document doc = null;
			SAXBuilder builder =  new SAXBuilder( new XMLReaderSAX2Factory(false)); // Basic XML reader with no validation
			ClassLoader cl = this.getClass().getClassLoader();
			File fichierDeConfig = new File(filename) ;
			if( ! fichierDeConfig.exists()) {
				logger.fine("Fichier :\"" + filename + "\" introuvable.");
				// fichierDeConfig n'existe pas dans le dossier courant
				// chercher dans le chemin
				fichierDeConfig = new File(cl.getResource(filename).toString() ) ;
			}
			doc = builder.build(fichierDeConfig);
			logger.fine( sourceMethod + "Configuration chargée depuis " + filename );
			Element eltRoot = doc.getRootElement();

			setDisplayKpiDelay(Integer.valueOf(eltRoot.getChild("displayKpiDelay").getValue()));
			setLocale(eltRoot.getChild("localisation").getValue());
			
			dumpConfig();
		} catch (Exception e) {
			logger.log(Level.SEVERE, sourceMethod + "Èchec de chargement de la configuration:" + filename, e);
		}
		return instance ;
	}

	public	void	dumpConfig() {
		if (logger.isLoggable(Level.FINE)) {
			logger.fine(configToString());	
		}
	}

	private String configToString() {
		StringBuffer sb = new StringBuffer();

		sb.append("\nConfiguration");
		sb.append("\n  displayKpiDelay : ").append(displayKpiDelay);
		sb.append("\n  localisation    : ").append(localisation);
		return sb.toString();
	}

	public	boolean	copyFile(String defaultConfigFilename) {
		try {
			InputStream input = getClass().getClassLoader().getResourceAsStream(defaultConfigFilename);
			OutputStream output = new FileOutputStream(defaultConfigFilename) ;
			
			byte[] buffer = new byte[1024] ;
			int bytesRead ;
			while((bytesRead = input.read(buffer)) !=-1){
	            output.write(buffer, 0, bytesRead);
	        }
			input.close();
			output.flush();
			output.close();
			return true ;
		} catch ( IOException e) {
			logger.warning("Impossible de copier le fichier.");
			return false ;
		}
	}

	/******************************************************************** Getters / Setters */


	public int getDisplayKpiDelay() {
		return displayKpiDelay;
	}

	public void setDisplayKpiDelay(int delay) {
		this.displayKpiDelay = delay;
	}

	public String getLocale() {
		return localisation;
	}

	public void setLocale(String locale) {
		this.localisation = locale;
	}

}
