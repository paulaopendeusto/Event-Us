package gestor;

import data.Event;
import dao.DB_DAO_S;
import data.*;

public class gestorEspacios 
{

	public void crearEspacio(Spaces objEspacio) 
	{
		
		
		DB_DAO_S.getInstance().registrarS(objEspacio);
		
	}
	
	public void eliminarEspacio(int idEspacio)
	{
		
		//eliminar espacio
	}
	
	
}
