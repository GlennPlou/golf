/**
 * Classe Droite
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 1.0
 */

import java.lang.*;

public class Droite{
  private double a;
  private double b;
  private double c;

  /* -------------------- Constructeurs ------------------ */

  /**
  * Construit une droite
  * @param a   valeur a
  * @param b   valeur b
  * @param c   valeur c
  */
  public Droite(double a, double b, double c){
    this.a = a;
    this.b = b;
    this.c = c;
  }

  /**
  * Construit une droite
  * @param p1   Un point qui est sur la droite
  * @param p2   Un second point sur la droite
  */
  public Droite(Point p1, Point p2){
    assert(!p1.equals(p2));         // assertion pour avoir deux point différents sinon on ne peut pas avoir de droite

    a = (p2.getY() - p1.getY()) * (-1);
    if(a == -0.0) a = 0;

    b = p2.getX() - p1.getX();
    if(b == -0.0) b = 0;

    c = (p1.getX()*a + p1.getY()*b) * (-1);
    if(c == -0.0) c = 0;
  }

  /**
  * Construit une droite
  * @param p1   Un point qui est sur la droite
  * @param p2   Un second point sur la droite
  */
  public void CalculCoefficientsDroite(Point p1, Point p2){
    assert(!p1.equals(p2));         // assertion pour avoir deux point différents sinon on ne peut pas avoir de droite

    a = (p2.getY() - p1.getY()) * (-1);
    if(a == -0.0) a = 0;

    b = p2.getX() - p1.getX();
    if(b == -0.0) b = 0;

    c = (p1.getX()*a + p1.getY()*b) * (-1);
    if(c == -0.0) c = 0;
  }

  /* ----------------------- Accesseurs ------------------- */

  /**
  * Accesseur de a de this.
  * @return  a
  */
  public double getA(){
    return a;
  }

  /**
  * Accesseur de b de this.
  * @return  b
  */
  public double getB(){
    return b;
  }

  /**
  * Accesseur de c de this.
  * @return  c
  */
  public double getC(){
    return c;
  }

  /* ----------------------- Méthodes --------------------- */

  /**
  * Redefinition de la méthode toString
  * @return les valeurs de l'équation de la droite dnas une chaine de caractères
  */
  public String toString(){
    return " a = " + a + ";  b = " + b + ";   c = " + c;
  }

  /**
  * Affiche les valeurs de la droite
  */
  public void afficher(){
    System.out.println(" a = " + a + ";  b = " + b + ";   c = " + c);
  }

  /**
  * Determine si un Point appartient a la droite this
  * @param p   Un point qui est ou non sur la droite
  * @return    -1 si p est sur le demi plan en dessus ou a gauche de la droite
  * @return    0 si p est sur la droite
  * @return    +1 si p est sur le demi plan en dessous ou a droite de la droite
  */
  public int appartient(Point p){
    if ((a*p.getX() + b*p.getY() + c) == 0){
      return 0;
    } else if ((a*p.getX() + b*p.getY() + c) > 0){
      return 1;
    } else {
      return -1;
    }
  }

  /**
  * Determine si deux droites s'intersectent
  * @param d   Une droite
  * @return    null si ces deux droites sont parallèles ou confondues (on affichera alors le cas)
  * @return    p Le point d'intersection de ces deux droites
  */
  public Point inter(Droite d){
      double k;
      Point p;
      if(d.getA() != 0){
        k = a / d.getA();
      } else {
        k = b/ d.getB();
      }
      if(equals(d)){
        //System.out.println("Confondues !");
        return null;
      } else if ((k*d.getA() == a) && (k*d.getB() == b)){
        //System.out.println("Parallèles !");
        return null;
      } else {
        double x;
        double y;
        if(this.b != 0){
          x = (-d.c + d.b*(this.c/this.b)) / (d.a - d.b*(this.a/this.b)); //Resolution du systeme d'equations, pour n'importe quel b (pas forcement -1)
          y = ( -(this.a)*x - (this.c)) / this.b;
        } else {
          x = (-this.c + this.b*(d.c/d.b)) / (this.a - this.b*(d.a/d.b));
          y = ( -(d.a)*x - (d.c)) / d.b;
        }
        p = new Point(x,y);
      }
      return p;
  }



  /**
  * Redefinition de la méthode equals
  * @param o   un objet
  * @return    true si cette objet est une droite et que cette droite est identique à this
  * @return    false si cet objet n'est pas une droite ou si c'est une droite différente
  */
  public boolean equals(Object o){
    if(o instanceof Droite){
      Droite d = (Droite)o ;
      double k;
      if(d.getA() != 0){
        k = a / d.getA();
      } else {
        k = b/ d.getB();
      }
      return ( (k*d.getA() == a) && (k*d.getB() == b) && (k*d.getC() == c) );
    } else {
      return false;
    }
  }
}
