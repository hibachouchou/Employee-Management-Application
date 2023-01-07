package controller;

import java.net.URL;
import java.util.ResourceBundle;

import entites.Salarier;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AjoutSalController implements Initializable  {

	@FXML private TextField mat ;
	@FXML private TextField nom ;
	@FXML private TextField mail ;
	@FXML private TextField recrut ;
	@FXML private TextField cat ;
	@FXML private TextField sal ;
	@FXML private Label lblmat ;
	@FXML private Label lblnom ;
	@FXML private Label lblmail ;
	@FXML private Label lblrecrut ;
	@FXML private Label lblcat ;
	@FXML private Label lblsal ;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
	}
	
	public void insertdata(ActionEvent event) {
		int idmat = Integer.parseInt(mat.getText());
		String name = nom.getText();
		String email = mail.getText().toString();
		int categ =Integer.parseInt(cat.getText());
		double recrute = Double.parseDouble(recrut.getText());
		double salaire = Double.parseDouble(sal.getText());
		Salarier salarier = new Salarier();
		salarier.setMatricule(idmat);
		salarier.setNom(name);
		salarier.setEmail(email);
		salarier.setRectretement(recrute);
		salarier.setSalaire(salaire);
		salarier.setCategorie(categ);
		
		boolean status = service.BDService.save(salarier);
		if(status==true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Ajouter salarier");
			alert.setContentText("Salarier bien ajouté");
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setContentText("Salarier non ajouté");
			alert.showAndWait();
		}
	}
public void vider() {
	mat.clear();
	nom.clear();
	mail.clear();
	recrut.clear();
	cat.clear();
	sal.clear();
}
}
