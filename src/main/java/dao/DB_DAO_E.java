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

public class DB_DAO_E{
	
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	PersistenceManager pm = pmf.getPersistenceManager();
	//pm.getFetchPlan().setMaxFetchDepth(3);
	Transaction tx = pm.currentTransaction();
	
	private static ArrayList<Event> eventos;
	private Event evento;
	private List<Event> listEventos;
	private static DB_DAO_E instance;
		
	public static DB_DAO_E getInstance() {
		if (instance == null) {
			instance = new DB_DAO_E();
		
		
		}		
		
		return instance;
	}
		
	//Método para registrar el usuario
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
		
		}

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
