package com.disp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdreMissionBean {
	public static  void create( int sig_sig_id, String agent,String intervenant,String dateIntervention,String detailIntervention) throws SQLException {
    	try {
        	
  		  // create a mysql database connection
  	      String myDriver = "org.gjt.mm.mysql.Driver";
  	      String myUrl = "jdbc:mysql://localhost/signalement";
  	      Class.forName(myDriver);
  	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      // the mysql insert statement
	      String query = " insert into ordremission (sig_sig_id, agent, intervenant, dateIntervention, detailIntervention)"
	        + " values ( ?, ?, ?, ?, ?)";
	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

	      preparedStmt.setInt (1, sig_sig_id);
	      preparedStmt.setString (2, agent);
	      preparedStmt.setString(3, intervenant);
	      preparedStmt.setString(4, dateIntervention);
	      preparedStmt.setString(5, detailIntervention);
   	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
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
				System.out.format("%s, %s, %s, %s\n",traitId,sig_sig_id, agent, intervenant, dateIntervention, detailIntervention);
			}
			st.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}}
	public static void main(String args[]) throws SQLException{  
		create(1, "dd", "", "", "");
		getOrdreMission();
//		updateState(3);
//		Demande dem = getSignalementByID(1);
	
	}  
}
