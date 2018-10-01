package aplicacion;

import java.util.*;


public class AutomataCelular{

   static private int LONGITUD=20;
   private Elemento[][] automata;

        
   public AutomataCelular() {
        automata=new Elemento[LONGITUD][LONGITUD];
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                automata[f][c]=null;
            }
        }
        algunosElementos();
   }
    
   public int  getLongitud(){
    return LONGITUD;
   }
    
   public Elemento getElemento(int f,int c){
        return automata[f][c];
   }
    
   public void setElemento(int f, int c, Elemento nueva){
    automata[f][c]=nueva;
   }
   
   public void algunosElementos(){
       //celulas
       Celula x = new Celula(this,0,0);
       automata[0][0]=x;
       Celula y = new Celula(this,1,1);
       automata[1][1]=y;
       //barreras
       Barrera noreste = new Barrera(this,19,19);
       automata[19][19]=noreste;
       Barrera sureste = new Barrera(this,0,19);
       automata[19][19]=sureste;
       //celulas izquierdosas
       
       Celula otra = new Izquierdosa(this,5,5);
       automata[0][0]=otra;
       Celula celula = new Izquierdosa(this,5,6);
       automata[1][1]=celula;
       
   }
    
   public void ticTac(){
       for (int f=0;f<20;f++){
           for (int c=0;c<20;c++){
               if (automata[f][c]!= null){
                   automata[f][c].decida();
                   automata[f][c].cambie();
               }            
               else continue;
           }
       }
   }
   
   public int vecinasVivas(int xPos, int yPos){
       int numeroVecinosVivos = 0;
       int[] row = {0,-1,-1,-1,0,1,1,  1};
       int[] col = {-1,-1,0, 1, 1, 1, 0,-1};
       for(int i =0 ; i< 8;i++){
          if(automata[row[i]][col[i]].isVivo()) numeroVecinosVivos++;
       }
       return numeroVecinosVivos;
   }
   
}
