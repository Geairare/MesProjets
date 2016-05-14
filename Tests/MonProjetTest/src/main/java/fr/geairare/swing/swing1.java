package fr.geairare.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;

public class swing1 extends JFrame {

	static	final	long	serialVersionUID = -1L ;

	   public swing1(ResourceBundle bundle) {
		   
	      super("Titre de l'application");

	      WindowListener l = new WindowAdapter() {
	         public void windowClosing(WindowEvent e){
	            System.exit(0);
	         }
	      };

	      addWindowListener(l);
		   this.setTitle(bundle.getString("titre"));

	      setSize(400,200);
	      setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
	      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //EXIT_ON_CLOSE On dit à l'application de se fermer lors du clic sur la croix
	   }
	}