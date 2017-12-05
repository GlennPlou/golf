import java.io.*;

public class Terrain{

	private ArrayList<Polygone> polygones;


	Terrain(String s){
		try{
			InputStream flux=new FileInputStream(s);
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			int nblignes;
			nblignes = (int)buff.readLine();
			while ((ligne=buff.readLine())!=null){
				System.out.println(ligne);
			}
			buff.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}

}
