package fr.geairare;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

import fr.geairare.swing.swing1;


public class PPrincipal {
	static	Logger logger = Logger.getLogger(PPrincipal.class.getName()) ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	     logger.info("Entering application.");
	     
	      JFrame frame = new swing1();

	     logger.info("Exiting application.");

	}

}
