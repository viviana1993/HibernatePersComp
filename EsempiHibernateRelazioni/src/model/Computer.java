package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

@Entity
public class Computer {
	@Id
	@GeneratedValue
	private long id_computer;
	private String modello;
	
	//@ManyToOne
	//@JoinColumn(name="id_persona")
	//private Persona persona;
	
	
	@ManyToMany
	private Set<Persona> persone=new HashSet<>();
	

	public Computer() {
		this.modello = "";
	}

	public Computer(long id_computer, String modello) {
		super();
		this.id_computer = id_computer;
		this.modello = modello;
	}

	public long getId_computer() {
		return id_computer;
	}

	public void setId_computer(long id_computer) {
		this.id_computer = id_computer;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}
	
	

	public Set<Persona> getPersone() {
		return persone;
	}

	public void setPersone(Set<Persona> persone) {
		this.persone = persone;
	}
	
	
	public void addPersone(Persona p){
		this.persone.add(p);
	}
}
