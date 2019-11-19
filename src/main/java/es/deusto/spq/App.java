package es.deusto.spq;

import data.Spaces;
import gestor.gestorEspacios;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	gestorEspacios objGestor = new gestorEspacios();
		
		Spaces objEspacio = new Spaces(1,"bbklive","bilbao",100000,"");
		
		objGestor.crearEspacio(objEspacio);
    }
}
