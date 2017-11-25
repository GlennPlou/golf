import static java.lang.*;

public class Segment
{
  private Point p1, p2;

  public Segment()
  {
    p1 = new Point();
    p2 = new Point();
  }


  public Segment(Point p1, Point p2)
  {
    this.p1 = p1;
    this.p2 = p2;
  }


  public Point getP1()
  {
    return this.p1;
  }


  public Point getP2()
  {
    return this.p2;
  }

  
  public boolean appartient(Point p)  //Indique si un point appartient au segment
  {
    Droite d = new Droite(p1, p2);

	  return ( d.appartient(p) == 0
			  && p.getX() <= max(p1.getX(), p2.getX()) 
			  && p.getX() >= min(p1.getX(), p2.getX())
			  && p.getY() <= max(p1.getY(), p2.getY()) 
			  && p.getY() >= min(p1.getY(), p2.getY()) );
  }

  public Point intersection(Segment s) //Retourne le point d'intersection s'il existe
  {
    Droite d1 = new Droite(p1, p2);
    Droite d2 = new Droite(s.p1, s.p2);

    Point inter = d1.intersection(d2);

    if(inter == null)
      return null;
    else if(inter.equals(p1))
      return p1;
    else if(inter.equals(p2))
      return p2;
    else if(inter.equals(s.p1))
      return s.p1;
    else if(inter.equals(s.p2))
      return s.p2;


    if(appartient(inter) && s.appartient(inter))
      return inter;
    else
      return null;
  }


  public boolean equals(Object o)
  {
    if(o instanceof Segment)
    {
      Segment s = (Segment)o;

      return p1.equals(s.p1) && p2.equals(s.p2);
    }
    else
    {
      return false;
    }
  }


  public String toString()
  {
    return "p1 = " + p1.toString() + "\t p2 = " + p2.toString();
  }
}