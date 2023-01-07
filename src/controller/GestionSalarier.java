package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import connexion.DBConnexion;
import entites.Salarier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GestionSalarier implements Initializable {
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
	String sql = "SELECT  matricule ,nom_Sal ,email_Sal ,categorie ,salaire ,recrutement from  salarier ";
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

	public void AjoutSal() {
		try {
			Stage stage = new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/vue/AjoutSal.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Form d'ajout d'un salarier");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	


	public void Updatep() {
		try {
			Stage stage2 = new Stage();
			Parent root2 =FXMLLoader.load(getClass().getResource("/vue/UpdateSal.fxml"));
			Scene scene2 = new Scene(root2);
			stage2.setTitle("Form de modification d'un salarier");
			stage2.setScene(scene2);
			stage2.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void Supp() {
		try {
			Stage stage = new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/vue/DeleteSal.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Form de supprission d'un salarier");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void AfficheDetails() {
		try {
			Stage stage = new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/vue/Details.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Détails Salarier");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Exportation() throws IOException {
		File list = new File("listsal.txt");
		FileWriter fw = new FileWriter(list,true);
		PrintWriter pw  = new PrintWriter(fw);
		pw.print(table);
		pw.close();
		Scanner scan = new Scanner(list);
		while(scan.hasNext()) {
			String text = scan.nextLine();
			System.out.println(text);	
		}
	
	
	}
	
}
