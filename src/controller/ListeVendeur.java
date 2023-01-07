package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import connexion.DBConnexion;
import entites.Vendeur;
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

public class ListeVendeur implements Initializable  {
	@FXML private TableView<Vendeur> table ;
	@FXML private TableColumn<Vendeur,Integer> mat ;
	@FXML private TableColumn<Vendeur,Integer> cat ;
	@FXML private TableColumn<Vendeur,Double> vente ;
	@FXML private TableColumn<Vendeur,Double> pct ;
	@FXML private TableColumn<Vendeur,Double> com ;
	@FXML private TableColumn<Vendeur,Double> sal ;
	@FXML private TableColumn<Vendeur,Double> rec ;
	@FXML private TableColumn<Vendeur,String> nom ;
	@FXML private TableColumn<Vendeur,String> mail ;
	public ObservableList<Vendeur> data = FXCollections.observableArrayList();
	@FXML
	public void RemplirList(){
		try {
		Connection con =DBConnexion.getCon();
		String sql = "SELECT s.categorie,s.matricule, s.nom_Sal,s.email_Sal,s.salaire,s.recrutement,v.id_m,v.idCatge,v.commision,v.pct,v.vente  from  vendeur v , salarier s where ((s.matricule=v.id_m) and (s.categorie=v.idCatge)) ";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			data.add(new Vendeur(rs.getInt(2), rs.getDouble(5),rs.getString(3), rs.getString(4), rs.getDouble(6), rs.getInt(1), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getInt(7),rs.getInt(8)));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mat.setCellValueFactory(new PropertyValueFactory<Vendeur,Integer>("id_Vendeur"));
		cat.setCellValueFactory(new PropertyValueFactory<Vendeur,Integer>("idCteg"));
		vente.setCellValueFactory(new PropertyValueFactory<Vendeur,Double>("vente"));
		pct.setCellValueFactory(new PropertyValueFactory<Vendeur,Double>("pourcentage"));
		com.setCellValueFactory(new PropertyValueFactory<Vendeur,Double>("comission"));
		sal.setCellValueFactory(new PropertyValueFactory<Vendeur,Double>("salaire"));
		rec.setCellValueFactory(new PropertyValueFactory<Vendeur,Double>("rectretement"));
		mail.setCellValueFactory(new PropertyValueFactory<Vendeur,String>("email"));
		nom.setCellValueFactory(new PropertyValueFactory<Vendeur,String>("nom"));
		table.setItems(data);
		
	}
	public void AfficherDetails() {
		try {
			Stage stage = new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/vue/DetailsVend.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Détails Vendeur");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}}
