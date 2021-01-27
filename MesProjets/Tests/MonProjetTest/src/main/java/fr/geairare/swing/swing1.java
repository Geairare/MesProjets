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
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class swing1 extends JFrame implements ActionListener {
	private static String sourceClass = swing1.class.getName();
	private final static Logger logger = Logger.getLogger(sourceClass);

	static final long serialVersionUID = -1L;
	JPanel panel;
	JMenuBar mbar;
	JMenu m1;
	JMenuItem m11;
	JMenuItem m12;
	JMenu m2;
	JMenuItem m21;
	JMenuItem m22;
	JMenu m3;
	JMenuItem m31;
	JMenuItem m32;
	JMenuItem m33;

	public swing1(ResourceBundle bundle) {

		//super(bundle.getString("titre"));
		super();
		setSize(300, 200);

		// gestion évenementielle de la fermeture de la fenêtre
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				logger.info("Fermeture de la fenêtre.");
			}
		};
		addWindowListener(l);

		// Utilisation d'un toolkit pour l'affichage d'une icone associée à la
		// fenêtre
		Toolkit tk = Toolkit.getDefaultToolkit();
		// /home/gerard/Documents/Git/MesProjets/MesProjets/Tests/MonProjetTest/
		ClassLoader cl = this.getClass().getClassLoader();
		Image JFrameIcon = tk.getImage(cl.getResource("tips.gif"));
		setIconImage(JFrameIcon);

		// insertion d'objets graphiques sur la fenêtre à partir d'un panneau
		panel = new JPanel();
		Container contentPane = getContentPane();
		panel.setBackground(Color.blue);
		contentPane.add(panel);

		// Ajout d'une barre de menus à la fenêtre
		mbar = new JMenuBar();

		//m1 = new JMenu(bundle.getString("couleurFondTitre"));
		m1 = new JMenu();
		//m11 = new JMenuItem(bundle.getString("couleurFondJaune"));
		m11 = new JMenuItem();
		m11.setActionCommand("ActionJaune");
		m11.addActionListener(this); // installation d'un écouteur d'action
		m1.add(m11); // ajout d'une option à un menu
		//m12 = new JMenuItem(bundle.getString("couleurFondRouge"));
		m12 = new JMenuItem();
		m12.setActionCommand("ActionRouge");
		m12.addActionListener(this);
		m1.add(m12);

		//m2 = new JMenu(bundle.getString("couleurMenuTitre"));
		m2 = new JMenu();
		//m21 = new JMenuItem(bundle.getString("couleurMenuBleu"));
		m21 = new JMenuItem();
		m21.setActionCommand("ActionBleu");
		m21.addActionListener(this);
		m2.add(m21);
		//m22 = new JMenuItem(bundle.getString("couleurMenuVert"));
		m22 = new JMenuItem();
		m22.setActionCommand("ActionVert");
		m22.addActionListener(this);
		m2.add(m22);

		m3 = new JMenu();
		m31 = new JMenuItem();
		m31.setActionCommand("ActionFR");
		m31.addActionListener(this); // installation d'un écouteur d'action
		m3.add(m31); // ajout d'une option à un menu
		m32 = new JMenuItem();
		m32.setActionCommand("ActionEN");
		m32.addActionListener(this);
		m3.add(m32);
		m33 = new JMenuItem();
		m33.setActionCommand("ActionAR");
		m33.addActionListener(this);
		m3.add(m33);

		setTextes(bundle);

		mbar.add(m1); // ajout de menus à la barre de menus
		mbar.add(m2);
		mbar.add(m3);
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
			logger.info("Èvènement: " + ChoixOption);
			if (ChoixOption.equals("ActionJaune"))
				panel.setBackground(Color.yellow);
			else if (ChoixOption.equals("ActionRouge"))
				panel.setBackground(Color.red);
			else if (ChoixOption.equals("ActionBleu")) {
				mbar.setBackground(Color.blue);
				m1.setBackground(Color.blue);
				m2.setBackground(Color.blue);
			} else if (ChoixOption.equals("ActionVert")) {
				mbar.setBackground(Color.green);
				m1.setBackground(Color.green);
				m2.setBackground(Color.green);
			} else if (ChoixOption.equals("ActionEN")) {
				Locale locale = new Locale("en", "EN", "") ;
				ResourceBundle bundle = 
						ResourceBundle.getBundle("messages",
								locale);
				setTextes(bundle);
			} else if (ChoixOption.equals("ActionFR")) {
				Locale locale = new Locale("fr", "FR", "") ;
				ResourceBundle bundle = 
						ResourceBundle.getBundle("messages",
								locale);
				setTextes(bundle);
			} else if (ChoixOption.equals("ActionAR")) {
				Locale locale = new Locale("ar", "LB", "") ;
				ResourceBundle bundle = 
						ResourceBundle.getBundle("messages",
								locale);
				setTextes(bundle);
			}
		}
	}

	private	void	setTextes(ResourceBundle bundle) {
		this.setTitle(bundle.getString("titre"));
		m1.setText(bundle.getString("couleurFondTitre"));
		m1.setToolTipText(bundle.getString("couleurFondTitre"));
		m11.setText(bundle.getString("couleurFondJaune"));
		m11.setToolTipText(bundle.getString("couleurFondJaune"));
		m12.setText(bundle.getString("couleurFondRouge"));
		m2.setText(bundle.getString("couleurMenuTitre"));
		m21.setText(bundle.getString("couleurMenuBleu"));
		m22.setText(bundle.getString("couleurMenuVert"));
		m3.setText(bundle.getString("langues"));
		m31.setText(bundle.getString("fr_FR"));
		m32.setText(bundle.getString("en_EN"));
		m33.setText(bundle.getString("ar_LB"));
	}
}