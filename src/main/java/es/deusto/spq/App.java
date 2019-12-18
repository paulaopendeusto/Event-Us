package es.deusto.spq;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import data.Event;
import data.Spaces;
import gestor.gestorEspacios;
import gestor.gestorEventos;
import gui.menuPrincipal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
    	
    	menuPrincipal window=new menuPrincipal();
    	window.setVisible(true);
    	
    	gestorEspacios objGestorEspacios = new gestorEspacios();
    	gestorEventos objGestorEventos= new gestorEventos();
    	
//		Spaces objEspacio = new Spaces("que tal","bilbao",100000,"");
    			
//    	objGestorEspacios.crearEspacio(objEspacio);
//   	objGestorEspacios.modiciarEspacio(5, "nombre", "direccion", 45, "resources");
//		objGestorEspacios.eliminarEspacio(1);
    	
//    	List<Spaces> lista = objGestor.listaEspacios();
//    	
//    	for(Spaces space : lista)
//    	{
//    		System.out.println(space.toString());
//    	}	   	
    	
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    	
    	Date date = new Date();
    	System.out.println(date);
		try {
			date = format.parse ( "2009-12-31" );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		System.out.println(date);

		
		Event evento = new Event("hola", "music", 50, "campside", date, 5, 0);
		
//		objGestorEventos.crearEvento(evento);
//		objEspacio.addEvento(evento);
		
    }
}
