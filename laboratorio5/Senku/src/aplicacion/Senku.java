import java.util.*;


public class Senku {
	//height width 1 es el vertical
	private static int height1,height2,width1,width2;
	private  static int hMatriz,wMatriz;
	private static Ficha[][] matriz;
	
	public Senku() {
		height1 =height2 = 7;
		width1 = width2 = 3;
		
		hMatriz = Math.max(height1,width1);
		wMatriz = Math.max(height2,width2);
		matriz= new Ficha[hMatriz][wMatriz];
	}

}
