package data;

import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


/**
 * 
 * @version 1.0
 *
 * Clase entidad. Da lugar al objetivo principal de la aplicación, crear, modificar, asignar y eliminar espacios.
 * La clase evento se guarda en BBDD usando DAO. 
 * La relación en BBDD es de 1 -> N, donde el lado 1 (Spaces) y lado N (Event)
 * 
 * 
 * Dispone de los parametros necesarios para el funcionamiento de la aplicación, junto con sus getters y settes.
 * @param listaEventos Se trata de una lista de eventos (entidad evento), necesaria para la relación en BBDD..
 * 
 */
@PersistenceCapable(detachable = "true")
public class Spaces 
{
	
	@PrimaryKey
	private int idSpace;
	private String name;
	private String address;
	private int capacity;
	private String resources;
	
	@Persistent(defaultFetchGroup="true")
	@Element(column="idSpace")
	private ArrayList<Event> listaEventos;
	
	/**
	 * 
	 * @param atributos del espacio
	 * 
	 * Constructor de espacios que además inicializa la lista de eventos del espacio.
	 */
	public Spaces(String name, String address, int capacity, String resources)
	{
		this.name=name;
		this.address=address;
		this.capacity=capacity;
		this.resources=resources;
		this.listaEventos = new ArrayList<Event>();

	}
	/** 
	 * Constructor de espacio necesario para que se inicialice la lista de eventos que van a ser asignados a este espacio.
	 */
	public Spaces()
	{
		
		this.listaEventos = new ArrayList<Event>();

	}
	
	
	/**
	 * 
	 * @param objeto de tipo Spaces
	 * 
	 * Constructor de espacio.
	 */
	public Spaces(Spaces s)
	{
		this.idSpace= s.getIdSpace();
		this.name=s.getName();
		this.address=s.getAddress();
		this.capacity=s.getCapacity();
		this.resources=s.getResources();
		this.listaEventos = s.getListaEventos();

	}
	

	public int getIdSpace() {
		return idSpace;
	}

	public void setIdSpace(int idSpace) {
		this.idSpace = idSpace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}
	
	public void addEvento(Event e)
	{
		this.listaEventos.add(e);
	}

	public ArrayList<Event> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(ArrayList<Event> listaEventos) {
		this.listaEventos = listaEventos;
	}
	
	
	@Override
	public String toString() {
		return idSpace + ": " + name + ", localización: " + address + ", capacidad: " + capacity
				+ ", recursos: " + resources;
	}

	
		
}
