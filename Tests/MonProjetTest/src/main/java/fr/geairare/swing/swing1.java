package fr.geairare.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import fr.geairare.PPrincipal;

public class swing1 extends JFrame implements ActionListener {
	static final long serialVersionUID = -1L;
	static Logger logger = Logger.getLogger(swing1.class.getName());
	JPanel panel;
	JMenuBar mbar;
	JMenu m1;
	JMenu m2;

	public swing1(ResourceBundle bundle) {

		super(bundle.getString("titre"));
		setSize(300,200);

		// gestion evenementielle de la fermeture de la fenêtre
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				logger.info("windowClosing.");
			}
		};
		addWindowListener(l);

		// Utilisation d'un toolkit pour l'affichage d'une icone associée à la
		// fenêtre
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image JFrameIcon = tk.getImage("tips.gif");
		setIconImage(JFrameIcon);

		// insertion d'objets graphiques sur la fenêtre à partir d'un panneau
		panel = new JPanel();
		Container contentPane = getContentPane();
		panel.setBackground(Color.blue);
		contentPane.add(panel);

		// Ajout d'une barre de menus à la fenêtre
		mbar = new JMenuBar();
		m1 = new JMenu("Couleur fond");
		JMenuItem m11 = new JMenuItem("Jaune");
		m11.addActionListener(this); // installation d'un écouteur d'action
		m1.add(m11); // ajout d'une option à un menu
		JMenuItem m12 = new JMenuItem("Rouge");
		m12.addActionListener(this);
		m1.add(m12);
		m2 = new JMenu("Couleur menu");
		JMenuItem m21 = new JMenuItem("Bleu");
		m21.addActionListener(this);
		m2.add(m21);
		JMenuItem m22 = new JMenuItem("Vert");
		m22.addActionListener(this);
		m2.add(m22);
		mbar.add(m1); // ajout de menus à la barre de menus
		mbar.add(m2);
		setJMenuBar(mbar);

		setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // EXIT_ON_CLOSE On
															// dit à
															// l'application de
															// se fermer lors du
															// clic sur la croix
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() instanceof JMenuItem)
		// gestion des événements liés aux menus
		{
			String ChoixOption = evt.getActionCommand();
			if (ChoixOption.equals("Jaune"))
				panel.setBackground(Color.yellow);
			else if (ChoixOption.equals("Rouge"))
				panel.setBackground(Color.red);
			else if (ChoixOption.equals("Bleu")) {
				mbar.setBackground(Color.blue);
				m1.setBackground(Color.blue);
				m2.setBackground(Color.blue);
			} else if (ChoixOption.equals("Vert")) {
				mbar.setBackground(Color.green);
				m1.setBackground(Color.green);
				m2.setBackground(Color.green);
			}
			;
		}
		;
	}

}