package entites;

public class Employee extends Salarier{
	private int idCteg ;
	private int idEmp ;
	private double mantant ;
	private double nb_Hsupp ;
	private double PHsupp ;
//constructeur
public Employee(int matricule, double salaire, String nom, String email, double rectretement, int categorie,int idEmp,double mantant,double nb_Hsupp,double PHsupp, int idCteg ) {
		super(matricule, salaire, nom, email, rectretement, categorie);
	//  
		this.idEmp=idEmp;
		this.mantant=this.CalculerSalaireEmployee();
		this.nb_Hsupp=nb_Hsupp;
		this.PHsupp=PHsupp;
		this.idCteg=idCteg;
	}

public Employee(int idCteg,int idEmp, double mantant, double nb_Hsupp, double pHsupp) {

	this.idCteg = idCteg;
	this.idEmp = idEmp;
	this.mantant = this.CalculerSalaireEmployee();
	this.nb_Hsupp = nb_Hsupp;
	PHsupp = pHsupp;
}

//getter +setters
public int getIdCteg() {
	return idCteg;
}
public void setIdCteg(int idCteg) {
	this.idCteg = idCteg;
}
public double getMantant() {
	return  this.CalculerSalaireEmployee();
}
public void setMantant(double mantant) {
	this.mantant =mantant;
}


public int getIdEmp() {
	return idEmp;
}
public void setIdEmp(int idEmp) {
	this.idEmp = idEmp;
}

public double getNb_Hsupp() {
	return nb_Hsupp;
}
public void setNb_Hsupp(double nb_Hsupp) {
	this.nb_Hsupp = nb_Hsupp;
}
public double getPHsupp() {
	return PHsupp;
}
public void setPHsupp(double pHsupp) {
	PHsupp = pHsupp;
}

//methode to string
@Override
public String toString() {
	return "Employee [idCteg=" + idCteg + ", idEmp=" + idEmp + ", mantant=" + mantant + ", nb_Hsupp=" + nb_Hsupp
			+ ", PHsupp=" + PHsupp + "]";
}
//calculer salaire employee
public double CalculerSalaireEmployee() {
	double m1 = 0;
	 m1=this.getSalaire()+(this.getNb_Hsupp()*this.getPHsupp());
	return m1;
}

}
