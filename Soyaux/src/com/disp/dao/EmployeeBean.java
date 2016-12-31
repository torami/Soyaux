package com.disp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.disp.bean.Demande;

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
	public static void main(String args[]) throws SQLException{  

		 System.out.println(getDepartementByName("Rami TORKHANI"));

	
	}  
}
