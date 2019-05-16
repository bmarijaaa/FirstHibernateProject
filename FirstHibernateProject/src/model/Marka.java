package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Marka {
	
	@Id 	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int idMarke;
	private String nazivMarke;
	@Embedded
	private Adresa adresa;
	@ManyToMany(mappedBy="marke")
	private List<User> listaUsera = new ArrayList<User>();
	
	public List<User> getListaUsera() {
		return listaUsera;
	}
	public void setListaUsera(List<User> listaUsera) {
		this.listaUsera = listaUsera;
	}
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
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

}
