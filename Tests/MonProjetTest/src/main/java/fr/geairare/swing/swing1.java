package fr.geairare.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

import fr.geairare.PPrincipal;

public class swing1 extends JFrame {
	static	final	long	serialVersionUID = -1L ;
	static	Logger logger = Logger.getLogger(swing1.class.getName()) ;

	public swing1(ResourceBundle bundle) {

		super("Titre de l'application");

		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				logger.info("windowClosing.");;
			}
		};

		addWindowListener(l);
		this.setTitle(bundle.getString("titre"));

		setSize(400,200);
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //EXIT_ON_CLOSE On dit à l'application de se fermer lors du clic sur la croix
	}
}