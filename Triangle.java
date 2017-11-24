public class Triangle {
	private Point a, b, c;
	
	public Triangle(Point p1, Point p2, Point p3)
	{
		a=p1;
		b=p2;
		c=p3;
	}
	
	public int positionDuPoint(Point p)
	{		
		Segment s1,s2,s3;
		s1 = new Segment(a,b);
		s2 = new Segment(b,c);
		s3 = new Segment(c,a);
		
		Droite d1,d2,d3;
		d1 = new Droite(a,b);
		d2 = new Droite(b,c);
		d3 = new Droite(c,a);
		
		float demiPlanC = d1.appartient(c);
		float demiPlanB = d3.appartient(b);
		float demiPlanA = d2.appartient(a); 
		
		
		if(p.equals(a)||p.equals(b)||p.equals(c))
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
}
