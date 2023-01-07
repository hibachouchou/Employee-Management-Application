package controller;

import java.net.URL;
import java.util.ResourceBundle;

import entites.Salarier;
import entites.Vendeur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DetailsVendController  implements Initializable  {
	
	@FXML private TextField mat2 ;
	@FXML private TextField nom2 ;
	@FXML private TextField mail2 ;
	@FXML private TextField rec2 ;
	@FXML private TextField cat2 ;
	@FXML private TextField sal2 ;
	@FXML private TextField com ;
	@FXML private TextField vente ;
	@FXML private TextField pct ;

	
	@FXML
	public void getVend(ActionEvent event) {
		int idmat = Integer.parseInt(mat2.getText());
		Vendeur vend  = service.BDService.findById3(idmat);
		nom2.setText(vend.getNom());
		mail2.setText(vend.getEmail());
        rec2.setText(String.valueOf(vend.getRectretement()));
        cat2.setText(String.valueOf(vend.getCategorie()));
        sal2.setText(String.valueOf(vend.getSalaire()));
        com.setText(String.valueOf(vend.getComission()));
        vente.setText(String.valueOf(vend.getVente()));
        pct.setText(String.valueOf(vend.getPourcentage()));
	}
	public void vider() {
		mat2.clear();
		nom2.clear();
		mail2.clear();
		rec2.clear();
		cat2.clear();
		sal2.clear();
		com.clear();
		vente.clear();
		pct.clear();
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
