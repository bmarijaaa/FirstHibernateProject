package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bussinesService.CrudMetode;


public class GlavnaKlasa {

	public static void main(String[] args) {
	
		
		CrudMetode metode = new CrudMetode();
			
/*			metode.ubaciMarku("Moskvic", "SSSR", "Moskva", "KGB");
			
			List<Adresa> listaAdresa = new ArrayList<Adresa>();
			
			Adresa adresa1 = new Adresa();
				adresa1.setZemlja("Srbija");
				adresa1.setGrad("Beograd");
				adresa1.setUlica("Knez Mihajlova");
		
			listaAdresa.add(adresa1);
			
			Adresa adresa2 = new Adresa();
			adresa2.setZemlja("Srbija");
			adresa2.setGrad("Nis");
			adresa2.setUlica("Beogradska");
			
			listaAdresa.add(adresa2);
			
			metode.ubaciUsera("Pera", "Peric", listaAdresa);*/
			
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		List<Adresa> listaAdresa = new ArrayList<Adresa>();
		List<Marka> marke = new ArrayList<Marka>();
		
		User user = new User();
		Marka marka = new Marka();
		Marka marka2 = new Marka();
		Adresa adresa = new Adresa();
		
			adresa.setZemlja("Srbija");
			adresa.setGrad("Beograd");
			adresa.setUlica("Moja ulica");
			
			marka.setNazivMarke("ferari");
			marka.setAdresa(adresa);
			marka.setUser(user);
			
			marka2.setNazivMarke("Lambo");
			marka2.setAdresa(adresa);
			marka2.setUser(user);
			
			user.setIme("Pera");
			user.setPrezime("Peric");
				listaAdresa.add(adresa);
				user.setListaAdresa(listaAdresa);
				marke.add(marka);
				marke.add(marka2);
				user.setMarke(marke);
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
				sesija.save(user);
				sesija.save(marka);
				sesija.save(marka2);
				sesija.getTransaction().commit();
			} catch (Exception e) {
				sesija.getTransaction().rollback();
			}finally {
				sesija.close();
			}
			
			
			
			
			
			
			
		
			
		
	}

}
