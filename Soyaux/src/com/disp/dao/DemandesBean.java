package com.disp.dao;

import java.sql.*;

import com.disp.bean.Demande;  
public class DemandesBean{  


	public static  void create(int id, String importance, String object,String description,String comment,String place,int idreporter) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/signalement","root",""); 
			Statement stmt=con.createStatement(); 
			String SQL = "insert into demandes (id, importance, object, description, comment, place, idreporter,state) values ("+id+",'"+importance+"','"+object+"','"+description+"','"+comment+"','"+place+"',"+idreporter+","+"'NOT SOLVED')";
			stmt.executeUpdate(SQL);  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return;
	}
	public static void updateState(int id) throws SQLException {
		try {		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/signalement","root",""); 
		// create the java mysql update preparedstatement
		String query = "update demandes set state = ? where id = ?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setString   (1, "SOLVED");
		preparedStmt.setInt(2, id); 
		 // execute the java preparedstatement
	      preparedStmt.executeUpdate();
	      
	      con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return;
	}
	public static void getSignalement() {
		String SQL = "select * from demandes";
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
				String importance = rs.getString("importance");
				String object = rs.getString("object");
				String description = rs.getString("description");
				String comment = rs.getString("comment");
				String place = rs.getString("place");
				int idperson = rs.getInt("idreporter");
				String state = rs.getString("state");

				// print the results
				System.out.format("%s, %s, %s, %s, %s, %s\n", id, importance, object, description, comment, place,idperson,state);
			}
			st.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}}
	public static Demande getSignalementByID(int id) {
		Demande dem = new Demande();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/signalement","root",""); 

			// create the java statement
			PreparedStatement statement = con.prepareStatement("SELECT * from demandes WHERE id = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			// iterate through the java resultset
			while (rs.next())
			{
				dem.setImportance(rs.getString("importance"));
				dem.setObject(rs.getString("object"));
				dem.setDescription(rs.getString("description"));
				dem.setComment(rs.getString("comment"));
				dem.setPlace(rs.getString("place"));
				dem.setIdreporter( rs.getInt("idperson"));
				dem.setState( rs.getString("state"));

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
//		create(3,"Urgent","Lampe","lampe a changé","RAS","120 boulevard",1);
		getSignalement();
//		updateState(3);
//		Demande dem = getSignalementByID(1);
	
	}  
}