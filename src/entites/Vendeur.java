package entites;

public class Vendeur  extends Salarier {
private int idCteg ;
private double comission ;
private double pourcentage ;
private double vente ;
private int id_Vendeur ;
// constructeur 
public Vendeur(int matricule, double salaire, String nom, String email, double rectretement, int categorie,double comission,double pourcentage,double vente,int id_Vendeur,int idCteg) {
		super(matricule, salaire, nom, email, rectretement, categorie);
		// 
		this.comission=this.CalculerCommissionVendeur();
		this.pourcentage=pourcentage;
		this.vente=vente;
		this.id_Vendeur=id_Vendeur;
		this.idCteg=idCteg;
	}
public Vendeur(double comission,double pourcentage,double vente,int id_Vendeur,int idCteg) {
	// 
	this.comission=this.CalculerCommissionVendeur();
	this.pourcentage=pourcentage;
	this.vente=vente;
	this.id_Vendeur=id_Vendeur;
	this.idCteg=idCteg;
}
//getter+setters

public int getIdCteg() {
	return idCteg;
}

public void setIdCteg(int idCteg) {
	this.idCteg = idCteg;
}

public int getId_Vendeur() {
	return id_Vendeur;
}
public void setId_Vendeur(int id_Vendeur) {
	this.id_Vendeur = id_Vendeur;
}

public double getComission() {
	return this.CalculerCommissionVendeur();
}
public void setComission(double comission) {
	this.comission = comission;
}
public double getPourcentage() {
	return pourcentage;
}
public void setPourcentage(double pourcentage) {
	this.pourcentage = pourcentage;
}
public double getVente() {
	return vente;
}
public void setVente(double vente) {
	this.vente = vente;
}
//methode tostring
@Override
public String toString() {
	return "Vendeur [idCteg=" + idCteg + ", comission=" + comission + ", pourcentage=" + pourcentage + ", vente="
			+ vente + ", id_Vendeur=" + id_Vendeur + "]";
}

//calculer commission vendeur
public double CalculerCommissionVendeur() {
	double com = 0;
     com= this.getPourcentage()*this.getVente();
	return com;
	
}
	

}
