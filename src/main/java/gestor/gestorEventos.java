package gestor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

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
	
	public Event getE(int idEvent) 
	{
		DB_DAO_E objDao = new DB_DAO_E();
		
		return objDao.getE(idEvent);
		
	}
	public List<Event> listaEventos() 
	{
		DB_DAO_E objDao = new DB_DAO_E();
		return objDao.getEventos();
//		objDao.getInstance()
		// sacar mediante DB_DAO_E lista de todos los eventos ==> metodo en dao todavia no esta
	}
	
	
//	public DefaultListModel<Event> listaEventos() 
//	{
//		
//		DefaultListModel<Event> list = new DefaultListModel<Event>();
//		
//		String pattern = "MM-dd-yyyy";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		Date date = null;
//		try {
//			date = simpleDateFormat.parse("12-01-2018");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Event evento = new Event(0, "bbklive", "music", 50, "campside", date, 5, 0);
//		
//		list.addElement(evento);
//		
//		
//		return list;
//		// sacar mediante DB_DAO_E lista de todos los eventos ==> metodo en dao todavia no esta
//	}
	
	public void eliminarEvento(int idEvento)
	{	
		System.out.println("Eliminar evento");
		DB_DAO_E.getInstance().eliminarE(idEvento);
	}
	

	
	
}
