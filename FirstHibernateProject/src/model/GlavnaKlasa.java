package model;

import java.util.ArrayList;
import java.util.List;

import bussinesService.CrudMetode;

public class GlavnaKlasa {

	public static void main(String[] args) {

			
		CrudMetode metode = new CrudMetode();
		
		List<Marka> listaMarki1 =new ArrayList<Marka>(); 
		
		User user1 = new User();
		user1.setIme("Pera");
		//user1.setListaMarki(listaMarki1);
		
		Marka m1 = new Marka();
		m1.setNazivMarke("Fiat");
		//m1.setUser(user1);
		
		Marka m2 = new Marka();
		m2.setNazivMarke("Renault");
		//m2.setUser(user1);
		
		listaMarki1.add(m1);
		listaMarki1.add(m2);
		
		
		List<Marka> listaMarki2 =new ArrayList<Marka>(); 
		
		User user2 = new User();
		user2.setIme("Mika");
		//user2.setListaMarki(listaMarki2);
		
		Marka m3 = new Marka();
		m3.setNazivMarke("Ferari");
		//m3.setUser(user2);
		
		Marka m4 = new Marka();
		m4.setNazivMarke("Lambo");
		//m4.setUser(user2);
		
		
		listaMarki2.add(m3);
		listaMarki2.add(m4);
		
		
		for(Marka m: listaMarki1) {
			
			metode.ubaciMarku(m.getNazivMarke());
		}
		
		for(Marka m: listaMarki2) {
			
			metode.ubaciMarku(m.getNazivMarke());
		}
		
		
		metode.ubaciUsera(user1.getIme());
		metode.ubaciUsera(user2.getIme());
		
			
			
			
			
		
			
		
	}

}
