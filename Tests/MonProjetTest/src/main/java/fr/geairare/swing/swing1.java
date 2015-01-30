package fr.geairare.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class swing1 extends JFrame {

	static	final	long	serialVersionUID = -1L ;

	   public swing1() {
	      super("titre de l'application");

	      WindowListener l = new WindowAdapter() {
	         public void windowClosing(WindowEvent e){
	            System.exit(0);
	         }
	      };

	      addWindowListener(l);
	      setSize(400,200);
	      setVisible(true);
	   }
	}