package bussinesService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Marka;

public class CrudMetode {
	
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public void ubaciMarku(String nazivMarke, String zemlja) {
		
		Marka marka = new Marka();
			marka.setNazivMarke(nazivMarke);
			marka.setZemlja(zemlja);
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
		try {
			sesija.persist(marka);
			sesija.getTransaction().commit();	
			System.out.println("Uspesno ubacena marka");
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			System.out.println("Nije ubacio");
		}finally {
			sesija.close();
		}
	}
	
	
	public Marka vratiMarku(int idMarke) {
		
		Marka marka = null;
		Session sesija = sf.openSession();
			sesija.beginTransaction();
			try {
				marka = sesija.get(Marka.class,idMarke);
				sesija.getTransaction().commit();
				return marka;
			} catch (Exception e) {
				sesija.getTransaction().rollback();
				return null;
			}finally {
				sesija.close();
			}
	}
	
	
	
	public boolean azurirajZemlju(int idMarke, String zemlja) {
		
		Marka marka =vratiMarku(idMarke);
		
		Session sesija = sf.openSession();
			sesija.beginTransaction();
			try {
					if(marka != null) {
						marka.setZemlja(zemlja);
						sesija.update(marka);
						System.out.println("Update uspeo");
						sesija.getTransaction().commit();
						return true;
					}else {
						System.out.println("Nije uspeo update");
						sesija.getTransaction().commit();
						return false;
					}
			} catch (Exception e) {
				sesija.getTransaction().rollback();
				return false;
			}finally {
				sesija.close();
			}
		
	}
	
	
	
	
	
	
}
