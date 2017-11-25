import java.util.*;

public class Triangle extends Polygone
{
	
	public Triangle(Point p1, Point p2, Point p3)
	{
		super();
		ajoutPoint(p1);
		ajoutPoint(p2);
		ajoutPoint(p3);
	}
	

	public int positionDuPoint(Point p)	//Indique si un point se trouve sur le triangle, à l'intérieur ou à l'extérieur.
	{		
		Segment s1,s2,s3;
		s1 = new Segment(getPoint(0),getPoint(1));
		s2 = new Segment(getPoint(1),getPoint(2));
		s3 = new Segment(getPoint(2),getPoint(0));
		
		Droite d1,d2,d3;
		d1 = new Droite(getPoint(0),getPoint(1));
		d2 = new Droite(getPoint(1),getPoint(2));
		d3 = new Droite(getPoint(2),getPoint(0));
		
		float demiPlanC = d1.appartient(getPoint(2));
		float demiPlanB = d3.appartient(getPoint(1));
		float demiPlanA = d2.appartient(getPoint(0)); 
		
		
		if(p.equals(getPoint(0))||p.equals(getPoint(1))||p.equals(getPoint(2)))
		{
			return 0; // sur un des sommets
		}
		else if(s1.appartient(p)||s2.appartient(p)||s3.appartient(p))
		{
			return 1; // sur un des segments
		}
		else if(demiPlanA == d2.appartient(p) && demiPlanB == d3.appartient(p) && demiPlanC == d1.appartient(p))
		{
			return 2; // dans le triangle
		}
		else
		{
			return -1; // en dehors du triangle
		}
	}


	public int intersect(Segment s)	// Retourne le nombre d'intersections entre un segment et un triangle
	{
		Segment ab = new Segment(getPoint(0), getPoint(1));
		Segment ac = new Segment(getPoint(0), getPoint(2));
		Segment bc = new Segment(getPoint(1), getPoint(2));

		int res = 0;

		if(ab.intersection(s) != null)
		{
			++res;
		}
		if(ac.intersection(s) != null)
		{
			++res;
		}
		if(bc.intersection(s) != null)
		{
			++res;
		}
		return res;
	}

}
