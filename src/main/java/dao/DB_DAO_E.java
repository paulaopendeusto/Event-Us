package dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import javax.jdo.Extent;
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

	

}
