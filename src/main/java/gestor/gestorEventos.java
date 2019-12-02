package gestor;

import java.util.List;

import dao.DB_DAO_E;
import data.Event;

public class gestorEventos 
{

	public void crearEvento(Event evento) 
	{
	//	Event objEvento = new Event();
		DB_DAO_E objDao = new DB_DAO_E();
		
		objDao.registrarE(evento);
		
		
	}
	
	public void eliminarEvento(int idEvent)
	{
		
		//eliminar evento
	}
	
	public List<Event> listaEventos() 
	{
		return null;
		// sacar mediante DB_DAO_E lista de todos los eventos ==> metodo en dao todavia no esta
		
		
	}
	
}
