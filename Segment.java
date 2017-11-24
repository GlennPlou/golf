import static java.lang.Math.*;

public class Segment
{
  private Point p1, p2;

  public Segment(Point p1, Point p2)
  {
    this.p1 = p1;
    this.p2 = p2;
  }

  public Point getP1(){
    return this.p1;
  }

  public Point getP2(){
    return this.p2;
  }
  
  public boolean appartient(Point p)
  {
	  return ( (p.coeffDirecteur(p1) == p1.coeffDirecteur(p2) || p.coeffDirecteur(p2) == p1.coeffDirecteur(p2))
			  && p.getX() <= max(p1.getX(), p2.getX()) 
			  && p.getX() >= min(p1.getX(), p2.getX())
			  && p.getY() <= max(p1.getY(), p2.getY()) 
			  && p.getY() >= min(p1.getY(), p2.getY()) );
  }

  public Point intersection(Segment s){
    Droite d1 = new Droite(p1, p2);
    Droite d2 = new Droite(s.p1, s.p2);
    Point inte = d1.intersection(d2);
    
    if(appartient(inte) && s.appartient(inte)){
      return inte;
    }
    return null;
  }
}