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
		
		List<Adresa> listaAdresa1 = new ArrayList<Adresa>();
		List<Adresa> listaAdresa2 = new ArrayList<Adresa>();
		List<Adresa> listaAdresa3 = new ArrayList<Adresa>();
		List<Marka> marke1 = new ArrayList<Marka>();
		List<Marka> marke2 = new ArrayList<Marka>();
		List<Marka> marke3 = new ArrayList<Marka>();
		List<User> listaUsera1 = new ArrayList<User>();
		List<User> listaUsera2 = new ArrayList<User>();
		
		User user = new User();
		User user2 = new User();
		User user3 = new User();
		
		Marka marka = new Marka();
		Marka marka2 = new Marka();
		
		Adresa adresa = new Adresa();
		
			adresa.setZemlja("Srbija");
			adresa.setGrad("Beograd");
			adresa.setUlica("Moja ulica");
			
			marka.setNazivMarke("ferari");
			marka.setAdresa(adresa);
			listaUsera1.add(user);
			listaUsera1.add(user2);
			marka.setListaUsera(listaUsera1);
			
			marka2.setNazivMarke("Lambo");
			marka2.setAdresa(adresa);
			listaUsera2.add(user);
			listaUsera2.add(user3);
			marka2.setListaUsera(listaUsera2);
			
			user.setIme("Pera");
			user.setPrezime("Peric");
				listaAdresa1.add(adresa);
				user.setListaAdresa(listaAdresa1);
				marke1.add(marka);
				marke1.add(marka2);
				user.setMarke(marke1);
				
				user2.setIme("Mika");
				user2.setPrezime("Mikic");
					listaAdresa2.add(adresa);
					user2.setListaAdresa(listaAdresa2);
					marke2.add(marka2);
					user2.setMarke(marke2);
				
					user3.setIme("Ivana");
					user3.setPrezime("Ivanovic");
						listaAdresa3.add(adresa);
						user3.setListaAdresa(listaAdresa3);
						marke3.add(marka2);
						user3.setMarke(marke3);	
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
				sesija.save(user);
				sesija.save(user2);
				sesija.save(user3);
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
