public class Programme{
  public static void main(String[] args){
    Point p = new Point(1, 2);
    Point q = new Point(-5, 1);
    Point qprime = new Point(10,1);
    
    Droite d = new Droite(q, p);

    System.out.println("--------------- Test de droite d'equation 0.5x + (-1)y + 1.5   ----------------------------");
    System.out.println(" a = " + d.getA());
    System.out.println(" b = " + d.getB());
    System.out.println(" c = " + d.getC());

    Point r = new Point(3, 5);
    Point s = new Point(7, 3);
    Droite d2 = new Droite(r, s);

    System.out.println("--------------- Test de droite d'equation 0.5x + (-1)y + 1.5   ----------------------------");
    System.out.println(" a = " + d2.getA());
    System.out.println(" b = " + d2.getB());
    System.out.println(" c = " + d2.getC());

    System.out.println(" r : (3,5) appartient t'il a la droite d ? :" + d.appartient(r));
    System.out.println("intersection de mon zbi en : (" + d.intersection(d2).getX() + ", " + d.intersection(d2).getY() + ")");

    Segment s1 = new Segment(p, qprime);
    Segment s2 = new Segment(r, s);
    //System.out.println("intersection de mon zboub en : (" + s1.intersection(s2).getX() + ", " + s1.intersection(s2).getY() + ")");
  
    Segment poney = new Segment(q,qprime);
    Segment licorne = new Segment(r,s);
    
    //System.out.println("intersection de segments en : (" + poney.intersection(licorne).getX() + ", " + poney.intersection(licorne).getY() + ")");
    Point OH = new Point(-5,1);
    System.out.println(poney.appartient(OH));
  
  }
}
