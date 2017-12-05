/**
 * Classe Polygone
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 1.0
 */

import java.util.*;

public class Polygone{
  ArrayList<Point> sommets;
  char col;


  /* -------------------- Constructeurs ------------------ */

  /**
  * Construit un polygone vide
  */
  public Polygone(){
    sommets = new ArrayList<Point>();
    col = 'x';
  }

  /**
  * Construit un polygone avec unhe couleur
  * @param c couleur du polygone
  */
  public Polygone(char c){
    sommets = new ArrayList<Point>();
    col = c;
  }


  /**
  * Construit une polygone avec une liste déjà fournie
  * @param liste   Un ArrayList de Points
  */
  public Polygone(ArrayList<Point> liste)
  {
    sommets = new ArrayList<Point>();

    for(Point pt : liste)
    {
        if(!sommets.contains(pt))
        {
          sommets.add(pt);
        }
    }
    col = 'x';
  }

  /* ---------------------- Accesseurs ------------------------ */

  /**
  * Accesseur du point a la i-éme position dans la liste de sommets
  * @param i L'indice du point à acceder
  * @return le point a la ième position
  */
  public Point getPoint(int i){
    return sommets.get(i);
  }


  /**
  * Accesseur de la taille de l'ArrayList sommets
  * @return Le nombre de points du polygone
  */
  public int size(){
    return sommets.size();
  }

  /**
  * Accesseur de la couleur du polygone
  * @return Le caractère désignant la couleur du poly
  */
  public char getCol(){
    return col;
  }

  /* --------------------- Mutateurs ------------------------ */

  /**
  * Mutateur de la couleur du polygone
  */
  public void setCol(char c){
    col = c;
  }

  /* --------------------- Méthodes ---------------------- */

  /**
  * Ajoute un point a la fin de la liste de Sommets
  * @param p   Le point a ajouter
  */
  public void ajoutPoint(Point p){
    sommets.add(p);
  }


  /**
  * Redefinition de la méthode equals
  * @param o   un objet
  * @return    true si cette objet est un polygone et que ce polygone est identique à this
  * @return    false si cet objet n'est pas un polygone ou si c'est un polygone différent
  */
  public boolean equals(Object o){
    if (o instanceof Polygone){
      Polygone poly2 = (Polygone)o;

      boolean b = true;

      if(poly2.sommets.size() == sommets.size()){
        if(poly2.sommets.contains(sommets.get(0))){
          int dec = poly2.sommets.indexOf(sommets.get(0));
          int i = 1;
          int ind;
          while(i < sommets.size() && b == true){
            ind = (dec + i) % sommets.size();
            b = b && (poly2.sommets.contains(sommets.get(i)) && poly2.sommets.get(ind).equals(sommets.get(i)));
            ++i;
          }
          return b && col == poly2.getCol();
        }
        return false;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }


  /**
  * Redefinition de la méthode toString
  * @return    la valeur de chaque sommet du polygone dans une chaine de caractère
  */
  public String toString(){
    String s = "";
    int i;

    for(i = 0; i < sommets.size() - 1; ++i){
      s = s + "Point " + (i+1) + " : " + getPoint(i).toString() + ",\n";
    }
    s += "Point " + (i+1) + " : " + getPoint(i).toString() + ";\n";
    return s;
  }



  /**
  * Affiche les sommets du polygone
  */
  public void afficher(){
    int i;

    for(i = 0; i < sommets.size() - 1; ++i){
      System.out.print( "Point " + (i+1) + " : " + getPoint(i).toString());
    }

    System.out.println("Point " + (i+1) + " : " + getPoint(i).toString());
  }


  /**
  * Triangule le polygone this
  * @return l'arrylist de tous les Triangles qui forment le polygone
  */
  public ArrayList<Triangle> triangule(){
    ArrayList<Triangle> res = new ArrayList<Triangle>();
    Object o = sommets.clone();
    ArrayList<Point> clone = (ArrayList<Point>)o;
    int ind;
    int modulo;
    while(clone.size() > 3){
      modulo = clone.size();
      ind = trouveOreille(clone);
      System.out.println(ind);
      res.add(new Triangle(clone.get((ind-1+modulo) % modulo), clone.get(ind), clone.get((ind+1) % modulo), col ) );
      clone.remove(ind);
    }
    res.add(new Triangle(clone.get(0), clone.get(1), clone.get(2), col));
    return res;
  }



  /**
  * Trouve l'oreille du polygone passé en paramètre
  * @param p polygone
  * @return indice du point ou se situe une des oreilles du polygone
  */
  private int trouveOreille(ArrayList<Point> p){
    boolean oreille = false;
    int k = p.size();
    int i = 0;
    int j;
    Segment s;
    Droite d;
    Segment sj;
    while(i < k && oreille == false){
      d = new Droite(p.get((i-1+k) % k), p.get((i+1) % k) );
      s = new Segment(p.get((i-1+k) % k), p.get((i+1) % k));
      j = (i+2) % k;
      oreille = (d.appartient(p.get(i)) == -1);
      while(oreille == true && (j+2) % k != i){
        sj = new Segment(p.get(j%k), p.get((j+1) % k));
        oreille = oreille && (s.inter(sj) == null);
        ++j;
      }
      ++i;
    }
    return (i-1+k) % k;
  }
}
