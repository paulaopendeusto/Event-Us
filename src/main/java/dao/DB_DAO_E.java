package dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.*;

/**
 * 
 * @author Iñigo
 * @version 1.0
 * 
 * Clase que interactua con BBDD utilizando DAO, específica para la entidad evento. 
 * 
 *
 */
public class DB_DAO_E{
	
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	PersistenceManager pm = pmf.getPersistenceManager();
	//pm.getFetchPlan().setMaxFetchDepth(3);
	Transaction tx = pm.currentTransaction();
	
	private static ArrayList<Event> eventos;
	private Event evento;
	private List<Event> listEventos;
	private static DB_DAO_E instance;
		
	
	/**
	 * 
	 * @return devuelve instancia de la clase
	 * 
	 * Clase estática que devuelve instancia de la propia clase. Empleada para poder acceder a los metodos 
	 * de la clase sin tener que declarar un objeto de tipo DB_DAO_E. 
	 */
	public static DB_DAO_E getInstance() {
		if (instance == null) {
			instance = new DB_DAO_E();
		
		
		}		
		
		return instance;
	}
		
	/**
	 * 
	 * @param objEvento recibe una entidad evento
	 * @return devuelve booleano como comprobación de funcionamiento
	 * 
	 * registrarE, añade una linea a la tabla de evento en BBDD. Para ello recibe un objetivo de tipo evento, 
	 * y lo hace persistente. 
	 */
	public boolean registrarE(Event objEvento){	
						
		try {
			System.out.println("- Registrando evento");			
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();		
			
			tx.begin();
			
			
		
			pm.makePersistent(objEvento);
								
			System.out.println("evento registrado : "+objEvento.getName());
			
			tx.commit();
			
			return true;

		} catch (Exception ex) {
			System.err.println(" $ Error a la hora de registrar evento: " + ex.getMessage());
			ex.printStackTrace();
			
			return false;
			
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
				// ATTENTION -  Datanucleus detects that the objects in memory were changed and they are flushed to DB
			}
		}
	}
	/**
	 * 
	 * @param idEvent Recibe el id de un evento
	 * @return	devuelve un evento
	 * 
	 * getE, busca en BBDD un evento especifíco de acuerdo al id que el usuario le pase por parametro. 
	 * Para ello saca todos los eventos de base de datos y compara sus ids hasta que coincidan. 
	 */
	public Event getE(int idEvent) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		String nombre;

		

		try {
		tx.begin();
		Query query = pm.newQuery(Event.class);
		@SuppressWarnings("unchecked")
		List<Event> eventos = (List<Event>) query.execute();
		for (Event u  : eventos) {
		if (u.getIdEvent() == (idEvent)) {
			
		evento = u;
		return evento;
		
		
		}
		System.out.println();
		}
		
		tx.commit();
		} catch (Exception ex) {
		System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
		if (tx != null && tx.isActive()) {
		tx.rollback();
		}


		pm.close();
		}
		
		return evento;
		}
	/**
	 * 
	 * @param idEvento id de evento
	 * @return booleano de comprobación
	 * 
	 * elimina un evento de BBDD, comparando el id recibido con todos los existentes en BBDD. 
	 * Si alguno coincide se elimina y se devuelve true, en caso contrario se devuelve un false
	 */
	public boolean eliminarE(int idEvento){	
		
		try {
					
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();		
			
			tx.begin();
			
			Event ev = pm.getObjectById(Event.class , idEvento);
			System.out.println("El evento que elimino ahora mismo es : "+ ev.toString());
			pm.deletePersistent(ev);
			System.out.println("Evento eliminado!!");
			
			tx.commit();

		} catch (Exception ex) {
			System.err.println(" $ Error a la hora de registrar evento: " + ex.getMessage());
			ex.printStackTrace();
			
			return false;
			
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
				// ATTENTION -  Datanucleus detects that the objects in memory were changed and they are flushed to DB
			}
			
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param evento entidad evento para sustituir en BBDD
	 * @return booleano de comprobación
	 * 
	 * Para modificar un evento en BBDD, modificarE recibe un objeto evento pero con el id del evento a ser modificado.
	 * 
	 */
	public boolean modificarE(Event evento){	
		
		try {
					
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();		
			
			tx.begin();
			
			
			Event e = pm.getObjectById(Event.class , evento.getIdEvent());
			
			
			e.setName(evento.getName());
			e.setHour(evento.getHour());
			e.setDateEvent(evento.getDateEvent());
			e.setMinutes(evento.getMinutes());
			e.setPrice(evento.getPrice());
			e.setResources(evento.getResources());
			e.setTipology(evento.getTipology());
			e.setIdEvent(evento.getIdEvent());
			
			
			pm.makePersistent(e);
			
			System.out.println("Evento modificado!!");
			
			tx.commit();

		} catch (Exception ex) {
			System.err.println(" $ Error a la hora de modificar evento: " + ex.getMessage());
			ex.printStackTrace();
			
			return false;
			
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
				// ATTENTION -  Datanucleus detects that the objects in memory were changed and they are flushed to DB
			}
			
		}
		
		return true;
	}
	
	/**
	 * 
	 * @return lista de eventos completa de BBDD
	 * 
	 * Saca de BBDD la lista completa de los eventos registrados.
	 */
	public List<Event> getEventos() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
	

		
	
		try {
			//System.out.println("   * Buscando usuario con email: " + email);
			tx.begin();
			Query query = pm.newQuery(Event.class);
			@SuppressWarnings("unchecked")
			List<Event> eventos = (List<Event>) query.execute();
			
			listEventos = new ArrayList<Event>(eventos); 
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			

			pm.close();
		}
		
		return listEventos;
	}

}
