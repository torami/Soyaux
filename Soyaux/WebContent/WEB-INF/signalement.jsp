<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Demande</title>
        <link type="text/css" rel="stylesheet" href="style.css" />
    </head>


<body>
    
    <img src="Berger-Levrault_logo.jpg" alt="Smiley face" height="60" width="120"  >
    <img src="logo_DISP.png" alt="Smiley face" height="60" width="140" align="right">
      <br />
      <br />
      <br />

     <h3 align="center">Ce service vous permet de mettre les citoyens en contact avec la mairie afin de pouvoir résoudre les incidents <br> 
     qui sont liés à différentes catégories de problème (E.g : la propreté, l'éclairage, transport)</h3>
      <br />
      <br />
      <br />

<form action="demande" method="post" >
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<div>
			<button class="button" id ="button1" type="text" name="button1" value="Propreté" >Propreté</button>
			<button class="button" id ="button2" type="text" name="button2" value="Eclairage">Eclairage</button>
			<button class="button" id ="button3" type="text" name="button3" value="Sécurité et nuissance" >Sécurité et nuissance</button>
			<button class="button" id ="button4" type="text" name="button4" value="Espaces verts" >Espaces verts</button>
			<button class="button" id ="button5" type="text" name="button5" value="Transport"/>Transport</button>
		</div>
	<br>
      <fieldset>
                <legend>Nouveau signalement</legend>
                <p>Vous pouvez signaler un incident par ce formulaire.</p>
        
                <label for="importance">Importance <span class="requis">*</span></label>
                <input type="text" id="importance" name="importance" value="" size="20" maxlength="60" />
                <span class="erreur">${erreurs['importance']}</span>
                <br />
                
         

                <label for="objet">Objet <span class="requis">*</span></label>
                <input type="text" id="objet" name="objet" value="" size="20" maxlength="20" />
                 <span class="erreur">${erreurs['objet']}</span>
                <br />

                <label for="description">Description <span class="requis">*</span></label>
                <input type="text" id="description" name="description" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['description']}</span>
                
                <br />

                <label for="commentaire">Commentaire</label>
                <input type="text" id="commentaire" name="commentaire" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['commentaire']}</span>
                <br />
                
                <label for="adresse">Adresse de l'incident<span class="requis">*</span></label>
                <input type="text" id="adresse" name="adresse" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['adresse']}</span>
                
                <br />

                <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
                <br/>
                <br/>
 
        </fieldset>
     </form>
    </body>
</html>