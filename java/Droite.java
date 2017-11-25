public class Droite
{
	private double a, b, c;
	

	public Droite(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}


	public Droite(Point p1, Point p2) //En utilisant l'equation reduite y = ax + c, on obtient l'equation cartesienne
	{								  // ax + by + c = 0, b vaut -1, a est le coefficient directeur
		/*a = ( p2.getY() - p1.getY() )/( p2.getX() - p1.getX() );
		b = -1;
		c = -(a*p1.getX()) + p1.getY();// ou -(a*p2.getX()) + p2.getY(), ca revient au meme*/
	}


	public int appartient(Point p)// le point est sur la droite alors = 0
	{								// au dessus de la droite ==> <0, et en dessous ==> >0
		if(a*p.getX() + (b*p.getY()) + c < 0) {
			return -1; //demi-plan au dessus
		}
		else if(a*p.getX() + (b*p.getY()) + c > 0) {
			return 1; // demi-plan en dessous
		}
		else
		{
			return 0; // sur la droite
		}
	}


	public Point intersection(Droite d){
		if(-(this.b)*d.a - (-d.b*this.a) == 0){	//les droites sont paralleles ou confondues (vecteurs directeurs colineaires) = (-b * a')-(-b' * a)
			return null;
		}else{
			double x = (-d.c + d.b*(this.c/this.b)) / (d.a - d.b*(this.a/this.b)); //Resolution du systeme d'equations, pour n'importe quel b (pas forcement -1)
			double y = ( -(this.a)*x - (this.c)) / this.b;

			return new Point(x,y);
		}
	}


	public boolean equals(Object o)
	{
		if(o instanceof Droite)
		{
			Droite drt = (Droite)o;

			return a == drt.a && b == drt.b && c == drt.c;
		}
		else
		{
			return false;
		}
	}


	public String toString()
	{
		return a + "x + " + b + "y + " + c + " = 0";
	}
}


























//public class Droite{
//	private double a, b, c;
//
//	public Droite(Point p1, Point p2){
//		a = p2.getY() - p1.getY();
//		b = p2.getX() - p1.getX();
//		c = -(this.a * p2.getX() + this.b * p2.getY());
//	}
//
//	public double getA(){
//		return this.a;
//	}
//
//	public double getB(){
//		return this.b;
//	}
//
//	public double getC(){
//		return this.c;
//	}
//
//	public double appartient(Point p){
//		return (a*p.getX()) + (b*p.getY()) + c;  // si resultat positif alors demi plan sous la droite sinon demi plan au dessus de la droite
//	}
//
//	public Point intersection(Droite d){
//		Point p;
//		if(this.a == d.getA() && this.b == d.getB()){		// Si les droite sont parallèles ou confondues
//			return null;
//		} else {
//			double a_t, c_t, a_d, c_d;
//			a_t = this.a/(-this.b);
//			c_t = this.c/(-this.b);
//			a_d = d.getA()/(-d.getB());
//			c_d = d.getC()/(-d.getC());
//			if(a_t == 0){
//				p = new Point((c_t - c_d)/a_t, c_t);
//			} else if(a_d == 0){
//				p = new Point((c_d - c_d)/a_d, c_d);
//			} else {
//				p = new Point( (c_d - c_t)/(a_t - a_d) );
//			}
//		}
//		return p;
//	}
//
//}
