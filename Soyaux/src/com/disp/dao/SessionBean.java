package com.disp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Replace the session parameter 
 * 		To be changed in next version
 *  * @author Dev
 *
 */

public class SessionBean {
	public static  void create( String label) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/signalement","root",""); 
			Statement stmt=con.createStatement(); 
			String SQL = "insert into session (label) values ('"+label+"')";
			stmt.executeUpdate(SQL);  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return;
	}
	
	public static void InitSession() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/signalement","root",""); 
			// create the java mysql update preparedstatement
			String query = "delete from session";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			 // execute the java preparedstatement
		     preparedStmt.executeUpdate();
		     con.close();
		}		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ;
	}
	public static String getDept() {
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/signalement","root",""); 

			// create the java statement
			PreparedStatement statement = con.prepareStatement("SELECT * from session");
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
			    return rs.getString("label");
			}
			   rs.close ();
			}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return null;
	
	}
	public static void main(String args[]) throws SQLException{  
		create("Propreté");
//		InitSession();
		System.out.println(getDept());
	}
}
