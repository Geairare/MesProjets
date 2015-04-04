package fr.geairare.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import fr.geairare.PPrincipal;

public class swing1 extends JFrame {

	static	final	long	serialVersionUID = -1L ;

	static	Logger logger = Logger.getLogger(swing1.class.getName()) ;

	   public swing1() {
	      super("Titre de l'application");

	      WindowListener l = new WindowAdapter() {
	         public void windowClosing(WindowEvent e){
	            System.exit(0);
	         }
	      };

	      addWindowListener(l);

	      ImageIcon img = new ImageIcon("src/main/resources/tips.gif");
	      logger.debug("Image " + img.getDescription() + " " + img.getIconHeight() +
	    		  " " + img.getIconWidth() + " " + img.getImageLoadStatus());
	      JButton bouton = new JButton("Mon bouton",img);

	      JPanel panneau = new JPanel();
	      panneau.add(bouton);
	      setContentPane(panneau);
	      setSize(500,200);
	      setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
	      setVisible(true);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix

	   }
	}