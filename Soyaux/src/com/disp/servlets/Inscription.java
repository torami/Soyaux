package com.disp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.disp.dao.InscriptionBean;

public class Inscription extends HttpServlet {
	public static final String VUE          = "/WEB-INF/inscription.jsp";
	public static final String CHAMP_EMAIL  = "email";
	public static final String CHAMP_PASS   = "motdepasse";
	public static final String CHAMP_CONF   = "confirmation";
	public static final String CHAMP_NOM    = "nom";
	public static final String ATT_ERREURS  = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		/* Affichage de la page d'inscription */
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();

		/* R�cup�ration des champs du formulaire. */
		String email = request.getParameter( CHAMP_EMAIL );
		String motDePasse = request.getParameter( CHAMP_PASS );
		String confirmation = request.getParameter( CHAMP_CONF );
		String nom = request.getParameter( CHAMP_NOM );
		try {
			InscriptionBean.create(1, nom, email, motDePasse);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
		/* Validation du champ email. */
		try {
			validationEmail( email );
		} catch ( Exception e ) {
			erreurs.put( CHAMP_EMAIL, e.getMessage() );
		}

		/* Validation des champs mot de passe et confirmation. */
		try {
			validationMotsDePasse( motDePasse, confirmation );
		} catch ( Exception e ) {
			erreurs.put( CHAMP_PASS, e.getMessage() );
		}

		/* Validation du champ nom. */
		try {
			validationNom( nom );
		} catch ( Exception e ) {
			erreurs.put( CHAMP_NOM, e.getMessage() );
		}

		/* Initialisation du r�sultat global de la validation. */
		if ( erreurs.isEmpty() ) {
			resultat = "Succes de l'inscription.";
		} else {
			resultat = "Echec l'inscription.";
		}

		/* Stockage du r�sultat et des messages d'erreur dans l'objet request */
		request.setAttribute( ATT_ERREURS, erreurs );
		request.setAttribute( ATT_RESULTAT, resultat );

		/* Transmission de la paire d'objets request/response � notre JSP */
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}



	/**
	 * Valide l'adresse mail saisie.
	 */
	private void validationEmail( String email ) throws Exception {
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				throw new Exception( "Merci de saisir une adresse mail valide." );
			}
		} else {
			throw new Exception( "Merci de saisir une adresse mail." );
		}
	}

	/**
	 * Valide les mots de passe saisis.
	 */
	private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception{
		if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception("Les mots de passe entr�s sont diff�rents, merci de les saisir � nouveau.");
			} else if (motDePasse.trim().length() < 3) {
				throw new Exception("Les mots de passe doivent contenir au moins 3 caract�res.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	/**
	 * Valide le nom d'utilisateur saisi.
	 */
	private void validationNom( String nom ) throws Exception {
		if ( nom != null && nom.trim().length() < 3 ) {
			throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caract�res." );
		}
}}