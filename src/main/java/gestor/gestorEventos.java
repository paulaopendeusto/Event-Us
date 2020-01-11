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
List<Event> eventos;
public void crearEvento(Event evento, int idEspacio)
{


DB_DAO_E objDao = new DB_DAO_E();


evento.setIdEvent(this.generarId());


int idEvento = evento.getIdEvent();

objDao.registrarE(evento);


gestorEspacios objEspacios = new gestorEspacios();



objEspacios.asignarEvento(idEvento, idEspacio);


}

public Event getE(int idEvent)
{
DB_DAO_E objDao = new DB_DAO_E();

return objDao.getE(idEvent);

}
public List<Event> listaEventos()
{
DB_DAO_E objDao = new DB_DAO_E();
return objDao.getEventos();
// objDao.getInstance()
// sacar mediante DB_DAO_E lista de todos los eventos ==> metodo en dao todavia no esta
}




public void eliminarEvento(int idEvento)
{
DB_DAO_E.getInstance().eliminarE(idEvento);
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


}
