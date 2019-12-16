package gestor;

import java.util.List;

import dao.DB_DAO_S;
import data.Spaces;

public class gestorEspacios 
{

	public void crearEspacio(Spaces objEspacio) 
	{
		
		
		DB_DAO_S.getInstance().registrarS(objEspacio);
		
	}
	
	
	
	public void eliminarEspacio(int idEspacio)
	{	
		System.out.println("Eliminar espacio");		
		DB_DAO_S.getInstance().eliminarS(idEspacio);
	}
	
	public void modiciarEspacio(int idSpace, String name, String address, int capacity, String resources)
	{
		System.out.println("Modificar espacio");
		DB_DAO_S.getInstance().modificarS(idSpace, name, address, capacity, resources);
	}
	
	public List<Spaces> listaEspacios()
	{
		List<Spaces> espacios = DB_DAO_S.getInstance().getEspacios();
	
		System.out.println("lsitado espacios");
		 
		return espacios;
	}
	
	public Spaces devolverEspacio(int idEspacio)
	{
		Spaces espacio = DB_DAO_S.getInstance().getS(idEspacio);
		
		return espacio;	
		
	}
	
}
