package entites;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class Entreprise {
	
	private String nomE ;
	HashMap<Integer,Salarier> Liste_Emp;
	
	//methode to string
@Override
public String toString() {
	return "Entreprise [nomE=" + nomE + ", Liste_Deps=" + Liste_Emp + "]";
}
//constructeur
public Entreprise(String nomE, HashMap<Integer, Salarier> liste_Emp) {
	super();
	this.nomE = nomE;
	Liste_Emp = new HashMap<>();
}
//getters+stters
public HashMap<Integer, Salarier> getListe_Emp() {
	return Liste_Emp;
}
public void setListe_Deps(HashMap<Integer, Salarier> liste_Emp) {
	Liste_Emp = liste_Emp;
}
public String getNomE() {
	return nomE;
}
public void setNomE(String nomE) {
	this.nomE = nomE;
}

//methodes :
//Remplir la liste d'une entreprise
public void AjoutSalarier (Salarier S){
	Liste_Emp.put(S.getMatricule(), S);
}

//Supprimer un salarier de l'entreprise
public void RetirerSalarier(Salarier S){
	Liste_Emp.remove(S);
}
//Afficher les deatils d'une entreprise
public void AfficheDetailsE(){
	Iterator iter =  Liste_Emp.entrySet().iterator();
	while (iter.hasNext())	{
		Map.Entry mapentry = (Map.Entry) iter.next();
		System.out.println(mapentry.getValue());
		System.out.println(mapentry.getKey());
}
	
}




}
