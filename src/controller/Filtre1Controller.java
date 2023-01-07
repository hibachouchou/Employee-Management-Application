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

public class Filtre1Controller implements Initializable  {
	@FXML private TableView<Salarier> table ;
	@FXML private TableColumn<Salarier,Integer> mat ;
	@FXML private TableColumn<Salarier,String> nom ;
	@FXML private TableColumn<Salarier,String> mail ;
	@FXML private TableColumn<Salarier,Integer> cat ;
	@FXML private TableColumn<Salarier,Double> sal ;
	@FXML private TableColumn<Salarier,Double> rec ;
	public ObservableList<Salarier> data = FXCollections.observableArrayList();
	@FXML
	public void RemplirList(){
		try {
		Connection con =DBConnexion.getCon();
		String sql = "SELECT  matricule ,nom_Sal ,email_Sal ,categorie ,salaire ,recrutement from  salarier order by recrutement";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			data.add(new Salarier(rs.getInt(1),rs.getDouble(5), rs.getString(2), rs.getString(3),rs.getDouble(6),rs.getInt(4)));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mat.setCellValueFactory(new PropertyValueFactory<Salarier,Integer>("matricule"));
		nom.setCellValueFactory(new PropertyValueFactory<Salarier,String>("nom"));
		mail.setCellValueFactory(new PropertyValueFactory<Salarier,String>("email"));
		cat.setCellValueFactory(new PropertyValueFactory<Salarier,Integer>("Categorie"));
		sal.setCellValueFactory(new PropertyValueFactory<Salarier,Double>("salaire"));
		rec.setCellValueFactory(new PropertyValueFactory<Salarier,Double>("rectretement"));
		table.setItems(data);
		
	}

}
