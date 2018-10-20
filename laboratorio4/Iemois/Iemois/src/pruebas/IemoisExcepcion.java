package src.pruebas;


import src.aplicacion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;


public class IemoisExcepcion{

    public IemoisExcepcion(){
    
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
}