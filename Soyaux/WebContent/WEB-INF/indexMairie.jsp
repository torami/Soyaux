<%@ page pageEncoding="UTF-8" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="style.css" />
    </head>
    <body>
           <img src="Berger-Levrault_logo.jpg" alt="Smiley face" height="60" width="120"  margin-left="140"  margin-right="140px">
    <img src="logo_DISP.png" alt="Smiley face" height="60" width="140" align="right">
      <br />
      <br />
      <br />
     <h3 align="center">CECI EST LA PORTAIL DE GESTION DES DEMANDES DES CITOYENS</h3>
      <br />
      <br />
      <br />
	<% String r_unite= (String)(request.getAttribute("monVar"));%>
	<input type="hidden" value="<% out.print(r_unite); %>>"/>
	<form action="index" method="post">
	<center><button class="button" type="submit" name="button1" value="button1">CONSULTER LES DEMANDES</button>
		<button class="button" type="submit" name="button2" value="button2">CONSULTER LES ORDRES DE MISSION</button>
		<button class="button" type="submit" name="button3" value="button2">CREER UN ORDRE DE MISSION</button>
		<button class="button" type="submit" name="button4" value="button3">DECONNEXION</button>
		<button class="button" type="submit" name="button4" value="ABOUT">ABOUT</button></center>
		
	</form>
</body>
</html>