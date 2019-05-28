package model;

import java.util.ArrayList;
import java.util.List;

import bussinesService.CrudMetode;

public class GlavnaKlasa {

	public static void main(String[] args) {

			
		CrudMetode metode = new CrudMetode();
		
		User user = metode.vratiUsera(2);
		
		Marka m1 = metode.vratiMarku(1);
		Marka m2 = metode.vratiMarku(3);
		Marka m3 = metode.vratiMarku(4);
		
		
		boolean spoji1 = metode.dodajMarkuUseru(m1, user);
		boolean spoji2 = metode.dodajMarkuUseru(m2, user);
		boolean spoji3 = metode.dodajMarkuUseru(m3, user);
		
		if(spoji1 && spoji2 && spoji3) {
			System.out.println("Uspesno spojeni");
		}else {
			System.out.println("Greska u spoju!");
		}
			
			
		
			
		
	}

}
