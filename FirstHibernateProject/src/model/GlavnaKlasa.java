package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bussinesService.CrudMetode;


public class GlavnaKlasa {

	public static void main(String[] args) {
	
		
		//CrudMetode metode = new CrudMetode();
		//profCvijanovic
			
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		User user = new User();
		
		String prezime = "Petrovic";
		
		List<User> listaUsera = null;
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
	
				String hql = "FROM User WHERE idUser = 5";
				
				Query upit = sesija.createQuery(hql);
				listaUsera = upit.getResultList();
				
				if(listaUsera.isEmpty()) {
					System.out.println("Nema tih usera");
				
				}else{
					for(User u:listaUsera ) {
						
						System.out.println(u.getIdUser() + " " + u.getIme() + " " + u.getPrezime());
					}
				}
		
				
				
				sesija.getTransaction().commit();
			} catch (Exception e) {
				sesija.getTransaction().rollback();
			}finally {
				sesija.close();
			}
			
			
			
			
			
			
			
		
			
		
	}

}
