import java.util.*;
import java.lang.*;

public class Carre extends Polygone
{
	
	public Carre(Point a, Point b, Point c, Point d)
	{
		super();

		Segment s1 = new Segment(a, b);
		Segment s2 = new Segment(b, c);

		Droite d1 = new Droite(a, b);
		Droite d2 = new Droite(b, c);
		Droite d3 = new Droite(c, d);
		Droite d4 = new Droite(a, d);

		System.out.println(d2.intersection(d4) == null);
		System.out.println(d2.intersection(d4));
		System.out.println(d2);
		System.out.println(d4);

		if(d1.intersection(d3) == null && d2.intersection(d4) == null)
		{
			if(calculAngle(s1,s2) == 90.0)
			{
				ajoutPoint(a);
				ajoutPoint(b);
				ajoutPoint(c);
				ajoutPoint(d);
			}
			else
			{
				System.out.println("Ce n'est pas un carré. (Pas d'angle droit)");
			}
		}
		else
		{
			System.out.println("Ce n'est pas un carré.");
		}
				
	}

	public Carre(ArrayList<Point> quadri)
	{
		super();
		if(quadri.size() == 4)
		{
			Segment s1 = new Segment(quadri.get(0), quadri.get(1));
			Segment s2 = new Segment(quadri.get(1), quadri.get(2));
			Segment s3 = new Segment(quadri.get(3), quadri.get(2));

			if(calculAngle(s1,s2) == 90.0 && calculAngle(s1,s3) == 0.0
				|| calculAngle(s1,s3) == 90.0 && calculAngle(s1,s2) == 0.0) //dépend de l'ordre des points ?
			{
				ajoutPoint(quadri.get(0));
				ajoutPoint(quadri.get(1));
				ajoutPoint(quadri.get(2));
				ajoutPoint(quadri.get(3));
			}
			else
			{
				System.out.println("Ce n'est pas un carré.");
			}
		}
		else
		{
			System.out.println("Ce n'est pas un carré.");
		}
	}

	/*public int interTri(Triangle T)
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
	}*/

	private double calculAngle(Segment s1, Segment s2)
	{
		double u1, u2, v1, v2;

		u1 = s1.getP2().getX() - s1.getP1().getX();
		u2 = s1.getP2().getY() - s1.getP1().getY();

		v1 = s2.getP2().getX() - s2.getP1().getX();
		v2 = s2.getP2().getY() - s2.getP1().getY();


		double cosTheta = (u1*v1 + u2*v2)/(Math.sqrt(u1*u1 + u2*u2) * Math.sqrt(v1*v1 + v2*v2));

		return Math.toDegrees(Math.acos(cosTheta));
	}
}