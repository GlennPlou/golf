/**
 * @brief Classe gérrant le terrain de golf
 *
 * Le terrain de golf est une liste de polygones
 * ces polygones pouvent etre triangulé en listes de triangles
 *
 * @author Glenn Plouhinec & Benoît Le Badezet
 * @version 1.0
 */

import java.io.*;
import java.util.*;

public class Terrain{

	private ArrayList<Polygone> polygones;

	private ArrayList<Trace> traces;

	/* ----------------------------- Constructeur -------------------------------- */

	/**
	* Construit un terrain a partir d'un fichier dont le nom est passé en paramètre
	* Analyseur synaxique
	*/
	Terrain(String s){
		polygones = new ArrayList<Polygone>();
		traces = new ArrayList<Trace>();

		try{
			InputStream flux=new FileInputStream(s);
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			int nblignes, j, numpoly, par;
			boolean b;																		// determine si on lit le x ou le y
			Polygone p;
			double x = 0;
			double y = 0;
			String tmp;
			ArrayList<Polygone> polys;
			Point dep, arr;

			/* Création de l'air de jeu */
			nblignes = Integer.parseInt(buff.readLine());				// On récupère le nombre de lignes ou sont définis les polygones
			for(int i = 1; i <= nblignes; ++i){						// Les lignes ou sont définis les polygones
				ligne = buff.readLine();
				//System.out.println(ligne);
				b = false;
				tmp = "";
				p = new Polygone();
				for(j = 0; j <= ligne.length()-2; ++j){ 				// On parcours les lignes
					if (b == false && ligne.charAt(j) == '('){
						b = true;
						tmp = "";
					} else if(b == true && ligne.charAt(j) == ','){
						x = Double.parseDouble(tmp);
						b = false;
						tmp = "";
					} else if(b == false && ligne.charAt(j) == ')'){
						y = Double.parseDouble(tmp);
						p.ajoutPoint(new Point(x , y));
					} else {
						tmp = tmp + ligne.charAt(j);
					}
				}
				p.setCol(ligne.charAt(ligne.length()-1));
				polygones.add(p);
			}

			/* Création des tracés */
			nblignes = Integer.parseInt(buff.readLine());			// On récupère le nombre de lignes ou sont définis les tracés
			for(int i = 1; i <= nblignes; ++i){
				ligne = buff.readLine();
				polys = new ArrayList<Polygone>();
				j = 0;
				tmp = "";
				while(ligne.charAt(j) != '('){									// On parcours les polygones du tracé n°i
					if(ligne.charAt(j) == ','){
						numpoly = Integer.parseInt(tmp);
						polys.add(polygones.get(numpoly - 2));
						tmp = "";
					} else {
						tmp = tmp + ligne.charAt(j);
					}
					++j;
				}

				++j;
				tmp = "";
				while(ligne.charAt(j) != ')'){									// On parcours les coordonnées du point de départ
					if(ligne.charAt(j) == ','){
						x = Double.parseDouble(tmp);
						tmp = "";
					} else {
						tmp = tmp + ligne.charAt(j);
					}
					++j;
				}
				y = Double.parseDouble(tmp);
				dep = new Point(x, y);

				j = j+3;
				tmp = "";
				while(ligne.charAt(j) != ')'){									// On parcours les coordonnées du point d'arrivée
					if(ligne.charAt(j) == ','){
						x = Double.parseDouble(tmp);
						tmp = "";
					} else {
						tmp = tmp + ligne.charAt(j);
					}
					++j;
				}
				y = Double.parseDouble(tmp);
				arr = new Point(x, y);

				par = Character.getNumericValue(ligne.charAt(ligne.length()-1));

				traces.add(new Trace(i, polys, dep, arr, par));
			}


			buff.close();
		}	catch (Exception e){
			System.out.println(e.toString());
		}
	}

	/* ---------------------------------- Accésseurs ---------------------------------- */

	/**
	* Accesseur de la liste de polygones du Terrain
	* @return polygone la liste de polygones
	*/
	public ArrayList<Polygone> getList(){
		return polygones;
	}

	/**
	* Accesseur du ième tracé du terrain
	* @return le ième tracé
	*/
	public Trace getTrac(int i){
		return traces.get(i);
	}


	/* ------------------------------------ Méthode ------------------------------------- */


	/**
	* Triangulise tous les polygones du terrain
	* @return res la liste de tous les triangles formant le terrain
	*/
	public ArrayList<Triangle> listTri(){
		ArrayList<Triangle> res = new ArrayList<Triangle>();
		for(Polygone p : polygones){
			res.addAll(p.triangule());
		}
		return res;
	}
}
