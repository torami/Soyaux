package com.disp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	
}
