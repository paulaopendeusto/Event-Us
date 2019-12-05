package gestor;

import java.util.List;

import dao.DB_DAO_E;
import dao.DB_DAO_S;
import data.Event;

public class gestorEventos 
{

	public void crearEvento(Event evento) 
	{
	//	Event objEvento = new Event();
		DB_DAO_E objDao = new DB_DAO_E();
		
		objDao.registrarE(evento);
		
		
	}
	
	public void eliminarEvento(int idEvento)
	{	
		//eliminar espacio
		System.out.println("Eliminar evento");
		
		
		DB_DAO_E.getInstance().eliminarE(idEvento);
	}
	
	public List<Event> listaEventos() 
	{
		return null;
		// sacar mediante DB_DAO_E lista de todos los eventos ==> metodo en dao todavia no esta
		
		
	}
	
}
