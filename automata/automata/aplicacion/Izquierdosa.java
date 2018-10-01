package aplicacion;
import java.awt.Color;
/**
 * Write a description of class Izquierdosa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Izquierdosa extends Celula
{

    /**
     * Constructor for objects of class Izquierdosa
     */
    public Izquierdosa(AutomataCelular ac,int fila, int columna)
    {
        setCelula(ac,fila,columna);
        this.color  = Color.red;
    }   
    
    public void decidaIzq(){
        decida();
        if(automata.getElemento(fila,++columna).isVivo()){
            estadoSiguiente = MUERTA;
        }
    }
}
