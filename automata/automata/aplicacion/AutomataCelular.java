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
   public Elemento[][] getM(){
    return automata;
    }
    
   public Elemento getElemento(int f,int c){
        return automata[f][c];
   }
    
   public void setElemento(int f, int c, Elemento nueva){
       automata[f][c]=nueva;
   }
   
   public void algunosElementos(){
       //barreras
       Barrera noreste = new Barrera(this,19,19);
       Barrera sureste = new Barrera(this,0,19);
       //celulas
       Celula cerocerosiete = new Celula(this,1,1);
       Celula indiana = new Celula(this,2,2);
       
       //celulas izquierdosas
       Izquierdosa otra = new Izquierdosa(this,5,5);
       Izquierdosa celula = new Izquierdosa(this,5,6);
       Izquierdosa otra1 = new Izquierdosa(this,5,7);
       Izquierdosa celula1 = new Izquierdosa(this,5,8);
       
       Oxigenada ox1 = new Oxigenada(this,10,10);
       Oxigenada ox2 = new Oxigenada(this,10,11);
       
       
       Manzana m = new Manzana(this,0,0);
       
   }    
   public void ticTac(){
       for (int f=0;f<19;f++){
           for (int c=0;c<19;c++){               
               if (automata[f][c]!= null){                                      
                   automata[f][c].decida();
                   automata[f][c].cambie();
               }            
              
           }
       }
   }
   
}
