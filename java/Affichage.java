/**
 * @brief Classe permettant de réaliser un affichage graphique du terrain de golf
 *
 * Le terrain de golf est représenté graphiquement dans un panneau, les
 * cases étant numérotées à partir du coin supérieur gauche (0,0) jusqu'au
 * coin inférieur droit (Largeur,Hauteur)
 *
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 1.0
 */

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.event.*;


public final class Affichage extends JPanel{
	private static final long serialVersionUID = 1L;

	// Largeur et hauteur du panel graphique, calculés une seule fois à la construction
	private int larg, haut;

	private ArrayList<Polygone> polygones; // note : le pas oublier le s
	private ArrayList<Triangle> triangles;
	private ArrayList<Segment> segments;
	private ArrayList<Carre> carres;

	/**
	 * @brief Constructeur initialisant le panneau d'affichage
	 */
	public Affichage() {
		larg = Constantes.nbCases*Constantes.nbPixels;
		haut = Constantes.nbCases*Constantes.nbPixels;
		setPreferredSize(new Dimension(larg,haut));

		polygones = new ArrayList<Polygone>();
		triangles = new ArrayList<Triangle>();
		segments = new ArrayList<Segment>();
		carres = new ArrayList<Carre>();
	}

	/**
	 * @brief Efface le contenu du panneau en redéssinant le fond et la grille
	 * @param g Objet graphique permettant de dessiner dans le panneau
	 */
	public void efface(Graphics g) {
		// espace galactique : fond noir
		g.setColor(Color.WHITE);
		g.fillRect(0,0,larg,haut);
		// grille galactique : lignes grises
		g.setColor(Color.GRAY);
		for (int x=Constantes.nbPixels ; x<larg; x+=Constantes.nbPixels) {
			// affichage des lignes verticales
			g.drawLine(x, 0, x, haut);
		}
		for (int y=Constantes.nbPixels ; y<haut; y+=Constantes.nbPixels) {
			// affichage des lignes horizontales
			g.drawLine(0, y, larg, y);
		}

	}

	/**
	 * @brief Affiche un polygone
	 * @param g Objet graphique permettant de dessiner dans le panneau
	 * @param p Le polygone à afficher
	 */
	public void affichePolygone(Graphics g, Polygone p) {

		Color c;
		switch(p.getCol()){
			case 'x' : c = Color.WHITE;
				break;
			case 'C' : c = new Color(131, 255, 51);
				break;
			case 'V' : c = new Color(55, 129, 7);
				break;
			case 'B' : c = new Color(19, 82, 248);
				break;
			case 'S' : c = new Color(21, 80, 0);
				break;
			case 'J' : c = new Color(255, 234, 127);
				break;
			default : c = null;
		}

		int X [] = new int[p.size()];
		int Y [] = new int[p.size()];
		g.setColor(c);
		for(int i = 0; i < p.size(); ++i)
		{
			X[i] = (int)(p.getPoint(i).getX()*10) * Constantes.nbPixels/10; //Ajustement des coordonnées à la taille de la fenetre
			Y[i] = haut - (int)(p.getPoint(i).getY()*10) * Constantes.nbPixels/10; //Ajustement des coordonnées à la taille de la fenetre +  inversion de l'axe y
		}
		g.drawPolygon(X,Y,X.length); // dessine les contours du polygone
		g.fillPolygon(X,Y,X.length); // remplissage du polygone
	}


	/**
	 * @brief Affiche un Carre
	 * @param g Objet graphique permettant de dessiner dans le panneau
	 * @param p Le polygone à afficher
	 * @param c la couleur associée au polygone
	 */
	public void afficheCarre(Graphics g, Carre c) {

		int X [] = new int[4];
		int Y [] = new int[4];
		g.setColor(Color.BLACK);
		for(int i = 0; i < 4; ++i)
		{
			X[i] = (int)(c.getPoint(i).getX()*10) * Constantes.nbPixels/10;
			Y[i] = haut - (int)(c.getPoint(i).getY()*10) * Constantes.nbPixels/10;
		}
		g.drawPolygon(X,Y,X.length);
	}


