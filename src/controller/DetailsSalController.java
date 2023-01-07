package controller;

import java.net.URL;
import java.util.ResourceBundle;

import entites.Salarier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DetailsSalController  implements Initializable  {
	
	@FXML private TextField mat2 ;
	@FXML private TextField nom2 ;
	@FXML private TextField mail2 ;
	@FXML private TextField rec2 ;
	@FXML private TextField cat2 ;
	@FXML private TextField sal2 ;
	@FXML private Label lblmat2 ;
	@FXML private Label lblnom2 ;
	@FXML private Label lblmail2 ;
	@FXML private Label lblrec2 ;
	@FXML private Label lblca2 ;
	@FXML private Label lblsal2 ;
	
	@FXML
	public void getSal(ActionEvent event) {
		int idmat = Integer.parseInt(mat2.getText());
		Salarier sal = service.BDService.findById(idmat);
		nom2.setText(sal.getNom());
		mail2.setText(sal.getEmail());
        rec2.setText(String.valueOf(sal.getRectretement()));
        cat2.setText(String.valueOf(sal.getCategorie()));
        sal2.setText(String.valueOf(sal.getSalaire()));
		
	}
	public void vider() {
		mat2.clear();
		nom2.clear();
		mail2.clear();
		rec2.clear();
		cat2.clear();
		sal2.clear();
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
