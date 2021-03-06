package com.disp.clients;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.disp.constants.*;
import com.disp.event.EventManager;

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
	Const cs = new Const();
	com.disp.bean.Demande sig = new com.disp.bean.Demande();
	public Demande() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		/* récupération des champs du formulaire. */
	

		String importance = request.getParameter( IMPORTANCE );
		String objet = request.getParameter( OBJECT );
		String description = request.getParameter( DESCRIPTION );
		String commentaire = request.getParameter( COMMENT );
		String adresse = request.getParameter( PLACE );
		/* récupération de l'evenement*/
		String event_proprete = request.getParameter( cs.EVENT_PROPRETE ); 
		String event_eclairage = request.getParameter( cs.EVENT_Eclairage ); 
		String event_sec = request.getParameter( cs.EVENT_Sécurité ); 
		String event_ev = request.getParameter( cs.EVENT_EspacesVerts ); 
		String event_trans = request.getParameter( cs.EVENT_Transport); 
		
		/*s'assurer de la complétude des champs*/
		boolean etat = InputState(importance, objet, description, commentaire, adresse);
		if(etat == false){
			sig.setComment(commentaire);
			sig.setDescription(description);
			sig.setImportance(importance);
			sig.setPlace(adresse);
			sig.setObject(objet);
			sig.setIdreporter(1);
		}
		
		/* Récupération du choix de l'évenement*/
		String event = cs.EventType(event_eclairage, event_proprete, event_ev, event_sec, event_trans);

		/*Call Event Manager*/
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  

			if( etat == false){
				try {
					EventManager.ProduceEvent(sig, event,"");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//servlet code
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Votre Signalement a été pris en compte vous recevez un email lors du traitement de ce dernier');");  
				out.println("</script>");
			}
			else{
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Signalement non pertinent');");  
				out.println("</script>");
				response.sendRedirect("/Soyaux/demande");}
			}
		
		

	


	private boolean InputState( String importance, String objet,String description,String commentaire, String adresse) {
		
		if (description.isEmpty() && importance.isEmpty() && objet.isEmpty() && commentaire.isEmpty() && adresse.isEmpty()) 
			{return true;
		}
		else
			return false;
		
	}
	


}