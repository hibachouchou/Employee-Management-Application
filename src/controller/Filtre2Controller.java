package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import connexion.DBConnexion;
import entites.Salarier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Filtre2Controller implements Initializable  {
	@FXML private TableView<Salarier> table ;
	@FXML private TableColumn<Salarier,Integer> mat ;
	@FXML private TableColumn<Salarier,String> nom ;
	@FXML private TableColumn<Salarier,String> mail ;
	@FXML private TableColumn<Salarier,Integer> cat ;
	@FXML private TableColumn<Salarier,Double> sal ;
	public ObservableList<Salarier> data = FXCollections.observableArrayList();
	@FXML
	public void RemplirList(){
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}

}
