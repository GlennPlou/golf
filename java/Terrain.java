import java.io.*;

public class Terrain{

	private ArrayList<Polygone> polygones;


	Terrain(String s){
		try{
			InputStream flux=new FileInputStream(s);
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			int nblignes, j;
			boolean b;																		// determine si on lit le x ou le y
			Polygone p;
			double x, y;
			nblignes = (int)buff.readLine();
			for(int i = 1; i <= nblignes; ++i){						// Les lignes ou sont définis les polygones
				ligne = buff.readLine();
				System.out.println(ligne);
				b = true;
				for(j = 0; j < ligne.length()-2; ++j){ 				// On parcours la ligne
					if (b == true && )
				}

				}
			}
			buff.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}

}
