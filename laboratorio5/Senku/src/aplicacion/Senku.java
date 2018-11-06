import java.util.*;


public class Senku {
	//height width 1 es el vertical
	private static int height1,height2,width1,width2;
	private  static int hMatriz,wMatriz,mid1,mid2;
	private static int[][] matriz;
	
	public Senku() {
		height1 =height2 = 7;
		width1 = width2 = 3;
		hMatriz = Math.max(height1,width1);
		wMatriz = Math.max(height2,width2);
		matriz= new int[hMatriz][wMatriz];
		mid1 = (wMatriz-width1)/2;
		mid2= (hMatriz-width2)/2;
		
		for(int i=mid1; i<(mid1+width1);i++) {
			for(int j=0;j<hMatriz;j++ ) {
				System.out.println(i+" "+j);
				matriz[i][j]=1;
			}
		}
		for(int i=0; i<wMatriz;i++) {
			for(int j=mid2;j<(mid2+width2);j++ ) {
				System.out.println(i+" "+j);
				matriz[i][j]=1;
			}
		}
	}
}
