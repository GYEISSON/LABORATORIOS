package aplicacion;

import java.util.*;

public class Senku {
	//height width 1 es el vertical
	private int height1,height2,width1,width2;
	private int hMatriz,wMatriz,mid1,mid2;
	private int[][] matriz;
	
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
				matriz[i][j]=2;
			}
		}
		for(int i=0; i<wMatriz;i++) {
			for(int j=mid2;j<(mid2+width2);j++ ) {
				matriz[i][j]=2;
			}
		}
		matriz[hMatriz/2][wMatriz/2] = 1;
	}

	public void moveTo(int[] s,int[] t){
		if(matriz[t[0]][t[1]] ==1 && matriz[s[0]][s[1]] ==2
			&& ((s[0] == t[0] && (Math.abs(s[1]-t[1])==2)) 
			|| (s[1] == t[1]  && (Math.abs(s[0]-t[0])==2)))) {
			if(s[0] == t[0]) {
				if((s[1]>t[1] && matriz[s[0]][s[1]-1]==2) || (s[1]<t[1] &&  matriz[s[0]][t[1]-1]==2)) {
					matriz[s[0]][s[1]]=1;
					matriz[t[0]][t[1]]=2;
					if(s[1]>t[1]) matriz[s[0]][s[1]-1]=1;
					else matriz[s[0]][t[1]-1]=1;
				}
			}else {
				if((s[0]>t[0] && matriz[s[0]-1][s[1]]==2) || (s[0]<t[0] &&  matriz[t[0]-1][t[1]]==2)) {
					matriz[s[0]][s[1]]=1;
					matriz[t[0]][t[1]]=2;
					if(s[0]>t[0]) matriz[s[0]-1][s[1]]=1;
					else matriz[t[0]-1][t[1]]=1;	
				}
			}
		}
	}
}
