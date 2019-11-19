package dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import javax.jdo.Extent;
import java.util.ArrayList;
import java.util.List;

import data.*;

public class DB_DAO_S {
	
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	PersistenceManager pm = pmf.getPersistenceManager();
	
	
	//pm.getFetchPlan().setMaxFetchDepth(3);
	Transaction tx = pm.currentTransaction();
	
//	private static ArrayList<Vuelo> vuelos;
	
	
	private static DB_DAO_S instance;
		
	public static DB_DAO_S getInstance() {
		if (instance == null) {
			instance = new DB_DAO_S();
		
		
		}		
		
		return instance;
	}
		
	//Metodo para registrar el usuario
	public boolean registrarS(Spaces espacio){	
						
		try {
			System.out.println("- Registrando usuario");			
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();		
			
			tx.begin();
			
			
		
			pm.makePersistent(espacio);
								
			System.out.println("Usuario registrado : "+espacio.getName());
			
			tx.commit();

		} catch (Exception ex) {
			System.err.println(" $ Error a la hora de registrar usuario: " + ex.getMessage());
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

	public Spaces getS(int idSpace) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		String nombre;

		
		Spaces espacio = null;
	
		try {
			//System.out.println("   * Buscando usuario con email: " + email);
			tx.begin();
			Query query = pm.newQuery(Spaces.class);
			@SuppressWarnings("unchecked")
			List<Spaces> espacios = (List<Spaces>) query.execute();
			for (Spaces u  : espacios) {
				if (u.getIdSpace() == (idSpace)) {
				
					espacio = new Spaces(idSpace, u.getName(),u.getAddress(),u.getCapacity(),u.getResources());
					
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
		
		return espacio;
	}

}
