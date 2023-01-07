package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entites.Salarier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class UpdateController  implements Initializable   {
	
	@FXML private TextField mat1 ;
	@FXML private TextField nom1 ;
	@FXML private TextField mail1 ;
	@FXML private TextField rec1 ;
	@FXML private TextField cat1 ;
	@FXML private TextField sal1 ;
	@FXML private Label lblmat1 ;
	@FXML private Label lblnom1 ;
	@FXML private Label lblmail1 ;
	@FXML private Label lblrec1 ;
	@FXML private Label lblcat1 ;
	@FXML private Label lblsal1 ;
	
	@FXML
	public void getSal(ActionEvent event) {
		int idmat = Integer.parseInt(mat1.getText());
		Salarier sal = service.BDService.findById(idmat);
		nom1.setText(sal.getNom());
		mail1.setText(sal.getEmail());
        rec1.setText(String.valueOf(sal.getRectretement()));
        cat1.setText(String.valueOf(sal.getCategorie()));
        sal1.setText(String.valueOf(sal.getSalaire()));
		
	}
	
	@FXML
	public void UpdateSal(ActionEvent event) throws SQLException {
		String id = mat1.getText();
		int id1= Integer.parseInt(id);
		String name = nom1.getText();
		String email = mail1.getText().toString();
		int categ =Integer.parseInt(cat1.getText());
		double recrute = Double.parseDouble(rec1.getText());
		double salaire = Double.parseDouble(sal1.getText());
		Salarier salarier = new Salarier();
		salarier.setMatricule(id1);
		salarier.setNom(name);
		salarier.setEmail(email);
		salarier.setRectretement(recrute);
		salarier.setSalaire(salaire);
		salarier.setCategorie(categ);
		boolean status = service.BDService.update(salarier);
		if(status==true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Modifier salarier");
			alert.setContentText("Salarier bien modifié");
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setContentText("Salarier non modifié");
			alert.showAndWait();
		}
	}
	public void vider() {
		mat1.clear();
		nom1.clear();
		mail1.clear();
		rec1.clear();
		cat1.clear();
		sal1.clear();
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
