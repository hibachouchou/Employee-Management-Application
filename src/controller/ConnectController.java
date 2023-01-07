package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connexion.DBConnexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConnectController implements Initializable {
@FXML  private TextField username ;
@FXML  private PasswordField password ;
@FXML  private Text labelname ;
@FXML  private Text labelpassword ;
@FXML
public void login(ActionEvent event) throws SQLException{
	Connection con =DBConnexion.getCon();
	PreparedStatement stat= null;
	ResultSet rs = null;
	String sql ="SELECT * FROM admin WHERE nom=? and password=? ";
	try {
		stat=con.prepareStatement(sql);
		stat.setString(1,username.getText().toString());
		stat.setString(2,password.getText().toString());
		rs= stat.executeQuery();
		if(rs.next()) {
			System.out.println("Connexion Reuissite");
			Stage stage = new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/vue/Home.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Home Page");
			stage.setScene(scene);
			stage.show();
			
		}
		else { 
			Alert erreur = new Alert(Alert.AlertType.ERROR);
			erreur.setTitle("Alert d'erreur");
			erreur.setContentText("Connexion echouée");
			erreur.show();
		}
	}catch(Exception e) {
		System.out.println("erreur");
	}
	
}

@FXML
public void quitter(ActionEvent event) {
	System.exit(0);
}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
