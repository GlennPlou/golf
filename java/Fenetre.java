import javax.swing.JFrame;

/**
 * @brief Classe engendrant une fenêtre principale d'application associée à un panneau
 */
public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;

	public Fenetre(Affichage pan) {
		// titrage de la fenêtre
		super("Golf Simulation");
		
		// réglage des paramètres
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);

		// ajout de la grille
		getContentPane().add(pan);
		pack();
		
		// affichage centré
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
