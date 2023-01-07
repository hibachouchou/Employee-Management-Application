package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class DeleteController  implements Initializable   {
	@FXML private TextField mat2 ;
	
	@FXML
	public void DeleteSal(ActionEvent event) {
		String id = mat2.getText();
		int id1= Integer.parseInt(id);
		boolean status = service.BDService.delete(id1);
		if(status==true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Supprimersalarier");
			alert.setContentText("Salarier bien supprimé");
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setContentText("Salarier non supprimé");
			alert.showAndWait();
		}
	}
	public void vider() {
		mat2.clear();
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
