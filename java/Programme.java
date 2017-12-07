/**
 * Classe Programme Principal et Tests
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 2.0
 */
import java.util.*;
import java.io.*;

public class Programme{

	public static void cherchePoint(Quadtree q){
    	Scanner sb = new Scanner(System.in);
    	System.out.println("Saisissez la coordonée x : ");
    	double x = sb.nextDouble();
    	System.out.println("Saisissez la coordonée y : ");
    	double y = sb.nextDouble();
    	Point p = new Point(x,y);
    	System.out.println("Le point se trouve dans ce triangle : " + q.recherchePointQT(p).RecherchePointTriangle(p));
    }
  public static void main(String[] args){

    //Scanner sc = new Scanner(System.in);
    //System.out.println("Veuillez saisir le fichier :");
    //String str = sc.nextLine();
    //Terrain ter = new Terrain(str);

    
    Terrain ter = new Terrain(args[0]);

    Trace tra = ter.getTrac(0);

    Affichage panneau = new Affichage();
    Fenetre fenetre = new Fenetre(panneau);

    ArrayList<Polygone> lis = ter.getList();
    panneau.affichePoly(lis);

    ArrayList<Triangle> tri = new ArrayList<Triangle>();
    tri = ter.listTri();

    Quadtree Q = new Quadtree(tri);
    ArrayList<Carre> car = new ArrayList<Carre>();
    car = Q.getListeCarre();


    


    int k = 1;
    while(k != 0){
    	Scanner sa = new Scanner(System.in);
		System.out.println("Veuillez saisir le chiffre correspondant à l'opération à effectuer \n(1 pour trianguler, 2 pour afficher le quadtree, 3 pour tester RecherchePointTriangle, 0 pour quitter) :");
		k = sa.nextInt();

		switch(k){
			case 0 : fenetre.dispose();
				break;
			case 1 : panneau.afficheTri(tri);
				break;
			case 2 : panneau.afficheCar(car);
				break;
			case 3 : cherchePoint(Q);
				break;
			default : System.out.println(k + " n'est pas une option");
		}
    }

  }
}
