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

    	gestorEspacios objGestor = new gestorEspacios();
		
    	
 //   	Spaces espacio = objGestor.devolverEspacio(2);
    	
//    	List<Spaces> lista = objGestor.listaEspacios();
//    	
//    	
//    	for(Spaces space : lista)
//    	{
//    		System.out.println(space.toString());
//    	}
    	
    	
//		Spaces objEspacio = new Spaces(2,"bbklive","bilbao",100000,"");
//		Spaces objEspacio2 = new Spaces(4,"bbklive","bilbao",100000,"");
//		Spaces objEspacio3 = new Spaces(5,"bbklive","bilbao",100000,"");
		
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
//		objGestor.crearEspacio(objEspacio);
//		objGestor.crearEspacio(objEspacio2);
//		objGestor.crearEspacio(objEspacio3);
//		objGestorE.crearEvento(evento);
//		objGestor.eliminarEspacio(2);
		
    }
}
