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
     <h3 align="center">Ce service vous permet de mettre les citoyens en contact avec la mairie afin de pouvoir résoudre les incidents </Br> 
     qui sont liés à différentes catégories de problème (E.g : la propreté, l'éclairage, transport)</h3>
      <br />
      <br />
      <br />
        <form method="post" action="inscri">
	    <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="" size="20" maxlength="60" />
                <span class="erreur">${erreurs['email']}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['motdepasse']}</span>
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['confirmation']}</span>
                <br />

                <label for="nom">NOM et Prénom<span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['nom']}</span>
                <br />

                
                  <label for="adresse">Adresse<span class="requis">*</span></label>
                <input type="text" id="adresse" name="adresse" value="" size="20" maxlength="50" />
                <span class="erreur">${erreurs['prenom']}</span>
                <br />

   				 <label for="tel">Tel</label>
                <input type="text" id="tel" name="tel" value="" size="20" maxlength="8" />
                <span class="erreur">${erreurs['tel']}</span>
                <br />
                
                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
                
            </fieldset>
        </form>
    </body>
</html>