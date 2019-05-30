package bussinesService;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Adresa;
import model.Marka;
import model.User;

public class CrudMetode {
	
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public boolean ubaciMarku(String nazivMarke) {
		
		Marka marka = new Marka();
		marka.setNazivMarke(nazivMarke);
	
		Session sesija = sf.openSession();
		sesija.beginTransaction();
		try {
			sesija.save(marka);
			sesija.getTransaction().commit();	
			System.out.println("Uspesno ubacena marka");
			return true;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			System.out.println("Nije ubacio marku");
			return false;
		}finally {
			sesija.close();
		}
	}
	
	
	
	public boolean ubaciUsera(String ime) {
		
		User user = new User();
			user.setIme(ime);
		Session sesija = sf.openSession();
			sesija.beginTransaction();
		try {
			sesija.save(user);
			sesija.getTransaction().commit();
			System.out.println("Uspesno ubacen user");
			return true;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			System.out.println("Neuspesno ubacen user");
			return false;
		}finally {
			sesija.close();
		}
		
	}
	
	public User vratiUsera(int idUser) {
		
		User user = new User();
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
				user = sesija.get(User.class, idUser);
				
				sesija.getTransaction().commit();
				System.out.println("Uspesno preuzet user");
				return user;
			} catch (Exception e) {
				sesija.getTransaction().rollback();
				System.out.println("Neuspesno preuzet user");
				return null;
			}finally {
				sesija.close();
			}
		
	}
	
	public User vratiUseraSaListomMarki(int idUser) {
		
		User user = new User();
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
				user = sesija.get(User.class, idUser);
				//user.getListaMarki().size(); //preuzeo sam listu marki na 1. nacin
				Hibernate.initialize(user.getListaMarki()); //preuzeo sam listu marki na 2. nacin
				sesija.getTransaction().commit();
				System.out.println("Uspesno preuzet user");
				return user;
			} catch (Exception e) {
				sesija.getTransaction().rollback();
				System.out.println("Neuspesno preuzet user");
				return null;
			}finally {
				sesija.close();
			}
		
	}
	
	
	public Marka vratiMarku(int idMarka) {
		
		Marka marka = new Marka();
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
				marka = sesija.get(Marka.class, idMarka);
				sesija.getTransaction().commit();
				return marka;
			} catch (Exception e) {
				sesija.getTransaction().rollback();
				return null;
			}finally {
				sesija.close();
			}
	}
	
	public boolean dodajMarkuUseru(Marka marka, User user) {
		
		marka.setUser(user);
		user.getListaMarki().add(marka);
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
				sesija.update(user);
				sesija.update(marka);
				sesija.getTransaction().commit();
				return true;
			} catch (Exception e) {
				sesija.getTransaction().rollback();
				return false;
			}finally {
				sesija.close();
			}
		
		
	}
	
	
	
	
	
	
	
}
