package data;

import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


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
	
	
	public Spaces(String name, String address, int capacity, String resources)
	{
		this.name=name;
		this.address=address;
		this.capacity=capacity;
		this.resources=resources;
		this.listaEventos = new ArrayList<Event>();

	}
	public Spaces()
	{
		
		this.listaEventos = new ArrayList<Event>();

	}
	
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
		return "id:" + idSpace + ", " + name + ", localización:" + address + ", capacidad:" + capacity
				+ ", recursos:" + resources + "no tiene evento: ";
	}

	
		
}
