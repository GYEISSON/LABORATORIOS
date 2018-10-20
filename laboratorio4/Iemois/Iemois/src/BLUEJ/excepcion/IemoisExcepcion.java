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

    /**
     * Constructor for objects of class IemoisExcepcion
     */
    public IemoisExcepcion(String message){
        super(message);
    }
}
