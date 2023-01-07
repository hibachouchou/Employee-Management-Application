package entites;

import javafx.scene.control.Button;

public class Salarier  {
	
	protected int matricule ;
	protected double salaire ;
	protected String nom;
	protected String email ;
	protected double rectretement ;
	protected int Categorie ;



//constructeur
public Salarier(int matricule, double salaire, String nom, String email, double rectretement, int categorie) {
		super();
		this.matricule = matricule;
		this.salaire = this.CalculeSalaire();
		this.nom = nom;
		this.email = email;
		this.rectretement = rectretement;
		this.Categorie = categorie;
	}
public Salarier(int matricule, String nom, String email, int categorie, double salaire) {
	super();
	this.matricule = matricule;
	this.salaire = this.CalculeSalaire();
	this.nom = nom;
	this.email = email;
	this.Categorie = categorie;

	
}
public Salarier() {
	super();
}
//methode to string
@Override
	public String toString() {
		return "Salarier [matricule=" + matricule + ", salaire=" + salaire + ", nom=" + nom + ", email=" + email
				+ ", rectretement=" + rectretement + ", Categorie=" + Categorie + "]";
	}
//getters + stters
public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public double getSalaire() {
		return this.CalculeSalaire();
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getRectretement() {
		return rectretement;
	}
	public void setRectretement(double rectretement) {
		this.rectretement = rectretement;
	}
	public int getCategorie() {
		return Categorie;
	}
	public void setCategorie(int categorie) {
		Categorie = categorie;
	}
	
//Calculer le salaire 	
	public double CalculeSalaire() {
		double salaire =0;
	if(this.getRectretement()>=2005) {
	 salaire=400;}
	else {
		salaire=280;
	}
	return salaire;

	}
	
	



}