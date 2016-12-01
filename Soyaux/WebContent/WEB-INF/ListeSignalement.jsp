<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<% java.sql.Connection con =  
 java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/signalement","root","");%> 
<% java.sql.Statement statement = con.createStatement(); %> 
<% java.sql.ResultSet rs; %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>Liste Demandes</title>
<link type="text/css" rel="stylesheet" href="style2.css" />
</head>
<body>
	<img src="Berger-Levrault_logo.jpg" alt="Smiley face" height="60"
		width="120" margin-left="140" margin-right="140px">
	<img src="logo_DISP.png" alt="Smiley face" height="60" width="140"
		align="right">
	<br />
	<br />
	<br />
	<h3 align="center">
		Ceci est votre portail de gestion des demandes des citoyens ce service
		vous permet de répondre aux demande des citoyens qui sont mis en
		contact avec la mairie <br> afin de pouvoir résoudre les incidents  qui
		sont liés à différentes catégories de problème (E.g : la propreté,
		l'éclairage, transport)
	</h3>
	&nbsp&nbsp&nbsp
		<form action="index" method="post">
	<div><button class="button" type="submit" name="button1" value="button1">CONSULTER LES DEMANDES</button>
		<button class="button" type="submit" name="button2" value="button2">CONSULTER LES ORDRES DE MISSION</button>
		<button class="button" type="submit" name="button3" value="button2">CREER UN ORDRE DE MISSION</button>
		<button class="button" type="submit" name="button4" value="button3">DECONNEXION</button>
	</div>
		
	</form>
	<br />
	<br />
	<br />
	<fieldset>
                <legend>Liste signalement</legend>
        
	<form method="post" action="ordremission">
				<br />
	<br />
	<br />
			<table border=1>
				<tr>
					<td><b>Importance</b></td>
					<td><b>Objet</b></td>
					<td><b>Description</b></td>
					<td><b>Commentaire</b></td>
					<td><b>Adresse</b></td>
					<td><b>Demandeur</b></td>
					<td><b>Etat</b></td>
					<td><b>Résoudre</b></td>
					
					
				</tr>
				<% rs = statement.executeQuery("SELECT * FROM demandes");  %>
				<% while (rs.next()) { %>
				<tr>
					<td><%= rs.getString("importance") %></td>
					<td><%= rs.getString("object") %></td>
					<td><%= rs.getString("description") %></td>
					<td><%= rs.getString("comment") %></td>
					<td><%= rs.getString("place") %></td>
					<td><%= rs.getInt("idreporter") %></td>
					<td><%= rs.getString("state") %></td>
					<td><input type="submit" value="Traiter" name="b1" /></td>
					
				
				</tr>
				<% } %>
			</table>
			<br />
	</form></fieldset>


</body>
</html>
<% rs.close(); %> 
<% statement.close(); %> 
<% con.close(); %>