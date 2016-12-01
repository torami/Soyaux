package com.disp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.disp.dao.*;
import com.disp.publishsubscribe.Producer;

@WebServlet("/Signalement")
public class Demande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/signalement.jsp";
	public static final String IMPORTANCE = "importance";
	public static final String OBJECT = "objet";
	public static final String DESCRIPTION = "description";
	public static final String COMMENT = "commentaire";
	public static final String PLACE = "adresse";
	public static final String ATT_ERREURS  = "erreurs";
	public static final String ATT_RESULTAT = "resultat";


	public Demande() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		/* récupération des champs du formulaire. */
		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();
		String importance = request.getParameter( IMPORTANCE );
		String objet = request.getParameter( OBJECT );
		String description = request.getParameter( DESCRIPTION );
		String commentaire = request.getParameter( COMMENT );
		String adresse = request.getParameter( PLACE );
		if(importance!= null){
			try {
			DemandesBean.create(1, importance, objet, description, commentaire, adresse, 1);
			
			} catch (SQLException e1) {
			e1.printStackTrace();
		}}
		System.out.println(importance);
		System.out.println(objet);
		System.out.println(description);
		System.out.println(commentaire);
		System.out.println(adresse);

		/* Validation du champ Importance. */
		try {
			validationImportance( importance );
		} catch ( Exception e ) {
			erreurs.put( IMPORTANCE, e.getMessage() );
		}
		/* Validation du champ Object. */
		try {
			validationObjet( objet );
		} catch ( Exception e ) {
			erreurs.put( OBJECT, e.getMessage() );
		}
		/* Validation du champ Description. */
		try {
			validationDescritpion( description );
		} catch ( Exception e ) {
			erreurs.put( DESCRIPTION, e.getMessage() );
		}

		/* Validation du champ commentaire. */
		try {
			validationCommentaire( commentaire );
		} catch ( Exception e ) {
			erreurs.put( COMMENT, e.getMessage() );
		}
		/* Validation du champ Place. */
		try {
			validationPlace(adresse);
		} catch ( Exception e ) {
			erreurs.put( PLACE, e.getMessage() );
		}
		/* Initialisation du résultat global de la validation. */
		if ( erreurs.isEmpty() ) {
			resultat = "Votre notification etait pris en compte, nous s'efforsons à résoudre cet incident";
		} else {
			resultat = "Votre réclamation n'a pas était pris en compte";
		}

		/* Stockage du résultat et des messages d'erreur dans l'objet request */
		request.setAttribute( ATT_ERREURS, erreurs );
		request.setAttribute( ATT_RESULTAT, resultat );
		/*Sauvegarder les datas dans la base de donnees  */
//		SignalementDAO.create(1,importance,objet,description,commentaire,adresse,1);

		/* Transmission de la paire d'objets request/response � notre JSP */
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	private void validationImportance( String importance ) throws Exception{
		if ( !importance.isEmpty() ) {
			if (importance.equals("Urgent") || importance.equals("Moyen") ||importance.equals("Faible")) {

			}

			else {
				throw new Exception( "Merci de saisir importance valide" );
			}
		} else {
			throw new Exception( "Merci de saisir une importance." );
		}
	}
	private void validationObjet( String objet) throws Exception{
		if (!objet.isEmpty() ) {
			System.out.println("Objet valide");
		} else {
			throw new Exception("Merci de saisir un objet pour votre demande.");
		}
	}

	private void validationDescritpion( String description ) throws Exception	

	{if (!description.isEmpty() ) {
		System.out.println("description valide");
	} else {
		throw new Exception("Merci de saisir une description pour votre demande.");
	}
	}
	private void validationCommentaire( String commentaire ) throws Exception
	{if (!commentaire.isEmpty()) {
		System.out.println("commentaire valide");
	} else {
		throw new Exception("Merci de saisir un commentaire pour votre demande.");
	}
	}
	private void validationPlace( String adresse ) throws Exception
	{if (!adresse.isEmpty()  ) {
		System.out.println("adresse valide");
	} else {
		throw new Exception("Merci de saisir une adresse pour votre demande.");
	}
}
	


}