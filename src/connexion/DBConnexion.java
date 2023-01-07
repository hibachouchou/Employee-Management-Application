package connexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnexion {
	private static Connection con=null ;
	 static {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch(ClassNotFoundException ex) {
			System.out.println("Problème de chargement du Driver!");
			System.exit(1);
			}

		try {
			 con =DriverManager.getConnection("jdbc:mysql://localhost/projet_java", "root", "");
		}catch(Exception e) {
			System.out.println("the erreur is \n" +e);
		}
	}
	public static Connection getCon() {
		return con;
	}
	public static void setCon(Connection con) {
		DBConnexion.con = con;
	}
}
