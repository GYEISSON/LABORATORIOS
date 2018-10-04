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
       // barreras
       Barrera noreste = new Barrera(this,19,19);
       Barrera sureste = new Barrera(this,0,19);
       //celulas
       Celula cerocerosiete = new Celula(this,1,1);
       Celula indiana = new Celula(this,2,2);
       
       //celulas izquierdosas
       Izquierdosa marx = new Izquierdosa(this,3,5);
       Izquierdosa hegel = new Izquierdosa(this,3,6);
       Izquierdosa otra1 = new Izquierdosa(this,5,7);
       Izquierdosa celula1 = new Izquierdosa(this,5,8);
       
       Oxigenada gualdron = new Oxigenada(this,10,10);
       Oxigenada rubiano = new Oxigenada(this,10,11);
       
       Manzana m1 = new Manzana(this,0,0);
       Manzana m2 = new Manzana(this,9,10);
       
       Conway uno= new Conway(this,13,13);
       Conway dos= new Conway(this,14,13);
       Conway tres= new Conway(this,15,13);
       Conway cuatro= new Conway(this,1,2);
       Conway cinco= new Conway(this,2,1);
   }    
   public void ticTac(){
       for (int f=0;f<19;f++){
           for (int c=0;c<19;c++){               
               if (automata[f][c]!= null){
                   automata[f][c].decida();
                   
               }            
               else{
                   if(nVecinos(f,c)==3){
                       automata[f][c] = new Conway(this,f,c);
                   }
               }
           }
       }
       for (int f=0;f<19;f++){
           for (int c=0;c<19;c++){               
               if (automata[f][c]!= null){

                   automata[f][c].cambie();
                   
               }            
               
               
           }
       }
   }
   
   
   public int nVecinos(int fila,int columna){
       int[] x = {0, -1, -1, -1, 0, 1, 1, 1};
       int[] y = {-1,-1,  0,  1, 1, 1, 0, -1};
       int contV = 0;
       for(int i =0;i<8;i++){
            if( fila+x[i] >=0 && fila+x[i] <19  && columna+y[i]>=0 && columna+y[i]<19){
                if(automata[fila+x[i]][columna+y[i]]  != null) contV++;
            }
       }
       return contV;
    }
}
