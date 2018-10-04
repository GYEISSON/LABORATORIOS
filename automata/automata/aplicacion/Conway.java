package aplicacion;
import java.awt.Color;

/**
 * Write a description of class Conway here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Conway extends Celula 
{


    /**
     * Constructor for objects of class Conway
     */
    public Conway(AutomataCelular ac,int fila, int columna)
    { 
        super(ac,fila,columna);
        this.color = Color.gray;
    }

    public void decida(){
        //System.out.println(fila+" "+columna+" nVecinos "+nVecinos());
        //System.out.println((automata.getElemento(fila,columna).isVivo()));
        //esta muerta
        if(!(automata.getElemento(fila,columna).isVivo()) &&  nVecinos() ==3){
            //System.out.println("ok1");
            estadoSiguiente = VIVA;
        }
        //esta viva
        else if(automata.getElemento(fila,columna).isVivo() 
        && nVecinos() ==2 || nVecinos() ==3 ){
            estadoSiguiente = VIVA;
            //System.out.println("ok2");
        }
        //viva
        else if( (automata.getElemento(fila,columna).isVivo() ||
        !(automata.getElemento(fila,columna).isVivo())) &&
        ( nVecinos() ==1 || nVecinos() > 3  )){
            estadoSiguiente = MUERTA;
            //System.out.println("ok3");
        }           
    }
    
    public int nVecinos(){
       int[] x = {0, -1, -1, -1, 0, 1, 1, 1};
       int[] y = {-1,-1,  0,  1, 1, 1, 0, -1};
       int contV = 0;
       for(int i =0;i<8;i++){
            if( fila+x[i] >=0 && fila+x[i] <19  && columna+y[i]>=0 && columna+y[i]<19){
                if(automata.getElemento( fila+x[i] ,columna+y[i] ) != null ){
                    if(automata.getElemento( fila+x[i] ,columna+y[i] ).isVivo()){
                        contV +=1;
                    }
                }                
            }
       }
       return contV;
    }
}
