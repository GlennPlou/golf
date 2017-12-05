/**
 * Classe Triangle
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 1.0
 */

import java.util.*;
public class Triangle extends Polygone{

  /* ------------------- Constrcteurs ---------------------- */

  /**
  * Construit un Triangle incolore
  * @param a le premier point du Triangle
  * @param b le second point du Triangle
  * @param c le troisième point du Triangle
  */
  public Triangle(Point a, Point b, Point c){
    super();
    ajoutPoint(a);
    ajoutPoint(b);
    ajoutPoint(c);
  }

  /**
  * Construit un Triangle incolore
  * @param a le premier point du Triangle
  * @param b le second point du Triangle
  * @param c le troisième point du Triangle
  * @param col la couleur du triangle;
  */
  public Triangle(Point a, Point b, Point c, char col){
    super(col);
    ajoutPoint(a);
    ajoutPoint(b);
    ajoutPoint(c);
  }

  /**
  * Construit un triangle avec un ArrayList de 3 points éxistant
  * @param list une liste de trois Points
  */
  public Triangle(ArrayList<Point> list){
    super(list);
  }


  /* ------------------- Méthodes --------------------------- */

  /**
  * determine la position d'une point p vis a vis d'un triangle (this)
  * @param p un Point
  * @return 0 si p est un sommet du Triangle
  * @return 1 si p est sur un des segment du Triangle
  * @return 2 si p est dans le Triangle
  * @return -1 si p n'est pas dans le triangle
  */
  public int appartient(Point p){
    Droite ab = new Droite(getPoint(0), getPoint(1));
    Droite bc = new Droite(getPoint(1), getPoint(2));
    Droite ca = new Droite(getPoint(2), getPoint(0));

    Segment sab = new Segment(getPoint(0), getPoint(1));
    Segment sbc = new Segment(getPoint(1), getPoint(2));
    Segment sca = new Segment(getPoint(2), getPoint(0));

    boolean inte = (ab.appartient(p) == ab.appartient(getPoint(2)));       // Determine si le point est strictement a l'interrieur du triangle
    inte = inte && (bc.appartient(p) == bc.appartient(getPoint(0)));
    inte = inte && (ca.appartient(p) == ca.appartient(getPoint(1)));

    if(p.equals(getPoint(0)) || p.equals(getPoint(1)) || p.equals(getPoint(2))){
      return 0;
    } else if(sab.appartient(p) || sbc.appartient(p) || sca.appartient(p)){
      return 1;
    } else if(inte){
      return 2;
    } else {
      return -1;
    }
  }


  /**
  * determine le nombre d'intersections avec un segment avec une certaine contrainte afin de conpter correctement les intersections entre triangle et carré
  * @param s un Segment
  * @return res le nombre d'intersection avec les côtés du Triangle
  */
  public int interSeg(Segment s){
    int res = 0;

    Segment ab = new Segment(getPoint(0), getPoint(1));
    Segment bc = new Segment(getPoint(1), getPoint(2));
    Segment ca = new Segment(getPoint(2), getPoint(0));

    if(ab.inter(s) != null && !ab.inter(s).equals(s.getP2()) && !ab.inter(s).equals(getPoint(1)) ){
      ab.inter(s).afficher();
      res = res + 1;
    }
    if(bc.inter(s) != null && !bc.inter(s).equals(s.getP2()) && !bc.inter(s).equals(getPoint(2))){
      bc.inter(s).afficher();
      res = res + 1;
    }
    if(ca.inter(s) != null && !ca.inter(s).equals(s.getP2()) && !ca.inter(s).equals(getPoint(0))){
      ca.inter(s).afficher();
      res = res + 1;
    }
    return res;
  }

}
