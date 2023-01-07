package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connexion.DBConnexion;
import entites.Employee;
import entites.Salarier;
import entites.Vendeur;



public class BDService {
	static Connection con =DBConnexion.getCon();
	
	public static boolean save(Salarier sal) {
		
		try {
			String sql="INSERT INTO salarier VALUES(?,?,?,?,?,?)";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setLong(1, sal.getMatricule());
			ps.setString(2, sal.getNom());
			ps.setString(3, sal.getEmail());
			ps.setDouble(4, sal.getRectretement());
			ps.setLong(5, sal.getCategorie());
			ps.setDouble(6, sal.getSalaire());
			ps.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
		
	}
	
	public static boolean update(Salarier sal) throws SQLException {
		PreparedStatement ps =con.prepareStatement("UPDATE salarier SET nom_Sal=?,email_Sal=?,recrutement=?,categorie=?,salaire=? WHERE matricule= ? ");
		ps.setString(1,sal.getNom());
		ps.setString(2,sal.getEmail());
		ps.setDouble(3, sal.getRectretement());
		ps.setInt(4, sal.getCategorie());
		ps.setDouble(5, sal.getSalaire());
		ps.setInt(6, sal.getMatricule());
        ps.executeUpdate();
		return true;
		
	}
	public static boolean delete(int id) {
		try {
			
			
			PreparedStatement ps =con.prepareStatement("DELETE  FROM salarier WHERE  matricule=? ");
			ps.setInt(1, id);
             ps.executeUpdate();
		

		 
		 }
		catch (SQLException e) {
		System.err.println("Error creating SQL statement: "
		+e.getMessage());
		}
		return true;
	}
	
	public static Salarier findById(int id) {
		try {
				
				
				PreparedStatement ps =con.prepareStatement("SELECT * FROM salarier  WHERE matricule=? ");
				ps.setInt(1, id);
	           ResultSet Rs = ps.executeQuery();
			if ( Rs.next())
				return new Salarier(Rs.getInt(1),Rs.getDouble(6), Rs.getString(2), Rs.getString(3),Rs.getDouble(4),Rs.getInt(5));

			 
			 }
			catch (SQLException e) {
			System.err.println("Error creating SQL statement: "
			+e.getMessage());
			}
		return null;

			
		}
	public static Employee findById2(int id) {
		try {
				
				
				PreparedStatement ps =con.prepareStatement("SELECT s.categorie,s.matricule, s.nom_Sal,s.email_Sal,s.salaire,s.recrutement,e.id_m,e.idCateg ,e.Hsupp,e.PHsupp,e.mantant from  employee e, salarier s where(( e.idCateg=s.categorie)  and (s.matricule=e.id_m) and (e.id_m=?))");
				ps.setInt(1, id);
	           ResultSet rs = ps.executeQuery();
			if ( rs.next())
				return new Employee(rs.getInt(2), rs.getDouble(5),rs.getString(3), rs.getString(4), rs.getDouble(6), rs.getInt(1), rs.getInt(7), rs.getDouble(11), rs.getDouble(9), rs.getDouble(10), rs.getInt(8));

			 
			 }
			catch (SQLException e) {
			System.err.println("Error creating SQL statement: "
			+e.getMessage());
			}
		return null;

			
		}
	public static Vendeur findById3(int id) {
		try {
				
				
				PreparedStatement ps =con.prepareStatement("SELECT s.categorie,s.matricule, s.nom_Sal,s.email_Sal,s.salaire,s.recrutement,v.id_m,v.idCatge,v.commision,v.pct,v.vente  from  vendeur v , salarier s where ((s.matricule=v.id_m) and (s.categorie=v.idCatge)and(v.id_m=?))");
				ps.setInt(1, id);
	           ResultSet rs = ps.executeQuery();
			if ( rs.next())
				return new Vendeur(rs.getInt(2), rs.getDouble(5),rs.getString(3), rs.getString(4), rs.getDouble(6), rs.getInt(1), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getInt(7),rs.getInt(8));

			 
			 }
			catch (SQLException e) {
			System.err.println("Error creating SQL statement: "
			+e.getMessage());
			}
		return null;

			
		}
	
}
