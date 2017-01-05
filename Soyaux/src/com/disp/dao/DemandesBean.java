package com.disp.dao;

import java.sql.*;

import com.disp.bean.Demande;  
public class DemandesBean{  

	
    // Use the MySQL LAST_INSERT_ID()
    // function to do the same thing as getGeneratedKeys()

    public static int id () throws SQLException{
		Connection conn=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/signalement","root","");
    	Statement stmt = null;
    	ResultSet rs = null;
        stmt = conn.createStatement();

    int autoIncKeyFromFunc = -1;
    rs = stmt.executeQuery("SELECT LAST_INSERT_ID() FROM demandes");

    if (rs.next()) {
        autoIncKeyFromFunc = rs.getInt(1);
    } else {
        // throw an exception from here
    }
	return autoIncKeyFromFunc;}
    public static void create( String importance, String object,String description,String comment,String place,int idreporter) throws SQLException {
    	try {
    	
    		  // create a mysql database connection
    	      String myDriver = "org.gjt.mm.mysql.Driver";
    	      String myUrl = "jdbc:mysql://localhost/signalement";
    	      Class.forName(myDriver);
    	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
    	      // the mysql insert statement
    	      String query = " insert into demandes (importance, object, description, comment, place,idreporter,state)"
    	        + " values ( ?, ?, ?, ?, ?, ?, ?)";
    	      // create the mysql insert preparedstatement
    	      PreparedStatement preparedStmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
    
    	      preparedStmt.setString (1, importance);
    	      preparedStmt.setString (2, object);
    	      preparedStmt.setString(3, description);
    	      preparedStmt.setString(4, comment);
    	      preparedStmt.setString(5, place);
    	      preparedStmt.setInt(6, 5);
    	      preparedStmt.setString(7, "NOT SOLVED");
    	      // execute the preparedstatement
    	      preparedStmt.execute();
    	      
    	      conn.close();

    	} catch (ClassNotFoundException e) {
    		System.err.println("HERE");}  
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
	create("Urgent","Lampe","lampe a chang�","RAS","120 boulevard",1);
//		getSignalement();
//	System.out.println("l'id est "+ id());
//		updateState(3);
//		Demande dem = getSignalementByID(1);
	
	}  
}