/**
 * Classe Point
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 1.0
 */
public class Point{
  private double x;
  private double y;

  /* ----------------- Constrcteur ------------------- */
  /**
  * Construit un point.
  * @param x   valeur abscisse de ce point
  * @param y   valeur ordonnée de ce point
  */
  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  /* ----------------- Accesseurs ---------------------- */
  /**
  * Accesseur de l'abscisse de this.
  * @return  x   l'abscisse de this
  */
  public double getX(){
    return x;
  }

  /**
  * Accesseur de l'ordonnée de this
  * @return   y   l'ordonnée de this
  */
  public double getY(){
    return y;
  }

  /* ------------------ Mutateurs -------------------- */
  /**
  * Change la valeur de x
  * @param nx   nouvelle valeur d'abscisse de ce point
  */
  public void setX(double nx){
    x = nx;
  }

  /**
  * Change la valeur de y
  * @param ny   nouvelle valeur d'ordonnée de ce point
  */
  public void setY(double ny){
    y = ny;
  }

  /* ------------------- Méthodes ------------------ */
  /**
  * Translate le point this
  * @param px   valeur qui faut ajouter a l'abscisse de this
  * @param py   valeur qui faut ajouter a l'ordonnée de this
  */
  public void translater(double px, double py){
    x += px;
    y += py;
  }

  /**
  * Affiche les valeurs du point
  */
  public void afficher(){
      System.out.println("x = " + x + " & y = " + y);
  }

  /**
  * Redefinition de la méthode toString
  * @return les valeurs du point dans une chaine de caractères
  */
  public String toString(){
    return "(" + x + ", " + y + ") ";
  }


  /**
  * Redefinition de la méthode equals
  * @param o   un objet
  * @return    true si cette objet est un point et que ce point est identique à this
  * @return    false si cet objet n'est pas un point ou si c'est un point différent
  */
  public boolean equals(Object o){
    if(o instanceof Point){
      Point p = (Point)o ;
      return ( (p.getX() == x) && (p.getY() == y) );
    } else {
      return false;
    }
  }
}
