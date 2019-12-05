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
	public List<Spaces> listaEspacios() 
	{
		return null;
		// sacar mediante DB_DAO_S lista de todos los espacios ==> metodo en dao todavia no esta
		
		
	}
	
	public void eliminarEspacio(int idEspacio)
	{	
		//eliminar espacio
		System.out.println("Eliminar espacio");
		
		
		DB_DAO_S.getInstance().eliminarS(idEspacio);
	}
	
}
