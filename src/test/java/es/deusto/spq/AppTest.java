package es.deusto.spq;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
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
	
	 @Before
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
	
	@Test
    public void crearObjNoPersistentes() {
        Spaces objEspacio = new Spaces(2,"bbklive","bilbao",100000,"");
        
        Date date;
        
        try {
        	String pattern = "MM-dd-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            date = (Date) simpleDateFormat.parse("12-01-2018");
        	}
        	catch (Exception e) {
        		date = null;
        	}
       
		Event evento = new Event(0, "bbklive", "music", 50, "campside", date, 5, 0);

    }
	
	@Ignore("Para testear base de datos")
	@Test
	public void bdtest()
	{
 
		//gespacios.crearEspacio(objEspacio);
		//geventos.crearEvento(evento);
		//gespacios.eliminarEspacio(1);
	}
	
}
