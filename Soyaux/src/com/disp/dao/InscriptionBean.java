package com.disp.dao;

import java.sql.*;
import com.disp.bean.Inscription;  
public class InscriptionBean{  


	public static  void create(int id, String name, String email,String password) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/signalement","root",""); 
			Statement stmt=con.createStatement(); 
			String SQL = "insert into citoyens (id, name, email, password) values ("+id+",'"+name+"','"+email+"','"+password+"')";
			stmt.executeUpdate(SQL);  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return;
	}
	public static void getSignalement() {
		String SQL = "select * from citoyens";
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
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				// print the results
				System.out.format("%s, %s, %s, %s\n", id, name, email, password);
			}
			st.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}}
	public static boolean Authentification(String email,String Pass) {
		String SQL = "select email,password from citoyens";
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
				if(rs.getString("email").equals(email) && rs.getString("password").equals(Pass)){
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

	public static Inscription getUserByEmail(String email) {
		Inscription dem = new Inscription();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/signalement","root",""); 

			// create the java statement
			PreparedStatement statement = con.prepareStatement("SELECT * from inscription WHERE email = ?");
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			// iterate through the java resultset
			while (rs.next())
			{
				dem.setId(rs.getInt("id"));
				dem.setName(rs.getString("name"));
				dem.setEmail(rs.getString("email"));
				dem.setPassword(rs.getString("password"));

				// print the results
					return dem;}
			statement.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return null;}
	public static void main(String args[]) throws SQLException{  
//		create(1, "Tester", "tester@test.test", "password");
//		getSignalement();
		 System.out.println(Authentification("tester@test.test","password"));
//		updateState(3);
//		Demande dem = getSignalementByID(1);
	
	}  
}