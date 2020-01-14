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


/**
 * 
 * @author Iñigo
 * @version 1.0
 * 
 * Clase que interactua con BBDD utilizando DAO, específica para la entidad espacio. 
 * 
 *
 */
public class DB_DAO_S {
	
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	PersistenceManager pm = pmf.getPersistenceManager();
	
	
	//pm.getFetchPlan().setMaxFetchDepth(3);
	Transaction tx = pm.currentTransaction();
	
//	private static ArrayList<Vuelo> vuelos;
	
	
	private static DB_DAO_S instance;
		
	
	//public DB_DAO_S 
	/**
	 * 
	 * @return devuelve instancia de la clase
	 * 
	 * Clase estática que devuelve instancia de la propia clase. Empleada para poder acceder a los metodos 
	 * de la clase sin tener que declarar un objeto de tipo DB_DAO_S 
	 */
	public static DB_DAO_S getInstance() {
		if (instance == null) {
			instance = new DB_DAO_S();
		
		
		}		
		
		return instance;
	}
		
	/**
	 * 
	 * @param espacio recibe una entidad espacio
	 * @return devuelve booleano como comprobación de funcionamiento
	 * 
	 * registrarS, añade una linea a la tabla de espacio en BBDD. Para ello recibe un objetivo de tipo evento, 
	 * y lo hace persistente. 
	 */
	public boolean registrarS(Spaces espacio){	
						
		try {
			System.out.println("- Registrando espacio");			
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();		
			
			tx.begin();
			
			
		
			pm.makePersistent(espacio);
								
			System.out.println("Espacio registrado : "+espacio.getName());
			
			tx.commit();

		} catch (Exception ex) {
			System.err.println(" $ Error a la hora de registrar espacio: " + ex.getMessage());
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
	 * @param idSpace Recibe el id de un espacio
	 * @return	devuelve un espacio
	 * 
	 * getS, busca en BBDD un espacio especifíco de acuerdo al id que el usuario le pase por parametro. 
	 * Para ello saca todos los espacios de base de datos y compara sus ids hasta que coincidan. 
	 */
	public Spaces getS(int idSpace) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();		
		Spaces espacio= new Spaces();
	
		try {
			//System.out.println("   * Buscando usuario con email: " + email);
			tx.begin();
			Query query = pm.newQuery(Spaces.class);
			@SuppressWarnings("unchecked")
			List<Spaces> espacios = (List<Spaces>) query.execute();
			
		
			for (Spaces s  : espacios) {
				if (s.getIdSpace() == (idSpace)) {
				
					//espacio = new Spaces(idSpace, u.getName(),u.getAddress(),u.getCapacity(),u.getResources());
					espacio = new Spaces(s);
					System.out.println("de BD:"+s.toString());
					System.out.println("EL ASIGNADO: "+espacio.toString());
					
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
		
		System.out.println("Espacio que paso: "+espacio.toString());
		return espacio;
	}
	/**
	 * 
	 * @return lista de espacios completa de BBDD
	 * 
	 * Saca de BBDD la lista completa de los espacios registrados.
	 */
	public List<Spaces> getEspacios() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
	

		List<Spaces> espaciosLista = null;
	
		try {
			//System.out.println("   * Buscando usuario con email: " + email);
			tx.begin();
			Query query = pm.newQuery(Spaces.class);
			@SuppressWarnings("unchecked")
			List<Spaces> espacios = (List<Spaces>) query.execute();
			
			espaciosLista = new ArrayList<Spaces>(espacios); 
			//for (Spaces e: espaciosLista) {System.out.println("---------"+e.toString());}
			
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			//for (Spaces e: espaciosLista) {System.out.println(e.toString()+"-------");}

			pm.close();
		}

		return espaciosLista;
	}
	
	/**
	 * 
	 * @param idEspacio id de espacio
	 * @return booleano de comprobación
	 * 
	 * elimina un espacio de BBDD, comparando el id recibido con todos los existentes en BBDD. 
	 * Si alguno coincide se elimina y se devuelve true, en caso contrario se devuelve un false
	 */
	public boolean eliminarS(int idEspacio){	
		
		try {
					
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();		
			
			tx.begin();
			
			
			Spaces sp = pm.getObjectById(Spaces.class , idEspacio);
			pm.deletePersistent(sp);
			System.out.println("Espacio eliminado!!");
			
			tx.commit();

		} catch (Exception ex) {
			System.err.println(" $ Error a la hora de registrar espacio: " + ex.getMessage());
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
	 * @param espacio entidad espacio para sustituir en BBDD
	 * @return booleano de comprobación
	 * 
	 * Para modificar un espacio en BBDD, modificarE recibe un objeto espacio pero con el id del evento a ser modificado.
	 * 
	 */
	public boolean modificarS(Spaces espacio){	
		
		try {
					
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();		
			
			tx.begin();
			
			
			Spaces sp = pm.getObjectById(Spaces.class , espacio.getIdSpace());
			
			sp.setListaEventos(espacio.getListaEventos());
//			System.out.println("Espacio: " + sp.getName());
			
			sp.setName(espacio.getName());
			sp.setAddress(espacio.getAddress());
			sp.setCapacity(espacio.getCapacity());
			sp.setResources(espacio.getResources());
			sp.setIdSpace(espacio.getIdSpace());
			
			pm.makePersistent(sp);
			
			System.out.println("Espacio modificado!!");
			
			tx.commit();

		} catch (Exception ex) {
			System.err.println(" $ Error a la hora de modificar espacio: " + ex.getMessage());
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


}
