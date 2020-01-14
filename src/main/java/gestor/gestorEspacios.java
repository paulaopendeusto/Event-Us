package gestor;

import java.util.List;

import dao.DB_DAO_S;
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
public class gestorEspacios
{
List<Spaces> espacios;

		/**
		 * 
		 * @param objEspacio objeto tipo espacio
		 * 
		 * Recibe un objeto tipo espacio y llama al metodo generar id para asignarle un id
		 * Después Pasa el objeto transformado a DB. 
		 */
		public void crearEspacio(Spaces objEspacio)
		{
		
			System.out.println("crear espacio");
			objEspacio.setIdSpace(this.generarId());
			DB_DAO_S.getInstance().registrarS(objEspacio);
		
		}
		
		
		/**
		 * 
		 * @param idEspacio id de espacio a eliminar
		 * 
		 * Recibe un id del espacio que el usuario ha querido eliminar, y se lo pasa directamente 
		 * al metodo especifico para eliminar espacio en BD.
		 */
		public void eliminarEspacio(int idEspacio)
		{
			System.out.println("Eliminar espacio");
			DB_DAO_S.getInstance().eliminarS(idEspacio);
		}
		/**
		 * 
		 * @param espacio objeto tipo espacio
		 * 
		 * Recibe un objeto de tipo espacio con el id del espacio a modificar
		 * El objeto recibido ya esta transformado para que sustituya al existente en DB
		 */
		public void modiciarEspacio(Spaces espacio)
		{
			System.out.println("Modificar espacio");
			DB_DAO_S.getInstance().modificarS(espacio);
		}
		/**
		 * 
		 * @return lista de espacios
		 * 
		 * pide a BD la lista completa de espacios y las devuelve.
		 */
		public List<Spaces> listaEspacios()
		{
			espacios = DB_DAO_S.getInstance().getEspacios();
			
			System.out.println("listado espacios");
			
			return espacios;
		}
		/**
		 * 
		 * @param idEspacio id de espacio a devolver
		 * @return devuelve espacio con id específico.
		 * 
		 * Usuario pide un espacio de BD, gestor recibe el id se lo pasa a BD, BD devuelve el espacio sacada de BD
		 * y gestor devuelve a usuario. 
		 */
		public Spaces devolverEspacio(int idEspacio)
		{
			Spaces espacio = DB_DAO_S.getInstance().getS(idEspacio);
			
			return espacio;
		
		}
		/**
		 * 
		 * @param idEvento id del evento a asignar
		 * @param idEspacio id del espacio al que se le va a asignar el evento
		 * 
		 * Para conocer relación de BD, ver documentación src/main/java/data
		 * 
		 * Para asiganar un evento, recibe el id del espacio y saca el objeto de DB,
		 * y despues saca el objeto evento de DB (con el id)
		 * 
		 * una vez tiene los dos objetos, añade el evento a la lista de eventos del objeto espacio;
		 * Realizando así la asignación.
		 * 
		 * Por último modifica el espacio en BD.
		 */
		public void asignarEvento(int idEvento, int idEspacio)
		{
		
			gestorEventos objgestor = new gestorEventos();
			
			Spaces espacio = this.devolverEspacio(idEspacio);
			
			espacio.addEvento(objgestor.getE(idEvento));
			
			
			// System.out.println(evento.getName());
			// System.out.println(espacio.getName());
			
			
			
			DB_DAO_S.getInstance().modificarS(espacio);
			
			
			
			//for (Spaces s :this.listaEspacios())
			//{
			//System.out.println(s.getIdSpace());
			//}
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
			
			espacios = this.listaEspacios();
			int id;
			
			if(espacios.isEmpty()) {
			id = 1;
			}
			else {
			
			id = espacios.get(espacios.size()-1).getIdSpace()+1;
			}
			
			
			return id;
		}
		
		}
