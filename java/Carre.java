import static java.lang.*;

public class Carre extends Polygone
{
	
	public Carre(Point a, Point b, Point c, Point d)
	{
		super();

		ajoutPoint(a);
		ajoutPoint(b);
		ajoutPoint(c);
		ajoutPoint(d);		
	}

	public Carre(ArrayList<Point> quadrilatere)
	{
		if(quadrilatere.size() == 4)
		{

		}
	}

	public int interTri(Triangle T)
	{
		Segment ab = new Segment(this.a, this.b);
		Segment bc = new Segment(this.b, this.c);
		Segment cd = new Segment(this.c, this.d);
		Segment da = new Segment(this.d, this.a);

		int res = 0;

		res += t.intersect(ab);
		res += t.intersect(bc);
		res += t.intersect(cd);
		res += t.intersect(da);

		return res;
	}
}