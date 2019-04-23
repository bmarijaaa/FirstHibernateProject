package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GlavnaKlasa {

	public static void main(String[] args) {
	
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Marka marka = new Marka();
		marka.setNazivMarke("Fiat");
		marka.setZemlja("Italija");
		
		System.out.println(marka.getNazivMarke() + " " + marka.getZemlja());
		
			
		Session sesija = sf.openSession();
			sesija.beginTransaction();
			try {
				sesija.save(marka);
				sesija.getTransaction().commit();	
				System.out.println("Uspesno ubacena marka");
			} catch (Exception e) {
				sesija.getTransaction().rollback();
				System.out.println("Nije ubacio");
			}
		sesija.close();
		
		
	}

}
