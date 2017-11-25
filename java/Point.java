public class Point
{
	private double x;
	private double y;

	public Point()
	{
		x = 0;
		y = 0;
	}

	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/*public void deplacer(double x, double y)
	{
		this.x += x;
		this.y += y;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public void setY(double y)
	{
		this.y = y;
	}*/

	public double getX()
	{
		return this.x;
	}

	public double getY()
	{
		return this.y;
	}

	public boolean equals(Object o)
	{
		if(o instanceof Point)
		{
			Point pt = (Point)o;

			return x == pt.x && y == pt.y;
		}
		else
		{
			return false;
		}
	}

	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
	
}