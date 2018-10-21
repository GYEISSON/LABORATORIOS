package excepcion;


/**
 * Write a description of class IemoisExcepcion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IemoisExcepcion extends Exception
{
    public static final String  DISTRIBUIDOR= "El distribuidor falta!";
    public static final String  REPETIDO= "El curso ya se ha agregado!";
    public static final String MAYOSTRI="La primera letra debe ser mayuscula o empezar por String!";
    public static final String VACIO = "No puede ser un campo vacio!";
    /**
     * Constructor for objects of class IemoisExcepcion
     */
    public IemoisExcepcion(String message){
        super(message);
    }
}
