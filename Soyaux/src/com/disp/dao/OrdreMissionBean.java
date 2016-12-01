package com.disp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdreMissionBean {
	public static  void create(int traitId, int sig_sig_id, String agent,String intervenant,String dateIntervention,String detailIntervention) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/signalement","root",""); 
			Statement stmt=con.createStatement(); 
			String SQL = "insert into ordremission (traitId, sig_sig_id, agent, intervenant,dateIntervention,detailIntervention) values ("+traitId+",'"+sig_sig_id+"','"+agent+"','"+intervenant+"','"+dateIntervention+"','"+detailIntervention+"')";
			stmt.executeUpdate(SQL);  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return;
	}
	public static void getOrdreMission() {
		String SQL = "select * from ordremission";
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
				int traitId = rs.getInt("traitId");
				String sig_sig_id = rs.getString("sig_sig_id");
				String 	agent = rs.getString("agent");
				String 	intervenant = rs.getString("intervenant");
				String 	dateIntervention = rs.getString("dateIntervention");
				String 	detailIntervention = rs.getString("detailIntervention");

				// print the results
				System.out.format("%s, %s, %s, %s\n", agent, intervenant, dateIntervention, detailIntervention);
			}
			st.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}}
	public static void main(String args[]) throws SQLException{  
		getOrdreMission();
//		updateState(3);
//		Demande dem = getSignalementByID(1);
	
	}  
}
