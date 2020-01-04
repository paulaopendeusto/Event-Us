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
    	
    	//menuPrincipal window=new menuPrincipal();
    	//window.setVisible(true);
    	
    	gestorEspacios objGestorEspacios = new gestorEspacios();
    	gestorEventos objGestorEventos= new gestorEventos();
    	
    	Spaces s1 = new Spaces("que tal","bilbao",100000,"");
    	Spaces s2= new Spaces("hey","donosti",50000,"");
    			
    	objGestorEspacios.crearEspacio(s1);
    	objGestorEspacios.crearEspacio(s2);

    	
    	
    	
//   	objGestorEspacios.modiciarEspacio(5, "nombre", "direccion", 45, "resources");
//		objGestorEspacios.eliminarEspacio(1);
    	
//    	List<Spaces> lista = objGestor.listaEspacios();
//    	
//    	for(Spaces space : lista)
//    	{
//    		System.out.println(space.toString());
//    	}	   	
//    	
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

		
		Event e1 = new Event("hola", "music", 50, "campside", date, 5, 0);
		Event e2 = new Event("hola2", "teatro", 15, "nose", date, 8, 0);
		

		objGestorEventos.crearEvento(e1);
		objGestorEventos.crearEvento(e2);
		
//		objGestorEspacios.
		
		Event e = objGestorEventos.getE(1);
		System.out.println(e.getName());
		
		objGestorEventos.eliminarEvento(1);
		

//		objEspacio.addEvento(evento);
		
    }
}
