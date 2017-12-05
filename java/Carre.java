/**
 * Classe Carré
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 1.0
 */

import java.util.*;
import java.lang.*;

public class Carre extends Polygone
{

	/* ------------------------ Constructeurs ---------------------------- */

	/**
  	* Construit un Carré
  	* @param a le premier point du Carré
  	* @param b le second point du Carré
  	* @param c le troisième point du Carré
  	* @param d le dernier point du Carré
  	*/
	public Carre(Point a, Point b, Point c, Point d)
	{
		super();

		if(estCarre(a,b,c,d))
		{
			ajoutPoint(a);
			ajoutPoint(b);
			ajoutPoint(c);
			ajoutPoint(d);
		} else System.out.println("Ces 4 point ne forment pas un carré ");
	}

	/**
  	* Construit un carré avec un ArrayList de 4 points existants
  	* @param quadri une liste de quatre Points
  	*/
	public Carre(ArrayList<Point> quadri)
	{
		super();

		if(quadri.size() == 4)
		{
			if(estCarre(quadri.get(0), quadri.get(1), quadri.get(2), quadri.get(3)))
			{
				ajoutPoint(quadri.get(0));
				ajoutPoint(quadri.get(1));
				ajoutPoint(quadri.get(2));
				ajoutPoint(quadri.get(3));
			} else System.out.println("Ces 4 point ne forment pas un carré ");
		}
		else System.out.println("Ce n'est pas un carré. (Il n'y a pas 4 sommets)");
	}


	/**
	* Construit un carré droit a partir d'un point et de la longueur des côtés
	* @param p le point le plus proche de l'origine
	*/
	public Carre(Point p, double n){
		super();
		ajoutPoint(p);
		ajoutPoint(new Point(p.getX() + n, p.getY()));
		ajoutPoint(new Point(p.getX() + n, p.getY() + n));
		ajoutPoint(new Point(p.getX(), p.getY() + n));
	}

	/* ----------------------- Méthodes ----------------------- */

	/**
  	* Determine si 4 points forment un carré
  	* @param a un point d'un quadrilatère
	* @param b un point d'un quadrilatère
	* @param c un point d'un quadrilatère
	* @param d un point d'un quadrilatère
	* @return true si les 4 point a, b, c, d forment un carré
	* @return false si ces 4 point ne forment pas un carré
  	*/
	private boolean estCarre(Point a, Point b, Point c, Point d){
		/* deux côtés adjacents */
		Segment ab = new Segment(a, b);
		Segment bc = new Segment(b, c);
		/* les diagonales */
		Segment ac = new Segment(a, c);
		Segment bd = new Segment(b, d);

		return (ab.longueur() == bc.longueur() && ac.longueur() == bd.longueur());
	}



	/**
	* Determine le nombre d'intersections entre un carré et un triangle
	* @param t un Triangle
	* @return true si on a deux ou plus Intersections
	* @return false si on a moins de deux Intersections
	*/
	public boolean interTri(Triangle t){
		Segment ab = new Segment(getPoint(0), getPoint(1));
		Segment bc = new Segment(getPoint(1), getPoint(2));
		Segment cd = new Segment(getPoint(2), getPoint(3));
		Segment da = new Segment(getPoint(3), getPoint(0));

		int res = 0;
		res += t.interSeg(ab);
		res += t.interSeg(bc);
		res += t.interSeg(cd);
		res += t.interSeg(da);
		return (res >= 2);
	}

}
