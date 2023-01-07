package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import connexion.DBConnexion;
import entites.Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListeEmployees implements Initializable  {
	@FXML private TableView<Employee> table ;
	@FXML private TableColumn<Employee,Integer> mat ;
	@FXML private TableColumn<Employee,Integer> cat ;
	@FXML private TableColumn<Employee,Double> nbH ;
	@FXML private TableColumn<Employee,Double> pct ;
	@FXML private TableColumn<Employee,Double> mt ;
	@FXML private TableColumn<Employee,Double> sal ;
	@FXML private TableColumn<Employee,Double> rec ;
	@FXML private TableColumn<Employee,String> nom ;
	@FXML private TableColumn<Employee,String> mail ;
	public ObservableList<Employee> data = FXCollections.observableArrayList();
	@FXML
	public void RemplirList(){
		try {
		Connection con =DBConnexion.getCon();
		String sql = "SELECT s.categorie,s.matricule, s.nom_Sal,s.email_Sal,s.salaire,s.recrutement,e.id_m,e.idCateg ,e.Hsupp,e.PHsupp,e.mantant from  employee e, salarier s where(( e.idCateg=s.categorie)  and (s.matricule=e.id_m))";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			data.add(new Employee(rs.getInt(2), rs.getDouble(5),rs.getString(3), rs.getString(4), rs.getDouble(6), rs.getInt(1), rs.getInt(7), rs.getDouble(11), rs.getDouble(9), rs.getDouble(10), rs.getInt(8)));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mat.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("idEmp"));
		cat.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("idCteg"));
		nbH.setCellValueFactory(new PropertyValueFactory<Employee,Double>("nb_Hsupp"));
		pct.setCellValueFactory(new PropertyValueFactory<Employee,Double>("PHsupp"));
		mt.setCellValueFactory(new PropertyValueFactory<Employee,Double>("mantant"));
		sal.setCellValueFactory(new PropertyValueFactory<Employee,Double>("salaire"));
		rec.setCellValueFactory(new PropertyValueFactory<Employee,Double>("rectretement"));
		mail.setCellValueFactory(new PropertyValueFactory<Employee,String>("email"));
		nom.setCellValueFactory(new PropertyValueFactory<Employee,String>("nom"));
	
		table.setItems(data);
		
	}
	public void AfficherDetails() {
		try {
			Stage stage = new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/vue/DetailsEmp.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Détails Employee");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
