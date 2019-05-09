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
		
		User user = new User();
		int brojAdresa = 0;
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
					user = sesija.get(User.class, 1);
					brojAdresa = user.getListaAdresa().size();
				sesija.getTransaction().commit();
			} catch (Exception e) {
				sesija.getTransaction().rollback();
			}finally {
				sesija.close();
			}
			System.out.println(user.getIme());
			System.out.println(brojAdresa);
			
		
	}

}
