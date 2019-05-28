package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;


@Entity
public class Marka {
	
	@Id 	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int idMarke;
	private String nazivMarke;
	@ManyToOne
	private User user;
	
	
	public int getIdMarke() {
		return idMarke;
	}
	public void setIdMarke(int idMarke) {
		this.idMarke = idMarke;
	}
	public String getNazivMarke() {
		return nazivMarke;
	}
	public void setNazivMarke(String nazivMarke) {
		this.nazivMarke = nazivMarke;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	


}
