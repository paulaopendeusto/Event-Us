package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import data.Event;
import data.Spaces;
import gestor.gestorEspacios;
import gestor.gestorEventos;

//import org.databene.contiperf.*;


public class AppTest {
	
	
	static Logger logger = Logger.getLogger(AppTest.class.getName());

//	@Rule
//	public ContiPerfRule rule = new ContiPerfRule();
	
	gestorEspacios objGestorEspacios = new gestorEspacios();
	gestorEventos objGestorEventos= new gestorEventos();
	
	@Before
	    public void setUp() {
		
		Spaces s1 = new Spaces("primero","bilbao",100000,"recursoA");
    	Spaces s2= new Spaces("segundo","donosti",50000,"recursoB");
    			
    	objGestorEspacios.crearEspacio(s1);
    	objGestorEspacios.crearEspacio(s2);
    	
    	
    	Date date = null;
		try {
			date =new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-14");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Event e1 = new Event("primero", "music", 50, "campside", date, 5, 0);
		Event e2 = new Event("segundo", "teatro", 15, "nose", date, 8, 0);
		
		objGestorEventos.crearEvento(e1,s1.getIdSpace());
		objGestorEventos.crearEvento(e2,s1.getIdSpace());
					
		logger.info("setUp realizado: 2 eventos y 2 espacios creados");
	    }
	 
	 
	 @Ignore("Utilizar cuando pongamos tests sobre bbdd")
	 @After
	    public void tearDown()
	    {
	        //eliminar espacios y eventos creados en tests
	    }
	
	@Ignore("Pruebo a ignorar")
	@Test
    public void crearObjNoPersistentes() {
        Spaces objEspacio = new Spaces("bbklive","bilbao",100000,"recurso1");
        
        Date date;
        
        try {
        	String pattern = "MM-dd-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            date = (Date) simpleDateFormat.parse("12-01-2018");
        	}
        	catch (Exception e) {
        		date = null;
        	}
       
		Event evento = new Event("bbklive", "music", 50, "campside", date, 5, 0);

    }
	
	@Test
	public void contadorId() 
	{
		logger.info("Empezando prueba contador ID");
		java.util.List<Event> eventos = objGestorEventos.listaEventos();
		int idUltimoEvento = eventos.get(eventos.size()-1).getIdEvent();
		assertTrue(objGestorEventos.generarId() == idUltimoEvento+1);
		logger.debug("Prueba contador ID terminada");
		
	}
	
	//@PerfTest(invocations = 1000)
	@Test
	public void bdtestCrear()
	{
		Spaces s1 = new Spaces("primero","bilbao",100000,"recursoA");
    	objGestorEspacios.crearEspacio(s1);
    	
    	assertEquals(s1.getIdSpace() ,objGestorEspacios.devolverEspacio(s1.getIdSpace()).getIdSpace());
    	
    	Date date = null;
		try {
			date =new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-14");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Event e1 = new Event("primero", "music", 50, "campside", date, 5, 0);
		
		objGestorEventos.crearEvento(e1,s1.getIdSpace()); 
		
		assertEquals(e1.getIdEvent(), objGestorEventos.getE(e1.getIdEvent()).getIdEvent());
    	
	}
	@Test
	public void bdtestEliminar()
	{
		    	
    	Spaces s1 = new Spaces("primero","bilbao",100000,"recursoA");
    	objGestorEspacios.crearEspacio(s1);
    	
    	
    	Date date = null;
		try {
			date =new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-14");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Event e1 = new Event("primero", "music", 50, "campside", date, 5, 0);
		
		objGestorEventos.crearEvento(e1,s1.getIdSpace());
		
		objGestorEventos.eliminarEvento(e1.getIdEvent());
		objGestorEspacios.eliminarEspacio(s1.getIdSpace());
	}
	
	@Test
	public void bdtestVer()
	{
		    	
    	Spaces s = objGestorEspacios.devolverEspacio(1);
    	assertFalse(s.getName().isEmpty());
    	
    	Event e = objGestorEventos.getE(1);
    	assertFalse(s.getName().isEmpty());
    	
		java.util.List<Event> eventos = objGestorEventos.listaEventos();
		assertFalse(eventos.isEmpty());
		
		java.util.List<Spaces> espacios = objGestorEspacios.listaEspacios();
		assertFalse(espacios.isEmpty());
    
	}
	
	@Test
	public void bdtestModificar()
	{
    	Spaces s = objGestorEspacios.devolverEspacio(1);
    	int capacity= s.getCapacity();
    	s.setCapacity(s.getCapacity()+1);
    	objGestorEspacios.modiciarEspacio(s);
    	assertFalse(objGestorEspacios.devolverEspacio(1).getCapacity() == capacity);
    	
    	/*Event e = objGestorEventos.getE(1);
    	float price = e.getPrice();
    	e.setPrice(e.getPrice()+5);
    	objGestorEventos.modificarEvento(e);
    	assertFalse(objGestorEventos.getE(1).getPrice() == price);*/
    	
    
	}
	
	
	
	
}
