/**
 * Classe Programme Principal et Tests
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 2.0
 */
import java.util.*;
import java.io.*;

public class Programme{

	public static void cherchePoint(Quadtree q, Affichage panneau){
    	Scanner sb = new Scanner(System.in);
    	System.out.println("Saisissez la coordonée x : ");
    	double x = sb.nextDouble();
    	System.out.println("Saisissez la coordonée y : ");
    	double y = sb.nextDouble();
    	Point p = new Point(x,y);
    	ArrayList<Point> pts = new ArrayList<Point>();
    	pts.add(p);
    	panneau.affichePoint(pts);
			System.out.println("Le point se trouve dans ce triangle : " + q.RecherchePointQT(p).getCarre());
    	System.out.println("Le point se trouve dans ce triangle : " + q.RecherchePointQT(p).RecherchePointTriangle(p));
    }
  public static void main(String[] args){


    Terrain ter = new Terrain(args[0]);

	Trace tra;

    Affichage panneau = new Affichage();
    Fenetre fenetre = new Fenetre(panneau);

    ArrayList<Polygone> lis = ter.getList();
    panneau.affichePoly(lis);

	ArrayList<Polygone> trou = new ArrayList<Polygone>();


    ArrayList<Triangle> tri = new ArrayList<Triangle>();
    tri = ter.TriangulationTerrain();

    Quadtree Q = new Quadtree();
	Q.ConstructionQT(tri);
    ArrayList<Carre> car = new ArrayList<Carre>();
	car = Q.getListeCarre();



    int k = 1;
    while(k != 0){
    	Scanner sa = new Scanner(System.in);
		System.out.println("Veuillez saisir le chiffre correspondant à l'opération à effectuer \n(1 pour trianguler, 2 pour afficher le quadtree, 3 pour tester RecherchePointTriangle,4 pour afficher le premier tracé, 5 pour afficher le second tracé (si il existe), 6 pour réinitialiser l'affichage, 0 pour quitter) :");
		k = sa.nextInt();

		switch(k){
			case 0 : fenetre.dispose();
				break;
			case 1 : panneau.afficheTri(tri);
				break;
			case 2 : panneau.afficheCar(car);
				break;
			case 3 : cherchePoint(Q, panneau);
				break;
			case 4 : panneau.efface();
					 tra = ter.getTrac(k-4);
					 trou = tra.getList();
					 panneau.affichePoly(trou);
				break;
			case 5 : panneau.efface();
					 tra = ter.getTrac(k-4);
					 trou = tra.getList();
					 panneau.affichePoly(trou);
				break;
			case 6 : panneau.efface();
					 panneau.affichePoly(lis);
			default : System.out.println(k + " n'est pas une option");
		}
    }

  }
}