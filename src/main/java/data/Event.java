package data;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;


/**
 * 
 * @version 1.0
 * 
 * Clase entidad. Da lugar al objetivo principal de la aplicación, crear, modificar, asignar y eliminar eventos. 
 * La clase evento se guarda en BBDD usando DAO. 
 * La relación en BBDD es de 1 -> N, donde el lado 1 (Spaces) y lado N (Event)
 * 
 * Dispone de los parametros necesarios para el funcionamiento de la aplicación, junto con sus getters y settes. 
 * No dispone de ningún metodo adicional. 
 *
 */
@PersistenceCapable(detachable="true")
public class Event {

	@PrimaryKey
	private int idEvent;
	private String Name;
	private String Tipology;
	private float Price;
	private String Resources;
	private Date DateEvent;
	private int Hour;
	private int Minutes;
	
	/**
	 * 
	 * @param atributos del evento
	 * 
	 * Constructor de evento.
	 */
	public Event(String name, String tipology, float price, String resources, Date date, int hour, int minutes)
	{
		this.Name = name;
		this.Tipology = tipology;
		this.Price = price;
		this.Resources = resources;
		this.DateEvent = date;
		this.Hour = hour;
		this.Minutes = minutes;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getTipology() {
		return Tipology;
	}

	public void setTipology(String tipology) {
		this.Tipology = tipology;
	}

	public int getHour() {
		return Hour;
	}

	public void setHour(int hour) {
		this.Hour = hour;
	}
	
	public int getMinutes()
	{
		return Minutes;
	}
	
	public void setMinutes(int minutes) {
		this.Minutes = minutes;
	}

	public String getResources() {
		return Resources;
	}

	public void setResources(String resources) {
		this.Resources = resources;
	}

	public Date getDateEvent() {
		return DateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.DateEvent = dateEvent;
	}
	
	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return  idEvent + ": " + Name + ". Tipo: " + Tipology + ". Precio: " + Price
				+ "€. Fecha: " + format.format(DateEvent) + ", " + Hour + ":" + Minutes;
	}
	
	
	
}
