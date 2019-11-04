package data;

import java.util.ArrayList;

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
	
	
	@Join
	@Persistent(defaultFetchGroup = "true")
	private ArrayList<Event> listaEventos;
	
	public Spaces(int idSpace, String name, String address, int capacity, String resources)
	{
		this.idSpace=idSpace;
		this.name=name;
		this.address=address;
		this.capacity=capacity;
		this.resources=resources;
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
	
	
	
		
}
