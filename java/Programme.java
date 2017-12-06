/**
 * Classe Programme Principal et Tests
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 2.0
 */
import java.util.ArrayList;
import java.io.*;

public class Programme{
  public static void main(String[] args){


    Terrain ter = new Terrain("DescriptionFIgureGolf2.txt");

    Affichage panneau = new Affichage();
    Fenetre fenetre = new Fenetre(panneau);

    ArrayList<Polygone> lis = ter.getList();
    ArrayList<Triangle> tri = new ArrayList<Triangle>();
    tri = ter.listTri();
    ArrayList<Segment> seg = new ArrayList<Segment>();
    ArrayList<Carre> car = new ArrayList<Carre>();



    Point a = new Point(2.2,8);
    Point b = new Point(3.5,8);
    Point c = new Point(3,9);
    Triangle tc = new Triangle(c, a, b, 'C');

    System.out.println("tc : " + tri.contains(tc));


    //Polygone p = lis.get(9);
    //tri = p.triangule();
    //lis = new ArrayList<Polygone>();
    //panneau.rafraichir(lis, tri, seg);

    Quadtree Q = new Quadtree();
    Q.ajouterListe(tri);

    Point p = new Point(2.4,8.1);

    Quadtree Qa = Q.recherchePointQT(p);
    System.out.println(Qa.getTriangles());
    Carre Ca = Qa.getCarre();

    car.add(Ca);
    panneau.rafraichir(lis, tri, seg, car);

    //System.out.println("Le point est ici : " + Qa.RecherchePointTriangle(p));


    //panneau.rafraichir(lis, tri, seg, car);

  }
}
