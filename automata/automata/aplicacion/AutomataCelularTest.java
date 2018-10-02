package aplicacion;



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
}