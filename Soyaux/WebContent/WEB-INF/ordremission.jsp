<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>OrdreDeMission</title>
        <link type="text/css" rel="stylesheet" href="style2.css" />
    </head>
    <body>
    
    <img src="Berger-Levrault_logo.jpg" alt="Smiley face" height="60" width="120"  margin-left="140"  margin-right="140px">
    <img src="logo_DISP.png" alt="Smiley face" height="60" width="140" align="right">
      <br />
      <br />
      <br />
     <h3 align="center">Ce service vous permet de traiter les demandes de citoyens en créant un ordre de mission et en lui attribuant un intervenant</h3>
      <br />
      <br />
      <br />
  <form method="post" action="liste">
  <div>   <button class="button" type="submit" name="button1" value="button1">CONSULTER LES DEMANDES</button>
		<button class="button" type="submit" name="button2" value="button2">CONSULTER LES ORDRES DE MISSION</button>
		<button class="button" type="submit" name="button3" value="button3">CREER UN ORDRE DE MISSION</button>
		<button class="button" type="submit" name="button4" value="button4">DECONNEXION</button>
	</div>
		<br /> <br /> <br />
      
            <fieldset>
                <legend>Nouveau ordre de mission</legend>
                <p>Vous pouvez déclarer un ordre de mission par ce formulaire.</p>

                <label for="agent">agent <span class="requis">*</span></label>
                <input type="text" id="agent" name="agent" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['agent']}</span>
                
                <br />

                <label for="intervenant">intervenant</label>
                <input type="text" id="intervenant" name="intervenant" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['intervenant']}</span>
                <br />
                
                <label for="dateIntervention">dateIntervention<span class="requis">*</span></label>
                <input type="text" id="dateIntervention" name="dateIntervention" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['dateIntervention']}</span>
                         <br />
              <label for="detailIntervention">detailIntervention<span class="requis">*</span></label>
                <input type="text" id="detailIntervention" name="detailIntervention" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['detailIntervention']}</span>
                <br />
                <input type="submit" value="Envoyer" class="sansLabel" />
                <br />
                <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
            </fieldset>
        </form>
    </body>
</html>