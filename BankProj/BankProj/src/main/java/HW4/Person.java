package HW4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Person implements Serializable {

	private transient List<Observer> observers = new ArrayList<Observer>();
	private int id;
	private String name;

	public Person() {
		super();
	}
	
	/**
	 * @param name
	 * @param id
	 */
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	public void attach(Observer observer){
		observers.add(observer);		
	}
}
