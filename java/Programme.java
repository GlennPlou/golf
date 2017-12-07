/**
 * Classe Programme Principal et Tests
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 2.0
 */
import java.util.*;
import java.io.*;

public class Programme{
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    System.out.println("Veuillez saisir le fichier :");
    String str = sc.nextLine();

    
    Terrain ter = new Terrain(str);

    Trace tra = ter.getTrac(0);

    Affichage panneau = new Affichage();
    Fenetre fenetre = new Fenetre(panneau);

    ArrayList<Polygone> lis = ter.getList();
    ArrayList<Triangle> tri = new ArrayList<Triangle>();
    tri = ter.listTri();
    ArrayList<Segment> seg = new ArrayList<Segment>();
    ArrayList<Carre> car = new ArrayList<Carre>();

    //lis = tra.getList();



    Quadtree Q = new Quadtree(tri);
    Point p = new Point(2.2,8);
    Quadtree Qa = Q.recherchePointQT(p);
    Carre Ca = Qa.getCarre();

    car.add(Ca);
    panneau.rafraichir(lis, tri, seg, car);
    System.out.println(tri);

    System.out.println("Le point est ici : " + Qa.RecherchePointTriangle(p));


    //panneau.rafraichir(lis, tri, seg, car);

  }
}
