import java.io.*;
import java.util.*;

public class Programme
{
	public static void main(String args[])
	{
		Carre c1 = new Carre(new Point(0,0), new Point(10,0), new Point(10,10), new Point(10,0));
		System.out.println("bjr");
		/*Carre c2 = new Carre(new Point(-1,-4), new Point(2,-2), new Point(4,-5), new Point(1,-7));

		Droite d1 = new Droite(new Point(1,-2), new Point(3,-5));
		Droite d2 = new Droite(new Point(0,-7), new Point(-2,-4));
		System.out.println(d1);
		System.out.println(d2);*/

		Droite d1 = new Droite(new Point(1,-2), new Point(3,-5));
		System.out.println(d1);

	}
}