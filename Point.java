public class Point{
	private float x;
	private float y;

	public Point(float x, float y){
		this.x = x;
		this.y = y;
	}

	public void deplacer(float x, float y){
		this.x += x;
		this.y += y;
	}

	public void setX(float x){
		this.x = x;
	}

	public void setY(float y){
		this.y = y;
	}

	public float getX(){
		return this.x;
	}

	public float getY(){
		return this.y;
	}
	
	public float coeffDirecteur(Point a){
		return (this.y - a.y)/(this.x-a.x);
	}
	
	public boolean equals(Point a){
		return this.x == a.x && this.y == a.y;
	}

	
}