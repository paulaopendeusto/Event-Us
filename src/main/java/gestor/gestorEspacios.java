package gestor;

import java.util.List;

import dao.DB_DAO_S;
import data.Spaces;

public class gestorEspacios
{
List<Spaces> espacios;


		public void crearEspacio(Spaces objEspacio)
		{
		
			System.out.println("crear espacio");
			objEspacio.setIdSpace(this.generarId());
			DB_DAO_S.getInstance().registrarS(objEspacio);
		
		}
		
		
		
		public void eliminarEspacio(int idEspacio)
		{
			System.out.println("Eliminar espacio");
			DB_DAO_S.getInstance().eliminarS(idEspacio);
		}
		
		public void modiciarEspacio(Spaces espacio)
		{
			System.out.println("Modificar espacio");
			DB_DAO_S.getInstance().modificarS(espacio);
		}
		
		public List<Spaces> listaEspacios()
		{
			espacios = DB_DAO_S.getInstance().getEspacios();
			
			System.out.println("listado espacios");
			
			return espacios;
		}
		
		public Spaces devolverEspacio(int idEspacio)
		{
			Spaces espacio = DB_DAO_S.getInstance().getS(idEspacio);
			
			return espacio;
		
		}
		
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
