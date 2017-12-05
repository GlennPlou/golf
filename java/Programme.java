/**
 * Classe Programme Principal et Tests
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 2.0
 */
import java.util.ArrayList;
import java.io.*;

public class Programme{
  public static void main(String[] args){

    Terrain ter = new Terrain("DescriptionFIgureGolf2.txt");

    Affichage panneau = new Affichage();
    Fenetre fenetre = new Fenetre(panneau);

    ArrayList<Polygone> lis = ter.getList();
    ArrayList<Triangle> tri = new ArrayList<Triangle>();
    ArrayList<Segment> seg = new ArrayList<Segment>();

    panneau.rafraichir(lis, tri, seg);

  }
}
