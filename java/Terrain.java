import java.io.*;
import java.util.*;

public class Terrain{

	private ArrayList<Polygone> polygones;


	Terrain(String s){
		polygones = new ArrayList<Polygone>();

		try{
			InputStream flux=new FileInputStream(s);
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			int nblignes, j;
			boolean b;																		// determine si on lit le x ou le y
			Polygone p;
			double x = 0;
			double y = 0;
			String tmp;
			nblignes = Integer.parseInt(buff.readLine());
			for(int i = 1; i <= nblignes; ++i){						// Les lignes ou sont définis les polygones
				ligne = buff.readLine();
				System.out.println(ligne);
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
						System.out.println("x : " + x + " y : " + y);
						p.ajoutPoint(new Point(x , y));
					} else {
						tmp = tmp + ligne.charAt(j);
					}
				}
				p.setCol(ligne.charAt(ligne.length()-1));
				polygones.add(p);
			}
			buff.close();
		}	catch (Exception e){
			System.out.println(e.toString());
		}
	}

	public ArrayList<Polygone> getList(){
		return polygones;
	}
}
