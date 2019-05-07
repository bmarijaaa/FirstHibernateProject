package bussinesService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Adresa;
import model.Marka;

public class CrudMetode {
	
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public void ubaciMarku(String nazivMarke, String zemlja, String grad, String ulica) {
		
		Adresa adresa = new Adresa();
			adresa.setZemlja(zemlja);
			adresa.setGrad(grad);
			adresa.setUlica(ulica);
			
		Marka marka = new Marka();
			marka.setNazivMarke(nazivMarke);
			marka.setAdresa(adresa);
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
		try {
			sesija.save(marka);
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
						marka.getAdresa().setZemlja(zemlja);
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
	
	public boolean obrisiMarku(int idMarke) {
		
		Marka marka =vratiMarku(idMarke);
		
		Session sesija = sf.openSession();
			sesija.beginTransaction();
			try {
					if(marka != null) {
						sesija.delete(marka);
						System.out.println("delete uspeo");
						sesija.getTransaction().commit();
						return true;
					}else {
						System.out.println("Nije uspeo delete");
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
