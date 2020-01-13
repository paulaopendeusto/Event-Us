package es.deusto.spq;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import data.Event;
import data.Spaces;
import gestor.gestorEspacios;
import gestor.gestorEventos;

public class AppTest {
	
	/* @Before
	    public void setUp() {
	    	final gestorEspacios gespacios = new gestorEspacios();
			final gestorEventos geventos = new gestorEventos();
			
	    }
	 
	 
	 @Ignore("Utilizar cuando pongamos tests sobre bbdd")
	 @After
	    public void tearDown()
	    {
	        //eliminar espacios y eventos creados en tests
	    }
	*/
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
	
	//@Ignore("Para testear base de datos")
	@Test
	public void bdtestCrear()
	{
		gestorEspacios objGestorEspacios = new gestorEspacios();
    	gestorEventos objGestorEventos= new gestorEventos();
    	    	
    	
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
	}
	
}
