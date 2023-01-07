package controller;

import java.net.URL;
import java.util.ResourceBundle;

import entites.Employee;
import entites.Salarier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DetailsEmpController  implements Initializable  {
	
	@FXML private TextField mat2 ;
	@FXML private TextField nom2 ;
	@FXML private TextField mail2 ;
	@FXML private TextField rec2 ;
	@FXML private TextField cat2 ;
	@FXML private TextField sal2 ;
	@FXML private TextField nbhsupp ;
	@FXML private TextField phsupp ;
	@FXML private TextField mtt ;

	
	@FXML
	public void getEmp(ActionEvent event) {
		int idmat = Integer.parseInt(mat2.getText());
		Employee emp = service.BDService.findById2(idmat);
		nom2.setText(emp.getNom());
		mail2.setText(emp.getEmail());
        rec2.setText(String.valueOf(emp.getRectretement()));
        cat2.setText(String.valueOf(emp.getCategorie()));
        sal2.setText(String.valueOf(emp.getSalaire()));
        nbhsupp.setText(String.valueOf(emp.getNb_Hsupp()));
        phsupp.setText(String.valueOf(emp.getPHsupp()));
        mtt.setText(String.valueOf(emp.getMantant()));
		
	}
	public void vider() {
		mat2.clear();
		nom2.clear();
		mail2.clear();
		rec2.clear();
		cat2.clear();
		sal2.clear();
		nbhsupp.clear();
		phsupp.clear();
		mtt.clear();
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
