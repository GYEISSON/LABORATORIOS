    package pruebas;
    
    import excepcion.*;
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
    public void deberiaAdicionar() throws IemoisExcepcion{
        
        Iemois s= new Iemois();
        int size= s.numerocursos();
        s.adicione("Machine Learning","Inteligencia Artificial","Coursera","8","Este curso proporciona una amplia introduccion");
        assertTrue(size+1== s.numerocursos());
    }
    @Test
    public void deberiaListar() throws IemoisExcepcion{
        Iemois s= new Iemois();
        String consulta1=s.toString();
        s.adicione("Machine Learning","Inteligencia Artificial","Coursera","8","Este curso proporciona una amplia introduccion");
        String consulta2=s.toString();
        assertFalse(consulta1==consulta2);
    }
    @Test
    public void deberiaFallarSinDistribuidor(){
        Iemois s= new Iemois();
        try {
            s.adicione("Machine Learning","Inteligencia Artificial","","8","Este curso proporciona una amplia introduccion");
            fail("No lanzo excepcion");
        }
        catch(IemoisExcepcion e) {
            assertEquals(e.getMessage(), IemoisExcepcion.DISTRIBUIDOR);
        }
    }
        @Test
        public void deberiaFallarConAreaRepetida(){
        	Iemois s= new Iemois();
        	try {
    		s.adicione("Machine Learning","Inteligencia Artificial","Coursera","8","Este curso proporciona una amplia introduccion");
                s.adicione("Machine Learning","Inteligencia Artificial","Coursera","8","Este curso proporciona una amplia introduccion");
        	fail("No lanzo excepcion");
    	}
    	catch(IemoisExcepcion e) {
    		assertEquals(e.getMessage(), IemoisExcepcion.REPETIDO);
    	}
    }
}