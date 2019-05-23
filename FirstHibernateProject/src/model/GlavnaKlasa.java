package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bussinesService.CrudMetode;


public class GlavnaKlasa {

	public static void main(String[] args) {
	
		
		//CrudMetode metode = new CrudMetode();

			
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		User user = new User();
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
	
				user = sesija.get(User.class, 84);
					user.setPrezime("Petrovic");
				sesija.update(user);
				sesija.getTransaction().commit();
			} catch (Exception e) {
				sesija.getTransaction().rollback();
			}finally {
				sesija.close();
			}
			
			
			
			
			
			
			
		
			
		
	}

}
