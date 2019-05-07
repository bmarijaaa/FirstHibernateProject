package model;

import java.util.Scanner;

import bussinesService.CrudMetode;


public class GlavnaKlasa {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
			System.out.println("Unesite naziv marke: ");
				String nazivMarke = scanner.nextLine();
			System.out.println("Unesite zemlju: ");
				String zemlja = scanner.nextLine();
			System.out.println("Unesite grad: ");
				String grad = scanner.nextLine();
			System.out.println("Unesite ulicu: ");
				String ulica = scanner.nextLine();	
				
			//int idMarke = Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		CrudMetode metode = new CrudMetode();
			
			metode.ubaciMarku(nazivMarke, zemlja, grad, ulica);
			
		
		
		
		
	}

}
