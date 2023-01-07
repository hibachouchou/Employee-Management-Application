package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable  {
	@FXML
	private AnchorPane rootPane ;
	@FXML 
	public void Loading(ActionEvent event) {
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/vue/Home.fxml"));
			rootPane.getChildren().setAll(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void GestionSal(ActionEvent event) {
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/vue/ListeSalarier.fxml"));
			rootPane.getChildren().setAll(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void GestionEmp(ActionEvent event) {
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/vue/ListeEmployees.fxml"));
			rootPane.getChildren().setAll(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void GestionVend(ActionEvent event) {
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/vue/ListeVendeurs.fxml"));
			rootPane.getChildren().setAll(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Filtrer1(ActionEvent event) {
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/vue/Filtre1.fxml"));
			rootPane.getChildren().setAll(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Filtrer2(ActionEvent event) {
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/vue/Filtre2.fxml"));
			rootPane.getChildren().setAll(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Filtrer3(ActionEvent event) {
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/vue/Filtre3.fxml"));
			rootPane.getChildren().setAll(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Filtrer4(ActionEvent event) {
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/vue/Filtre4.fxml"));
			rootPane.getChildren().setAll(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
