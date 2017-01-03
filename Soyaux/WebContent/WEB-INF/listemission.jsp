<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<% java.sql.Connection con =  
 java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/signalement","root","");%>
<%String sql =""; %> 
<% java.sql.PreparedStatement statement = con.prepareStatement( "select * from ordremission"); %> 
<% java.sql.ResultSet rs; %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>Liste des ordres de mission</title>
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
		<form action="missions" method="post">
<div>   <button class="button" type="text" name="button1" value="button1">CONSULTER LES DEMANDES</button>
		<button class="button" type="text" name="button2" value="button2">CONSULTER LES ORDRES DE MISSION</button>
		<button class="button" type="text" name="button3" value="button3">CREER UN ORDRE DE MISSION</button>
		<button class="button" type="text" name="button4" value="button4">DECONNEXION</button>
	</div>
		
	</form>
	<br />
	<br />
	<br />
	<fieldset>
	   <legend>Liste des ordres de mission</legend>
    <% String r_unite= (String)(request.getAttribute("dept"));%>
	<input type="hidden" name="depart" value="<% out.print(r_unite); %>>"/>   
				<br />
	<br />
	<br />
	<table border=1>
				<tr>
					<td><b>Agent</b></td>
					<td><b>Intervenant</b></td>
					<td><b>Date de l'intervention</b></td>
					<td><b>Detail de l'intervention</b></td>
					<td><b>Modifier</b></td>
					
				</tr>
				<% rs = statement.executeQuery();  %>
				<% while (rs.next()) { %>
				<tr>
					<td><%= rs.getString("agent") %></td>
					<td><%= rs.getString("intervenant") %></td>
					<td><%= rs.getString("dateIntervention") %></td>
					<td><%= rs.getString("detailIntervention") %></td>
					<form method="post" action="ordremission">
						<td><input type="submit" value="Modifier/Annuler" name="b1" /></td>
					</form>
				</tr>
				<% } %>
			</table>
			<br />
	</fieldset>
</body>
</html>
<% rs.close(); %> 
<% statement.close(); %> 
<% con.close(); %>