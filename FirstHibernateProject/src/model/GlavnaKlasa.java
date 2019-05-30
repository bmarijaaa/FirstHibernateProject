package model;

import java.util.ArrayList;
import java.util.List;

import bussinesService.CrudMetode;

public class GlavnaKlasa {

	public static void main(String[] args) {

			
		CrudMetode metode = new CrudMetode();
		
		User user = metode.vratiUseraSaListomMarki(1);
		
		for(Marka m: user.getListaMarki()) {
			System.out.println(m.getNazivMarke());
		}
		

		
		

			
			
		
			
		
	}

}