	/**
	 * @brief Affiche un triangle
	 * @param g Objet graphique permettant de dessiner dans le panneau
	 * @param t le triangle à afficher
	 */
	public void afficheTriangle(Graphics g, Triangle t) {

		int X [] = new int[3];
		int Y [] = new int[3];
		Color c;
		switch(t.getCol()){
			case 'x' : c = Color.WHITE;
				break;
			case 'C' : c = new Color(131, 255, 51);
				break;
			case 'V' : c = new Color(55, 129, 7);
				break;
			case 'B' : c = new Color(19, 82, 248);
				break;
			case 'S' : c = new Color(21, 80, 0);
				break;
			case 'J' : c = new Color(255, 234, 127);
				break;
			default : c = null;
		}
		//g.setColor(c);
		g.setColor(Color.RED);
		for(int i = 0; i < 3; ++i)
		{
			X[i] = (int)(t.getPoint(i).getX()*10) * Constantes.nbPixels/10;  //Ajustement des coordonnées à la taille de la fenetre
			Y[i] = haut - (int)(t.getPoint(i).getY()*10) * Constantes.nbPixels/10;  //Ajustement des coordonnées à la taille de la fenetre +  inversion de l'axe y
		}
		g.drawPolygon(X,Y,X.length); // dessine les contours du polygone
		//g.fillPolygon(X,Y,X.length); // remplissage du polygone
	}


	/**
	 * @brief Affiche un segment
	 * @param g Objet graphique permettant de dessiner dans le panneau
	 * @param s le segment à afficher
	 */
	public void afficheSegment(Graphics g, Segment s) {
		g.setColor(Color.RED);
		g.drawLine(	(int)(s.getP1().getX()*10) * Constantes.nbPixels/10,haut - (int)(s.getP1().getY()*10) * Constantes.nbPixels/10,
		 			(int)(s.getP2().getX()*10) * Constantes.nbPixels/10,haut - (int)(s.getP2().getY()*10) * Constantes.nbPixels/10);
		 //Ajustement des coordonnées à la taille de la fenetre +  inversion de l'axe y
	}


	/**
	 * @brief Provoque le rafraichissement du panneau
	 * @param poly la liste des polygones à ajouter
	 * @param tritri la liste des triangles à ajouter
	 * @param seg la liste des segments à ajouter
	 */
	// TODO : modifier la signature au besoin
	@SuppressWarnings("unchecked")
	public void rafraichir(ArrayList<Polygone> poly, ArrayList<Triangle> tritri, ArrayList<Segment> seg, ArrayList<Carre> car) {
		polygones = (ArrayList<Polygone>) poly.clone(); // recopie la liste pour éviter des problèmes de synchronisation
		triangles = (ArrayList<Triangle>) tritri.clone(); // recopie la liste pour éviter des problèmes de synchronisation
		segments = (ArrayList<Segment>) seg.clone(); // recopie la liste pour éviter des problèmes de synchronisation
		carres = (ArrayList<Carre>) car.clone(); // recopie la liste pour éviter des problèmes de synchronisation
		repaint();
	}


	/**
	 * @brief Provoque le rafraichissement du panneau
	 * @param poly la liste des polygones à ajouter
	 * @param tritri la liste des triangles à ajouter
	 * @param seg la liste des segments à ajouter
	 */
	// TODO : modifier la signature au besoin
	@SuppressWarnings("unchecked")
	public void affichePoly(ArrayList<Polygone> poly) {
		polygones = (ArrayList<Polygone>) poly.clone(); // recopie la liste pour éviter des problèmes de synchronisation
		repaint();
	}


	/**
	 * @brief Provoque le rafraichissement du panneau
	 * @param poly la liste des polygones à ajouter
	 * @param tritri la liste des triangles à ajouter
	 * @param seg la liste des segments à ajouter
	 */
	// TODO : modifier la signature au besoin
	@SuppressWarnings("unchecked")
	public void afficheTri(ArrayList<Triangle> tritri) {
		triangles = (ArrayList<Triangle>) tritri.clone(); // recopie la liste pour éviter des problèmes de synchronisation
		repaint();
	}


	/**
	 * @brief Provoque le rafraichissement du panneau
	 * @param poly la liste des polygones à ajouter
	 * @param tritri la liste des triangles à ajouter
	 * @param seg la liste des segments à ajouter
	 */
	// TODO : modifier la signature au besoin
	@SuppressWarnings("unchecked")
	public void afficheCar(ArrayList<Carre> car) {
		carres = (ArrayList<Carre>) car.clone(); // recopie la liste pour éviter des problèmes de synchronisation
		repaint();
	}


	/**
	 * @brief Réaffiche le panneau à la demande
	 * @param g Objet graphique permettant de dessiner dans le panneau
	 */
	// @override
	public void paintComponent(Graphics g) {
		// affichage par défaut
		super.paintComponent(g);

		// le terrain de jeux et la grille
		efface(g);

		// affichage des polygones
		if(polygones != null){
			for (Polygone p : polygones) {
					affichePolygone(g,p);
			}
		}

		// affichage des triangles
		if(triangles != null){
			for (Triangle t : triangles) {
				afficheTriangle(g,t);
			}
		}

		if(segments != null){
			for (Segment s : segments) {
				afficheSegment(g,s);
			}
		}

		if(carres != null){
			for (Carre c : carres) {
				afficheCarre(g,c);
			}
		}
	}
}