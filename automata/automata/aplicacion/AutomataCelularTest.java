package aplicacion;


import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AutomataCelularTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AutomataCelularTest
{
    /**
     * Default constructor for test class AutomataCelularTest
     */
    public AutomataCelularTest()
    {
        AutomataCelular at = new AutomataCelular();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void deberiaHaberUnaCelula()
    {
        AutomataCelular at = new AutomataCelular();
        assertTrue("deberia haber celula",(at.getM()[1][1] instanceof Celula));
    }
    
    @Test
    public void deberiaHacerTicTac(){
        AutomataCelular at = new AutomataCelular();
        at.ticTac();
        assertTrue("deberia estar vivo",at.getElemento(1,1).isVivo()==true);
        at.ticTac();
        assertTrue("deberia estar vivo",(at.getElemento(1,1).isVivo()==true));
        at.ticTac();
        assertTrue("deberia estar muerto",at.getElemento(1,1).isVivo()==false);
    }
    @Test
    public void noDeberianMorirBarreras(){
        AutomataCelular at = new AutomataCelular();
        at.ticTac();
        assertTrue("deberia estar vivo",at.getElemento(19,19).isVivo()==true);
        at.ticTac();
        assertTrue("deberia estar vivo",(at.getElemento(19,19).isVivo()==true));
        at.ticTac();
        assertTrue("deberia estar vivo",at.getElemento(19,19).isVivo()==true);
    }
    
    @Test
    public void celulasIzquierdosas(){
        AutomataCelular at = new AutomataCelular();
        at.ticTac();
        assertTrue("deberia ser de color roja",at.getElemento(5,7).getColor() == Color.red);
        assertTrue("deberia estar muerta",at.getElemento(5,7).isVivo());
        at.ticTac();
        assertTrue("deberia ser de color roja",at.getElemento(5,7).getColor() == Color.red);
        assertFalse("deberia estar muerta",at.getElemento(5,7).isVivo());
    }
    
    @Test
    public void manzanas(){
     AutomataCelular at = new AutomataCelular();
     assertFalse("No deberia ser roja",at.getElemento(0,0).getColor() == Color.red);
     assertFalse("No deberia ser verde",at.getElemento(0,0).getColor() == Color.green);

    }
    
    @Test
    public void celulasOxigenada(){
        AutomataCelular at = new AutomataCelular();
        at.ticTac();
        assertTrue("deberia ser de color verde",at.getElemento(10,10).getColor() == Color.green);
        assertTrue("deberia estar muerta",at.getElemento(10,10).isVivo());
        at.ticTac();
        assertTrue("deberia ser de color roja",at.getElemento(10,10).getColor() == Color.yellow);
        assertTrue("deberia estar muerta",at.getElemento(10,10).isVivo());
        at.ticTac();
        at.ticTac();        
        assertTrue("deberia ser de color roja",at.getElemento(10,10).getColor() == Color.cyan);
        assertTrue("deberia estar muerta",at.getElemento(10,10).isVivo());
        at.ticTac();
        at.ticTac();
        assertFalse("deberia estar muerta",at.getElemento(10,10).isVivo());
        
    }
    
}