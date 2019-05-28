package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idUser;
		private String ime;
		
		@OneToMany
		private List<Marka> listaMarki = new ArrayList<Marka>();

		public int getIdUser() {
			return idUser;
		}

		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}

		public String getIme() {
			return ime;
		}

		public void setIme(String ime) {
			this.ime = ime;
		}

		public List<Marka> getListaMarki() {
			return listaMarki;
		}

		public void setListaMarki(List<Marka> listaMarki) {
			this.listaMarki = listaMarki;
		}
		
		
		
		

		
		
			
		
		
}
