package test;

import entites.Employee;
import entites.Salarier;
import entites.Vendeur;

public class Test {
	public void main(String []args) {
		Salarier s =new Salarier(124, 1200, "Hiba", "hiba123@yahoo.fr", 2002, 1);
		Employee e = new Employee(1,124, 0, 12, 14);
		//Vendeur v= new Vendeur(0, 0, null, null, 0, 0, 0, 0, 0, 0, 0);
		
		e.CalculerSalaireEmployee();
	}

}
