/**
 * Classe Segment
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 1.0
 */

public class Segment{
  private Point p1;
  private Point p2;

  /* ----------------- Constructeur ---------------------- */

  /**
  * Construit une segment
  * @param p1   Premier point du segment
  * @param p2   Second point du segment
  */
  public Segment(Point p1, Point p2){
    this.p1 = p1;
    this.p2 = p2;
  }


  /* ----------------- Accesseurs ----------------------- */

  /**
  * Accesseur du premier point
  * @return    point p1 du segment
  */
  public Point getP1(){
    return p1;
  }


  /**
  * Accesseur du second point
  * @return    point p2 du segment
  */
  public Point getP2(){
    return p2;
  }


  /* ----------------- Méthodes ----------------------- */
  /**
  * Test si un point appartient au segment this
  * @param p un point
  * @return   boolean true si le point appartient à this ; false si p n'appartient pas à this
  */
  public boolean appartient(Point p){
    if(p != null){
      Droite d = new Droite(p1, p2);
      double eps = 0.0001;                                                      // Epsilon afin d'éviter l'erreur sur les valeur arrondies
      return ( d.appartient(p) == 0
			   && p.getX() <= (Math.max(p1.getX(), p2.getX()) + eps )
			   && p.getX() >= (Math.min(p1.getX(), p2.getX()) - eps )
			   && p.getY() <= (Math.max(p1.getY(), p2.getY()) + eps )
			   && p.getY() >= (Math.min(p1.getY(), p2.getY()) - eps ) );
    }
    return false;
  }



  /**
  * Test si deux segment s'intersectent
  * @param s   Un segment
  * @return   inte : le point de l'Intersection
  * @return   null si ces deux segment ne s'intersectent pas
  */
  public Point inter(Segment s){
    Droite d1 = new Droite(p1, p2);
    Droite d2 = new Droite(s.getP1(), s.getP2());
    Point inte = d1.inter(d2);
    if(appartient(inte) && s.appartient(inte)){
      if(p1.equals(inte)){
        //System.out.println("C'est p1");
      }else if (p2.equals(inte)){
        //System.out.println("c'est p2");
      }
      return inte;
    }
    return null;
  }



  /**
  * Calcul la longueur de this
  * @return    la distance entre p1 et p2
  */
  public double longueur(){
    double x = p2.getX() - p1.getX();
    double y = p2.getY() - p1.getY();
    return Math.sqrt(x*x + y*y);
  }



  /**
	* Determine l'angle entre deux segments
	* @param s1 un segment
	* @return la valeur en degré de l'angle formé par ces deux segments
	*/
	public double calculAngle(Segment s1)
	{
		double u1, u2, v1, v2;

		u1 = s1.getP2().getX() - s1.getP1().getX();
		u2 = s1.getP2().getY() - s1.getP1().getY();

		v1 = getP2().getX() - getP1().getX();
		v2 = getP2().getY() - getP1().getY();


		double cosTheta = (u1*v1 + u2*v2)/(Math.sqrt(u1*u1 + u2*u2) * Math.sqrt(v1*v1 + v2*v2));

		return Math.toDegrees(Math.acos(cosTheta));
	}



  /**
  * Affiche les valeurs de les points du segment
  */
  public void afficher(){
    System.out.println(" p1 = (" + p1.getX() + "; " + p1.getY() + ")    ;   p2 = (" + p2.getX() + "; " + p2.getY() + ") ");
  }

}
