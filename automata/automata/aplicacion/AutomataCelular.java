package aplicacion;

import java.util.*;
import java.*;


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
       
              
       Izquierdosa otra = new Izquierdosa(this,5,5);
       automata[5][5]=otra;
       Izquierdosa celula = new Izquierdosa(this,5,6);
       automata[5][6]=celula;
       
       Celula x = new Celula(this,1,1);
       automata[1][1]=x;
       
       
       Celula y = new Celula(this,2,2);
       automata[2][2]=y;
       

       
       //barreras
       Barrera noreste = new Barrera(this,19,19);
       automata[19][19]=noreste;
       Barrera sureste = new Barrera(this,0,19);
       automata[19][19]=sureste;

       //celulas izquierdosas

       
   }
    
   public void ticTac(){
       for (int f=0;f<19;f++){
           for (int c=0;c<19;c++){
               
               if (automata[f][c]!= null){
                   System.out.println(f);System.out.println(c);
                   System.out.println(automata[f][c].getClass().getName());
                   
                   if(c<18 && automata[f][c+1] != null){
                       
                       if(automata[f][c+1].isVivo() ){
                           System.out.println(f+" "+c);
                           System.out.println(c);
                           System.out.println(f);
                           automata[f][c].decida();
                           automata[f][c].decida();  
                       
                                              automata[f][c].decida();
                   automata[f][c].cambie();
                                      automata[f][c].decida();
                   automata[f][c].cambie();
                       }
                   }
               
                   automata[f][c].decida();
                   automata[f][c].cambie();
                   
               }            
               else continue;
           }
       }
   }
   
}
