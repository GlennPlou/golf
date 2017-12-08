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
  	* Construit un Quadtree à partir d'un ArrayList de triangles
  	*/
	public void ConstructionQT(ArrayList<Triangle> liste){
		origine = new Point(0,0);
		taille = Constantes.nbCases;
		noeuds = new ArrayList<Quadtree>();
		triangles = new ArrayList<Triangle>();
		ajouterListe(liste);
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
		triangles = new ArrayList<Triangle>();
		ajouterListe(liste);
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


	/**
  	* Accesseur de la zone carrée représentée par la région du quadtree
  	* @return le carré formant le quadtree
  	*/
	public Carre getCarre(){
		return new Carre(origine, taille);
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
	public Quadtree RecherchePointQT(Point p){
		if(estFeuille()){
			return this;
		}else{
			if(p.getX() <= origine.getX() + taille/2)//recherche zone 1 et 4
			{
				if(p.getY() >= origine.getY() + taille/2)//recherche zone 1
				{//System.out.println("RECHERCHE ZONE 1");
					return noeuds.get(0).RecherchePointQT(p);
				}
				else//recherche zone 4
				{//System.out.println("RECHERCHE ZONE 4");
					return noeuds.get(3).RecherchePointQT(p);
				}
			}
			else// recherche zone 2 et 3
			{
				if(p.getY() >= origine.getY() + taille/2)//recherche zone 2
				{//System.out.println("RECHERCHE ZONE 2");
					return noeuds.get(1).RecherchePointQT(p);
				}
				else//recherche zone 3
				{//System.out.println("RECHERCHE ZONE 3");
					return noeuds.get(2).RecherchePointQT(p);
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


	/**
  	* Determine si un triangle se trouve dans une région, sans qu'il y ait d'intersection
	* @param t le triangle à tester
	* @return true si le triangle se situe entièrement dans le carré formé par la région
  	*/
	public boolean TriangleDansRegion(Triangle t){
		Carre c = new Carre(origine, taille);

		return c.TriangleDansCarre(t);
	}


	/**
  	* Recherche à quel triangle appartient le point retourné par recherchePointQT
		* @param p le point à rechercher
		* @return le triangle qui contient le point recherché
  	*/
	public Triangle RecherchePointTriangle(Point p){

		ArrayList<Triangle> NvListeTri = new ArrayList<Triangle>();
		Triangle tri;

		for(int i = 0; i < triangles.size() ; ++i) {
			if(triangles.get(i).appartient(p) != -1){
				NvListeTri.add(triangles.get(i));
			}
		}
		if(NvListeTri.size() == 1){
			tri = NvListeTri.get(0);
		}else{
			tri = prioriteMax(NvListeTri);
		}
		return tri;
	}

	/**
		* Recherche le triangle avec la priorité maximale (en fonction de sa couleur) dans une liste de triangle donnée
		* @param listeTri la liste des triangles à analyser
		* @return le triangle ayant la plus grande priorité
		*/
	public Triangle prioriteMax(ArrayList<Triangle> listeTri){
		int Tab [] = new int[listeTri.size()];

		for(int i = 0; i < listeTri.size(); ++i){
			switch(listeTri.get(i).getCol()){
				case 'C' : Tab[i] = 5;
					break;
				case 'V' : Tab[i] = 4;
					break;
				case 'J' : Tab[i] = 3;
					break;
				case 'S' : Tab[i] = 2;
					break;
				case 'B' : Tab[i] = 1;
					break;
				default : Tab[i] = 0;
			}
		}
		int max = 0;
		int indice = 0;
		for(int i = 0; i < listeTri.size(); ++i){
			if(Tab[i] > max){
				max = Tab[i];
				indice = i;
			}
		}
		System.out.println(indice);
		System.out.println(listeTri.size());
		return listeTri.get(indice);
	}


	/**
  	* Permet d'ajouter un triangle au quadtree. On détermine alors si ce dernier nécessite d'être découpé ou non
	* @param t le triangle à ajouter
  	*/
	public void ajouter(Triangle t){
		if(estFeuille()){ //si on se trouve dans un quadtree sans noeuds, on va potentiellement ajouter en découpant (nouveaux quadtrees)

				//on ajoute alors tous les triangles qui, soit intersectent le carré formé par la région, soit se trouvent entièrement dans la zone
				if(TestRegionIntersecteTriangle(t) || TriangleDansRegion(t)){
					triangles.add(t);
				}

				// si on a déjà trop de triangles dans notre région, on découpe. De plus, on impose une limite de profondeur dans notre quadtree
				if(triangles.size() >= Constantes.T && taille > Constantes.nbCases/Math.pow(2, Constantes.profondeurMax) ){
					Quadtree zone1 = new Quadtree(new Point(origine.getX(), origine.getY() + taille/2), taille/2, triangles);
					Quadtree zone2 = new Quadtree(new Point(origine.getX() + taille/2, origine.getY() + taille/2), taille/2, triangles);
					Quadtree zone3 = new Quadtree(new Point(origine.getX() + taille/2,origine.getY()), taille/2, triangles);
					Quadtree zone4 = new Quadtree(new Point(origine.getX(),origine.getY()), taille/2, triangles);

					noeuds.add(zone1);
					noeuds.add(zone2);
					noeuds.add(zone3);
					noeuds.add(zone4);

					triangles.clear();
				}

		}else{//si on se trouve dans un quadtree déjà découpé, on va l'ajouter dans le bon noeud (pas la peine de redécouper)
			for(Quadtree q : noeuds){
				q.ajouter(t);
			}
		}
	}


	/**
  	* Permet d'ajouter une liste de triangles au quadtree
	* @param liste la liste des triangles à ajouter
  	*/
	public void ajouterListe(ArrayList<Triangle> liste){
		for(int i = 0; i < liste.size(); ++i){
			ajouter(liste.get(i));
		}
	}

	public ArrayList<Carre> getListeCarre(){
		ArrayList<Carre> c = new ArrayList<Carre>();
		getCarreRec(c);
		return c;
	}

	public void getCarreRec(ArrayList<Carre> c){
		if(!estFeuille()){
			noeuds.get(0).getCarreRec(c);
			noeuds.get(1).getCarreRec(c);
			noeuds.get(2).getCarreRec(c);
			noeuds.get(3).getCarreRec(c);
		}
		c.add(getCarre());
	}

}
