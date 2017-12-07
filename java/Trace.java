/**
 * @brief Classe gérrant le tracés
 *
 * Les tracés sont des liste de polygones représentant les fairways et greens du tracé
 *
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 1.0
 */

import java.util.ArrayList;

public class Trace{
  private int id;

  private ArrayList<Polygone> fairgreen;

  private Point depart;
  private Point trou;

  private int par;


  /* -------------------------------- Constructeur ----------------------------------- */

  /**
   *  Constructeur de tracé
   *  @param id identifiant du tracé
   *  @param ls liste de polygones
   *  @param dep point de départ de la balle
   *  @param arr point d'arrivé (trou)
   *  @param par explicite
   *
   */
   public Trace(int id, ArrayList<Polygone> ls, Point dep, Point arr, int par){
     id = id;
     fairgreen = ls;
     depart = dep;
     trou = arr;
     par = par;
   }



   /* ---------------------------------- Accésseurs ---------------------------------- */

   /**
   * Accesseur de la liste de polygones du Tracé
   * @return polygone la liste de polygones
   */
   public ArrayList<Polygone> getList(){
     return fairgreen;
   }
}
