package com.disp.clients;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.disp.dao.InscriptionBean;

import sun.rmi.server.Dispatcher;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/login.jsp";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_PASS = "motdepasse";
	public static final String ATT_ERREURS  = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	public Login() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		String resultat = null;
		Map<String, String> erreurs = new HashMap<String, String>();
		/* R�cup�ration des champs du formulaire. */
		String email = request.getParameter( CHAMP_EMAIL );
		String motDePasse = request.getParameter( CHAMP_PASS );


		/* Validation du champ email. */
		try {
			validationEmail( email );
			if(InscriptionBean.Authentification(email, motDePasse)){
			       response.sendRedirect("demande");   } 
			else {
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('ces corrdonnées n'existent pas dans notre base de données');");  
				out.println("</script>");
				response.sendRedirect("login");
			}
		} catch ( Exception e ) {
			erreurs.put( CHAMP_EMAIL, e.getMessage() );
		}
	    /* Stockage du résultat et des messages d'erreur dans l'objet request */
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );


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
	private void validationMotsDePasse( String motDePasse ) throws Exception{}
}