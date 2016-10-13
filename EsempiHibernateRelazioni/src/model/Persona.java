package model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;




@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_persona;
	
	@Column(name="nome")
	private String nome;
	
	private String cognome;
	
	
	//@OneToOne
	//private Computer computer;
	
	
	
	//@OneToMany(mappedBy="persona",cascade=CascadeType.ALL)//imposto tipo di relazione mappatoDa(evito di creare una terza tabella,ma aggiunge una colonna)
	//@NotFound(action=NotFoundAction.IGNORE)-->se la tabella è vuota lancerebbe eccezione perchè non troverebbe id,
	//in questo modo non lancia l'eccezione le nn lo trova e va avanti
	//private Set <Computer> computer=new HashSet<Computer>();
	
	
	@ManyToMany(mappedBy="persone")
	private Set <Computer> computer=new HashSet<Computer>();
	
	public Set<Computer> getComputer() {
		return computer;
	}

	public void setComputer(Set<Computer> computer) {
		this.computer = computer;
	}

	public Persona() {
		
	}

	public Persona(int id_persona, String nome, String cognome,
			Set<Computer> computer) {
		super();
		this.id_persona = id_persona;
		this.nome = nome;
		this.cognome = cognome;
		this.computer = computer;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public void addComputer(Computer c){
		this.computer.add(c);
		
	}
	
	
	
}
