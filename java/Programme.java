/**
 * Classe Programme Principal et Tests
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 1.1
 */
import java.util.ArrayList;

public class Programme{
  public static void main(String[] args){


    /* ------------- Test Point ----------------- */
    System.out.println("------------- Test Point -----------------");
    Point p = new Point(3, 5);
    p.afficher();
    System.out.println();
    System.out.println("Test translation : ");
    System.out.println("Données :");
    System.out.print("p : ");
    p.afficher();
    System.out.println("Translation de 2 en abscisse et 2 en ordonnée");
    System.out.println("test :");
    p.translater(2, 2);
    p.afficher();

    /* ------------- Tests Droite ---------------- */
    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("------------- Tests Droite ----------------");

    System.out.println();
    System.out.println("Test droite avec points (1, 2) & (3, 3)");
    Droite d1 = new Droite(new Point(1, 2), new Point(3 ,3));
    d1.afficher();

    System.out.println();
    System.out.println("Test droite verticale avec points (2, 1) & (2, 4)");
    Droite d3 = new Droite(new Point(2, 1), new Point(2, 4));
    d3.afficher();

    System.out.println();
    Point s = new Point(2, 4);
    System.out.println("S = (2, 4) appartient à d1 ? : " +d1.appartient(s));
    s = new Point(2, 2.5);
    System.out.println("S = (2, 2.5) appartient à d1 ? : " +d1.appartient(s));
    s = new Point(2, 1);
    System.out.println("S = (2, 1) appartient à d1 ? : " +d1.appartient(s));

    /* ------------- Test Equals -------------------- */
    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("------------- Test Equals --------------------");

    Droite d2 = new Droite(1, -2, 3);
    System.out.println();
    System.out.println("Test n°1 : ");
    System.out.println("Données :");
    System.out.print("d1 :");
    d1.afficher();
    System.out.print("d2 :");
    d2.afficher();
    System.out.println("test :");
    System.out.println("d1 = d2 ? : " + d1.equals(d2));


    d2 = new Droite(1, -2, 4);
    System.out.println();
    System.out.println("Test n°2 : ");
    System.out.println("Données :");
    System.out.print("d1 :");
    d1.afficher();
    System.out.print("d2 :");
    d2.afficher();
    System.out.println("test :");
    System.out.println("d1 = d2 ? : " + d1.equals(d2));

    /* -------------- Tests Intersections Droites --------------- */
    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("-------------- Tests Intersections Droites ---------------");

    d2 = new Droite(1, -2, 3);
    System.out.println();
    System.out.println("Test droites confondues mais équations différentes: ");
    System.out.println("Données :");
    System.out.print("d1 :");
    d1.afficher();
    System.out.print("d2 :");
    d2.afficher();
    System.out.println("test :");
    d1.inter(d2);

    d2 = new Droite(1, -2, 4);
    System.out.println();
    System.out.println("Test droites parallèles : ");
    System.out.println("Données :");
    System.out.print("d1 :");
    d1.afficher();
    System.out.print("d2 :");
    d2.afficher();
    System.out.println("test :");
    d1.inter(d2);

    d2 = new Droite(1, -2, 3);
    System.out.println();
    System.out.println("Test droites sui s'intersectent : ");
    System.out.println("Données :");
    System.out.print("d1 :");
    d1.afficher();
    System.out.print("d2 :");
    d2.afficher();
    System.out.println("test :");
    d1.inter(d2);


    d2 = new Droite(new Point(5, 5), new Point(5, 8));
    System.out.println();
    System.out.println("Test droites parallèles verticales : ");
    System.out.println("Données :");
    System.out.print("d3 :");
    d3.afficher();
    System.out.print("d2 :");
    d2.afficher();
    System.out.println("test :");
    d3.inter(d2);

    d2 = new Droite(new Point(1, 5), new Point(5, 5));
    d3 = new Droite(new Point(1, 1), new Point(5, 1));
    System.out.println();
    System.out.println("Test droites parallèles horizontales : ");
    System.out.println("Données :");
    System.out.print("d3 :");
    d3.afficher();
    System.out.print("d2 :");
    d2.afficher();
    System.out.println("test :");
    d3.inter(d2);

    d2 = new Droite(new Point(1, 1), new Point(1, 5));
    d3 = new Droite(new Point(1, 1), new Point(5, 1));
    System.out.println();
    System.out.println("Test droites perpendiculaires horizontale et verticale : ");
    System.out.println("Données :");
    System.out.print("d3 :");
    d3.afficher();
    System.out.print("d2 :");
    d2.afficher();
    System.out.println("test :");
    d3.inter(d2).afficher();


    /* -------------- Tests Intersections Segments --------------- */
    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("-------------- Tests Intersections Segment ---------------");

    Segment s1 = new Segment(new Point(1, 2), new Point(3, 3));
    Segment s2 = new Segment(new Point(1, 2), new Point(3, 3));
    System.out.println();
    System.out.println("Test segment confondus : ");
    System.out.println("Données :");
    System.out.print("s1 : ");
    s1.afficher();
    System.out.print("s2 : ");
    s2.afficher();
    System.out.println("test :");
    s1.inter(s2);


    s1 = new Segment(new Point(1, 2), new Point(3, 3));
    s2 = new Segment(new Point(1, 3), new Point(3, 4));
    System.out.println();
    System.out.println("Test segment parallèles : ");
    System.out.println("Données :");
    System.out.print("s1 : ");
    s1.afficher();
    System.out.print("s2 : ");
    s2.afficher();
    System.out.println("test :");
    s1.inter(s2);


    s1 = new Segment(new Point(1, 2), new Point(3, 3));
    s2 = new Segment(new Point(2, 1), new Point(2, 4));
    System.out.println();
    System.out.println("Test segment secant (intersection en (2, 2.5) ): ");
    System.out.println("Données :");
    System.out.print("s1 : ");
    s1.afficher();
    System.out.print("s2 : ");
    s2.afficher();
    System.out.println("test :");
    //s1.inter(s2).afficher();


    s1 = new Segment(new Point(1, 2), new Point(3, 3));
    s2 = new Segment(new Point(1, 1), new Point(1, 4));
    System.out.println();
    System.out.println("Test segment secant (intersection en p1 ): ");
    System.out.println("Données :");
    System.out.print("s1 : ");
    s1.afficher();
    System.out.print("s2 : ");
    s2.afficher();
    System.out.println("test :");
    s1.inter(s2).afficher();


    s1 = new Segment(new Point(1, 2), new Point(3, 3));
    s2 = new Segment(new Point(3, 1), new Point(3, 4));
    System.out.println();
    System.out.println("Test segment secant (intersection en p2 ): ");
    System.out.println("Données :");
    System.out.print("s1 : ");
    s1.afficher();
    System.out.print("s2 : ");
    s2.afficher();
    System.out.println("test :");
    s1.inter(s2).afficher();


    s1 = new Segment(new Point(1, 2), new Point(3, 3));
    s2 = new Segment(new Point(2, 8), new Point(2, 4));
    System.out.println();
    System.out.println("Test segment non-secant (mais leurs droites se coupent ): ");
    System.out.println("Données :");
    System.out.print("s1 : ");
    s1.afficher();
    System.out.print("s2 : ");
    s2.afficher();
    System.out.println("test :");
    /* Null pointer exception */
    // s1.inter(s2).afficher();


    s1 = new Segment(new Point(1, 1), new Point(3, 3));
    s2 = new Segment(new Point(3, 1), new Point(3, 4));
    System.out.println();
    System.out.println("Test longueur de segments : ");
    System.out.println("Données :");
    System.out.print("s1 : ");
    s1.afficher();
    System.out.print("s2 : ");
    s2.afficher();
    System.out.println("test :");
    System.out.println("longueur de s1 (normalement 2.828... ) = " +s1.longueur());
    System.out.println("longueur de s2 (normalement 3) = " +s2.longueur());



    /* ------------- Test Triangles -------------------- */
    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("------------- Test Triangles --------------------");

    Triangle t = new Triangle(new Point(1, 1), new Point(2, 4), new Point(4, 2));
    System.out.println();
    System.out.println("Test affichage polygone ");
    t.afficher();

    System.out.println();
    System.out.println("Test point a l'exterrieur du triangle ");
    System.out.println(t.appartient(new Point(5, 4)));

    System.out.println();
    System.out.println("Test point a l'interrieur du triangle ");
    System.out.println(t.appartient(new Point(2, 2)));

    System.out.println();
    System.out.println("Test point sur un segment du triangle ");
    System.out.println(t.appartient(new Point(3, 3)));

    System.out.println();
    System.out.println("Test point sur un sommet du triangle ");
    System.out.println(t.appartient(new Point(1, 1)));

    Triangle t2 = new Triangle(new Point(2, 4), new Point(4, 2), new Point(1, 1));
    System.out.println();
    System.out.println("Test equals deux triangles  ");
    System.out.println("Données :");
    System.out.print("t : ");
    t.afficher();
    System.out.print("t2 : ");
    t2.afficher();
    System.out.println("Test : ");
    System.out.println(t.equals(t2));




    /* ------------- Test Carrés -------------------- */
    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("------------- Test Carrés --------------------");

    Carre c = new Carre(new Point(1, 1), 5);
    System.out.println();
    System.out.println("test constructeur carré droit : ");
    c.afficher();

    c = new Carre(new Point(1, 1), new Point(1, 5), new Point(5, 5), new Point(5, 1));
    System.out.println();
    System.out.println("test constructeur carré avec 4 points qui forment réellement un carré : ");
    c.afficher();

    System.out.println();
    System.out.println("test constructeur carré avec 4 points qui ne forment pas un carré : ");
    c = new Carre(new Point(1, 1), new Point(1, 3), new Point(5, 5), new Point(5, 1));
    //c.afficher();           /* Erreur car objet vide */



    /* ------------- Test Intersection Triangle & Carrés -------------------- */
    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("------------- Test Intersection Triangle et Carrés --------------------");

    c = new Carre(new Point(1, 1), 5);
    t = new Triangle(new Point(5, 5), new Point(5, 8), new Point(7, 5));
    System.out.println();
    System.out.println("Test 1 : cas lambda un point dans le carré ");
    System.out.println("Données :");
    System.out.print("c : ");
    c.afficher();
    System.out.print("t : ");
    t.afficher();
    System.out.println("Test : ");
    System.out.println(c.interTri(t));


    c = new Carre(new Point(1, 1), 5);
    t = new Triangle(new Point(6, 3), new Point(8, 1), new Point(9, 5));
    System.out.println();
    System.out.println("Test 2 : cas ou un seul point sur un côté du carré ");
    System.out.println("Données :");
    System.out.print("c : ");
    c.afficher();
    System.out.print("t : ");
    t.afficher();
    System.out.println("Test : ");
    System.out.println(c.interTri(t));


    c = new Carre(new Point(1, 1), 5);
    t = new Triangle(new Point(7, 0), new Point(3, 7), new Point(0, 5));
    System.out.println();
    System.out.println("Test 3 : on a un maximum d'intersection (normalement 6) ");
    System.out.println("Données :");
    System.out.print("c : ");
    c.afficher();
    System.out.print("t : ");
    t.afficher();
    System.out.println("Test : ");
    System.out.println(c.interTri(t));

    System.out.println();
    Droite ca = new Droite(new Point(0, 4), new Point(7, 0));
    Droite de = new Droite(new Point(1, 1), new Point(6, 1));
    ca.afficher();
    de.afficher();
    ca.inter(de).afficher();



    /* ------------- Tests Affichage -------------------- */

  //  Affichage panneau = new Affichage();
  //  Fenetre fenetre = new Fenetre(panneau);

    ArrayList<Point> liste = new ArrayList<Point>();
    liste.add(new Point(1,5));
    liste.add(new Point(1,1));
    liste.add(new Point(6,1));
    //liste.add(new Point(6,5));
    liste.add(new Point(5,5));
    liste.add(new Point(5,2));
    liste.add(new Point(4,2));
    //liste.add(new Point(4,5));
    liste.add(new Point(3,5));
    liste.add(new Point(3,2));
    liste.add(new Point(2,2));
    //liste.add(new Point(2,5));

    Polygone poly = new Polygone(liste);

/*
    ArrayList<Polygone> polyListe = new ArrayList<Polygone>();
    polyListe.add(poly);

    Triangle ta = new Triangle(new Point(1,9), new Point(3,7), new Point(5,9));
    Triangle tb = new Triangle(new Point(7,5), new Point(8,9), new Point(9,9));

    ArrayList<Triangle> tritriListe = new ArrayList<Triangle>();
    tritriListe.add(ta);
    tritriListe.add(tb);


    Segment sa = new Segment(new Point(5.5,5.5), new Point(6.5,9.5));
    Segment sb = new Segment(new Point(6.5,5.5), new Point(7.5,9.5));

    ArrayList<Segment> SegListe = new ArrayList<Segment>();
    SegListe.add(sa);
    SegListe.add(sb);

    panneau.rafraichir(polyListe, tritriListe, SegListe);

    Fichier f = new Fichier("DescriptionFIgureGolf2.txt");

*/

    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();

    poly.afficher();

    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();

    ArrayList<Triangle> trinagule = poly.triangule();

    for(Triangle tr : trinagule){
      tr.afficher();
    }
  }
}
