package gestor;

import java.util.List;

import dao.DB_DAO_E;
import dao.DB_DAO_S;
import data.Event;
import data.Spaces;

public class gestorEventos 
{

	public void crearEvento(Event evento) 
	{
	//	Event objEvento = new Event();
		DB_DAO_E objDao = new DB_DAO_E();
		
		objDao.registrarE(evento);
	}
	
	public List<Event> listaEventos() 
	{
		return null;
		// sacar mediante DB_DAO_E lista de todos los eventos ==> metodo en dao todavia no esta
	}
	
	public void eliminarEvento(int idEvento)
	{	
		System.out.println("Eliminar evento");
		DB_DAO_E.getInstance().eliminarE(idEvento);
	}
	
	public void modificarEvento(int idEvento)
	{	
		System.out.println("Modificar evento");
		DB_DAO_E.getInstance().modificarE(idEvento);
	}
	
	
	
}
