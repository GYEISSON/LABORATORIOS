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
       
       Celula x = new Celula(this,0,0);
       automata[0][0]=x;
       Celula y = new Celula(this,1,1);
       automata[1][1]=y;
       Barrera b = new Barrera(this,15,15);
       automata[15][15]=b;
       
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
}
