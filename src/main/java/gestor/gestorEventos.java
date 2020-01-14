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
	
	
	/**
	 * 
	 * @author Iñigo
	 * @version 1.0
	 * 
	 * Clase intermediadora entre interfaz gráfica y BBDD.
	 * Recoge datos cedidos por usuarios, y los formatea para que la clase que interactua con BBDD 
	 * los pueda persistir y viceversa. 
	 *
	 */
	public class gestorEventos
	{
		private List<Event> eventos;
		private DB_DAO_E objDao;
		private Event evento;
		
		public gestorEventos() 
		{
			objDao = new DB_DAO_E();
		}
		
		
		/**
		 * 
		 * @param evento objeto tipo evento
		 * 
		 * Recibe un objeto tipo evento y llama al metodo generar id para asignarle un id
		 * Después Pasa el objeto transformado a DB.
		 * 
		 *  Una vez persistido el objeto evento, se procede a su asignación con espacio
		 *  Para ello, se llama al gestor espacios y se le pasa el id del espacio que selecciona el usuario
		 *  y el id del evento que acababamos de persistir.
		 *  
		 */
		public void crearEvento(Event evento, int idEspacio)
		{
		
			
		
			
			
			evento.setIdEvent(this.generarId());
			
			
			int idEvento = evento.getIdEvent();
			
			objDao.registrarE(evento);
			
			
			gestorEspacios objEspacios = new gestorEspacios();
			
			
			
			objEspacios.asignarEvento(idEvento, idEspacio);
			
		
		}
	
		/**
		 * 
		 * @param idEvent id de evento
		 * @return devuelve objeto evento con id específico. 
		 * 
		 * Usuario pide un espacio de BD, gestor recibe el id se lo pasa a BD, BD devuelve el espacio sacada de BD
		 * y gestor devuelve a usuario. 
		 */
		public Event getE(int idEvent)
		{
			
			
			evento = objDao.getE(idEvent);
			
			return evento;
			
		
		}
		
		/**
		 * 
		 * @return lista de eventos
		 * 
		 * pide a BD la lista completa de eventos y las devuelve.
		 */
		public List<Event> listaEventos()
		{
			
			eventos = objDao.getEventos();
			
			return eventos;
			// objDao.getInstance()
			// sacar mediante DB_DAO_E lista de todos los eventos ==> metodo en dao todavia no esta
		}
		
		/**
		 * 
		 * @param idEvento id de evento a eliminar
		 * 
		 * Recibe un id del evento que el usuario ha querido eliminar, y se lo pasa directamente 
		 * al metodo especifico para eliminar evento en BD.
		 */
		public void eliminarEvento(int idEvento)
		{
			objDao.eliminarE(idEvento);
		}
		
		/**
		 * 
		 * @return entero con último id
		 * 
		 * Para solventar el problema de los ids, se ha creado el metodo generar ids unicos.
		 * 
		 * Comprueba cual es el último objeto creado el BD y comprueba cu id, se recoge ese id y se le suma 1.
		 * 
		 * En caso de que la lista este vacia, se le asigna id = 1;
		 * 
		 */
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

		/**
		 * 
		 * @param evento objeto tipo evento
		 * 
		 * Recibe un objeto de tipo evento con el id del evento a modificar
		 * El objeto recibido ya esta transformado para que sustituya al existente en DB
		 */
		public void modificarEvento(Event evento)
		{
			
			objDao.modificarE(evento);
			
		}
		
	}
