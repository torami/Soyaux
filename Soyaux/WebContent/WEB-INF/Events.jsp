<%@ page pageEncoding="UTF-8" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
     <meta charset="utf-8" />
       <title>Petit menu sympa</title>
       <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
       <style type="text/css">
			#sous_menu{
			list-style-type:none; /* On enlève la puce */ 
			margin: 0; /* On retire les marges intérieures et extérieures */
			padding:0; 
			width:  20%;  /* J'ai mis une largeur pour ne pas prendre toute la largeur de l'écran */
			border : solid 1px #a3c0d5;  /* On applique des bordures à la balise ul */
			border-bottom: none; /* …et on retire celle du bas */
			}
			#sous_menu li{
			margin: 0; /* On retire les marges intérieures et extérieures */
			padding: 0; 
			border-bottom: 1px solid #a3c0d5;  /* Ici, on affiche une bordure uniquement en bas */
			}
			#sous_menu a{
			text-decoration:none;  /* On enlève le soulignement */
			color:#5d90b5; 
			display:block;   /* C'est ici qu'il faut bien comprendre (j'explique plus bas) */
			padding-left:1.5em;  /* Une marge intérieure gauche juste pour l'esthétique */
			}
			#sous_menu a:hover{
			background-color:#e9eefb; 
			color:#294f79; 
			}
			#sous_menu a:active{
			    background:olive;

			}
		</style>
</head>
<body>
 <ul id="sous_menu">
              <li>
                <a href="login">Propreté</a>
              </li>
              <li>
                <a href="#">Eclairage</a>
              </li>
              <li>
                <a href="#">Sécurité et nuissance</a>
              </li>
              <li>
                <a href="#">Espaces verts</a>
              </li>
              <li>
                <a href="#">Transport</a>
              </li>
            </ul>
</body>
</html>