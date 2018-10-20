package pruebas;


import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;


public class IemoisTest{

    public IemoisTest(){
    }


    @Before
    public void setUp(){
    }

    @After
    public void tearDown(){
    }
    @Test
    public void deberiaAdicionar(){
        
        Iemois s= new Iemois();
        int size= s.numerocursos();
        s.adicione("Machine Learning","Inteligencia Artificial","Coursera","8","Este curso proporciona una amplia introduccion");
        assertTrue(size+1== s.numerocursos());
    }
    @Test
    public void deberiaListar(){
        Iemois s= new Iemois();
        String consulta1=s.toString();
        s.adicione("Machine Learning","Inteligencia Artificial","Coursera","8","Este curso proporciona una amplia introduccion");
        String consulta2=s.toString();
        assertFalse(consulta1==consulta2);
    }
}