package com.disp.servlets;

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
import com.disp.dao.EmployeeBean;
import com.disp.dao.SessionBean;



@WebServlet("/LoginSoyau")
public class LoginMairie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/login-mairie.jsp";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_PASS = "motdepasse";
	public static final String ATT_ERREURS  = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	public LoginMairie() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		String resultat = null;
		Map<String, String> erreurs = new HashMap<String, String>();
		RequestDispatcher dispatcher =request.getRequestDispatcher(VUE);

		/* Récupération des champs du formulaire. */
		String email = request.getParameter( CHAMP_EMAIL );
		String motDePasse = request.getParameter( CHAMP_PASS );


		/* Validation du champ email. */
		try {
			System.out.println(EmployeeBean.Authentification(email, motDePasse));

			if(EmployeeBean.Authentification(email, motDePasse)==true){
				
				String departement = EmployeeBean.getDepartementByName(email);
				System.out.println(departement);
			  	request.setAttribute("dept",departement);
			  	/*Déclaration d'une session par la BD */
			  	SessionBean.create(departement);
			  	dispatcher  =request.getRequestDispatcher("/WEB-INF/ListeSignalement.jsp");	
			  	}
			else{
				PrintWriter out = response.getWriter();  
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('ces corrdonnées n'existent pas dans notre base de données');");  
				out.println("</script>");
			}
		} catch ( Exception e ) {
			erreurs.put( CHAMP_EMAIL, e.getMessage() );
		}
	    /* Stockage du résultat et des messages d'erreur dans l'objet request */
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );
		dispatcher.forward(request, response);

	}

}
