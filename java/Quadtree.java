/**
 * Classe Quadtree
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 1.0
 */

import java.util.ArrayList;

public class Quadtree{

	private Point origine;
	private double taille;
	private ArrayList<Quadtree> noeuds;
	private ArrayList<Triangle> triangles;

	/* ------------------------ Constructeurs ---------------------------- */

	/**
  	* Construit un Quadtree vide
  	*/
	public Quadtree(){
		origine = new Point(0,0);
		taille = Constantes.nbCases;
		noeuds = new ArrayList<Quadtree>();
		triangles = new ArrayList<Triangle>();
	}


	/**
  	* Construit un Quadtree à partir du terrain donné et des triangles obtenus par l'opération de triangulation
  	* @param o le point à l'origine (bas-gauche) du quadtree
  	* @param longueur la taille du terrain
  	* @param liste la liste des triangles obtenus par triangulation
  	*/	
	public Quadtree(Point o, double longueur, ArrayList<Triangle> liste){
		origine = o;
		taille = longueur;
		noeuds = new ArrayList<Quadtree>();
		triangles = liste;
	}


	/**
  	* Construit un Quadtree suite au découpage d'une région
  	* @param o le point à l'origine (bas-gauche) du quadtree
  	* @param longueur la taille du quadtree
  	*/	
	public Quadtree(Point o, double longueur){
		origine = o;
		taille = longueur;
		noeuds = new ArrayList<Quadtree>();
		triangles = new ArrayList<Triangle>();
	}


	/* ---------------------- Accesseurs ------------------------ */



	/**
  	* Accesseur du point à l'origine du quadtree
  	* @return le point à l'origine
  	*/
	public Point getOrigine(){
		return origine;
	}


	/**
  	* Accesseur de la taille des cotés du quadtree
  	* @return la taille des cotés
  	*/
	public double getTaille(){
		return taille;
	}


	/**
  	* Accesseur de la liste des noeuds(fils) du quadtree
  	* @return les noeuds du quadtree
  	*/
	public ArrayList<Quadtree> getNoeuds(){
		return noeuds;
	}


	/**
  	* Accesseur de la liste des triangle du quadtree
  	* @return les triangles du quadtree
  	*/
	public ArrayList<Triangle> getTriangles(){
		return triangles;
	}


	/* ----------------------- Méthodes ----------------------- */


	/**
  	* Determine si le quadtree est une feuille (possède des fils ou non)
	* @return true si la quadtree ne possède pas de fils
  	*/
	public boolean estFeuille(){
		return noeuds.size() == 0;
	}


	/**
  	* Recherche la région qui contient un point
  	* @param p le point à rechercher
	* @return une feuille du quadtree représentant la région qui contient le point
  	*/
	public Quadtree recherchePointQT(Point p){
		if(estFeuille()){
			return this;
		}else{
			if(p.getX() <= origine.getX() + taille/2)//recherche zone 1 et 4
			{
				if(p.getY() >= origine.getX() + taille/2)//recherche zone 1
				{
					return noeuds.get(0).recherchePointQT(p);
				}
				else//recherche zone 4
				{
					return noeuds.get(3).recherchePointQT(p);
				}
			}
			else// recherche zone 2 et 3
			{
				if(p.getY() >= origine.getX() + taille/2)//recherche zone 2
				{
					return noeuds.get(1).recherchePointQT(p);
				}
				else//recherche zone 3
				{
					return noeuds.get(2).recherchePointQT(p);
				}
			}
		}
	}


	/**
  	* Determine si une région intersecte un triangle donné
	* @param t le triangle à tester
	* @return true si le triangle et le carré formé par la région s'intersectent
  	*/
	public boolean TestRegionIntersecteTriangle(Triangle t){
		Carre c = new Carre(origine, taille);

		return c.interTri(t);
	}

}