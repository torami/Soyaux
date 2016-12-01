<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Login</title>
        <link type="text/css" rel="stylesheet" href="style.css" />
    </head>
    <body>
        <img src="Berger-Levrault_logo.jpg" alt="Smiley face" height="60" width="120"  margin-left="140"  margin-right="140px">
    <img src="logo_DISP.png" alt="Smiley face" height="60" width="140" align="right">
      <br />
      <br />
      <br />
     <h3 align="center">Ce service vous permet de mettre les citoyens en contact avec la mairie afin de pouvoir résoudre les incidents </Br> 
     qui sont liés à différentes catégories de problème (E.g : la propreté, l'éclairage, transport)</h3>
      <br />
      <br />
      <br />
        <form method="post" action="login">
            <fieldset>
                <legend>Login</legend>
                <p>Vous pouvez vous inscrire via ce <a HREF="inscri"> formulaire</a></p>
       
                
                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
                <span class="erreur">${erreurs['email']}</span>
                
                <br />
                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <br />
                <input type="submit" value="Login" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>