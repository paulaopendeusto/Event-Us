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
		private List<Event> eventos;
		private DB_DAO_E objDao;
		private Event evento;
		
		public gestorEventos() 
		{
			objDao = new DB_DAO_E();
		}
		
		public void crearEvento(Event evento, int idEspacio)
		{
		
			
		
			
			
			evento.setIdEvent(this.generarId());
			
			
			int idEvento = evento.getIdEvent();
			
			objDao.registrarE(evento);
			
			
			gestorEspacios objEspacios = new gestorEspacios();
			
			
			
			objEspacios.asignarEvento(idEvento, idEspacio);
			
		
		}
	
		public Event getE(int idEvent)
		{
			
			
			evento = objDao.getE(idEvent);
			
			return evento;
			
		
		}
		
		public List<Event> listaEventos()
		{
			
			eventos = objDao.getEventos();
			
			return eventos;
			// objDao.getInstance()
			// sacar mediante DB_DAO_E lista de todos los eventos ==> metodo en dao todavia no esta
		}
		
		public void eliminarEvento(int idEvento)
		{
			objDao.eliminarE(idEvento);
		}
		
		public int generarId()
		{
	
		eventos = this.listaEventos();
		int id;
		
		if(eventos.isEmpty()) {
		id = 1;
		System.out.println("lista vacia");
		}
		else {
		
		id = eventos.get(eventos.size()-1).getIdEvent()+1;
		System.out.println("lista NOOO ESTAvacia");
		}
		
		
		return id;
		}
	
		public void modificarEvento(Event evento)
		{
			
			objDao.modificarE(evento);
			
		}
		
	}
