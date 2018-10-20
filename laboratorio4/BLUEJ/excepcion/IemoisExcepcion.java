package excepcion;


/**
 * Write a description of class IemoisExcepcion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IemoisExcepcion extends Exception
{
    public static final String  DISTRIBUIDOR= "El distribuidor falta";
    public static final String  REPETIDO= "El curso ya se ha agregado";
    /**
     * Constructor for objects of class IemoisExcepcion
     */
    public IemoisExcepcion(String message){
        super(message);
    }
}
