package gestor;

import dao.DB_DAO_E;
import data.*;

public class gestorEventos 
{

	public void crearEvento(Event evento) 
	{
		DB_DAO_E objDao = new DB_DAO_E();
		
		objDao.registrarE(evento);
	}
	
}
