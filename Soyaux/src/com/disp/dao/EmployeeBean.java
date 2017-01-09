package com.disp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeBean {
	public static  void create(int empId, String name, String jobTitle,String department, String password) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/signalement","root",""); 
			Statement stmt=con.createStatement(); 
			String SQL = "insert into employees (empId, name, jobTitle, department, password) values ("+empId+",'"+name+"','"+jobTitle+"','"+department+"','"+password+"')";
			stmt.executeUpdate(SQL);  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return;
	}
	public static void updateDepartement(String department, int idemp) throws SQLException {
		try {		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/signalement","root",""); 
		// create the java mysql update preparedstatement
		String query = "update employees set department = ? where empId = ?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setString   (1, department);
		preparedStmt.setInt(2, idemp); 
		 // execute the java preparedstatement
	      preparedStmt.executeUpdate();
	      
	      con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return;
	}
	public static String getDepartementByName(String name) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/signalement","root",""); 

			// create the java statement
			PreparedStatement statement = con.prepareStatement("SELECT department from employees WHERE name = ?");
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
			    return rs.getString("department");
			}
			   rs.close ();
			}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return null;}
	public static boolean Authentification(String name,String Pass) {
		String SQL = "select name,password from employees";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/signalement","root",""); 

			// create the java statement
			Statement st = con.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(SQL);
			// iterate through the java resultset
			while (rs.next())
			{
				if(rs.getString("name").equals(name) && rs.getString("password").equals(Pass)){
					return true;
				}
		
			}
			
			st.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	return false;	
	}

	public static void main(String args[]) throws SQLException{  
		create(1, "Bruno TRAVERSON", "Agent", "Propreté", "password");
		create(2, "Jannik Laval", "Agent", "Securité", "password");
		create(3, "Nejib Moalla", "Agent", "Eclairage", "password");

//		 System.out.println(getDepartementByName("Rami TORKHANI"));
//		 System.out.println(Authentification("Rami ", "Helios"));
	}  
}
