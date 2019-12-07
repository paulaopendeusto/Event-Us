package es.deusto.spq;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import data.Event;
import data.Spaces;
import gestor.gestorEspacios;
import gestor.gestorEventos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {

    	gestorEspacios objGestor = new gestorEspacios();
		
		Spaces objEspacio = new Spaces(2,"bbklive","bilbao",100000,"");
		Spaces objEspacio2 = new Spaces(4,"bbklive","bilbao",100000,"");
		Spaces objEspacio3 = new Spaces(5,"bbklive","bilbao",100000,"");
		
//		String pattern = "MM-dd-yyyy";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		Date date = simpleDateFormat.parse("12-01-2018");
//		
//		gestorEventos objGestorE = new gestorEventos();
//		
//		Event evento = new Event(0, "bbklive", "music", 50, "campside", date, 5, 0);
//		
//		objEspacio.addEvento(evento);
//		
//		
		objGestor.crearEspacio(objEspacio);
		objGestor.crearEspacio(objEspacio2);
		objGestor.crearEspacio(objEspacio3);
//		objGestorE.crearEvento(evento);
//		objGestor.eliminarEspacio(2);
		
    }
}
