public class Polygone
{
  protected ArrayList<Point> sommets;


  public Polygone()
  {
    sommets = new ArrayList<Point>();
  }


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
  }


  public void ajoutPoint(Point p)
  {
    sommets.add(p);
  }


  public Point getPoint(int i)
  {
    return sommets[i];
  }


  public boolean equals(Object o)
  {
    if (o instanceof Polygone)
    {
      Polygone poly2 = (Polygone)o;

      boolean estDedans = true;

      if(poly2.sommets.size() == sommets.size())
      {
        for(Point pt : sommets)
        {
          estDedans = estDedans && poly2.sommets.contains(pt);
        }
        return estDedans;
      }
      else
      {
        return false;
      }      
    }
    else
    {
      return false;
    }
  }


  public String toString()
  {
    String s = "";
    int i;
    
    for(i = 0; i < sommets.size() - 1; ++i)
    {
      s += "p" + i + " : " + sommets[i].toString() + ", ";
    }

    ++i;
    s += "p" + i + " : " + sommets[i].toString() + ";\n";

    return s;
  }

}