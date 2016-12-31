package com.disp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.disp.dao.DemandesBean;
import com.disp.dao.OrdreMissionBean;

/**
 * Servlet implementation class OrdreMission
 */
@WebServlet("/OrdreMission")
public class OrdreMission extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/ordremission.jsp";
	public static final String Champagent = "agent";
	public static final String Champintervenant = "intervenant";
	public static final String ChampdateIntervention = "dateIntervention";
	public static final String ChampdetailIntervention = "detailIntervention";

	public static final String ATT_ERREURS  = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdreMission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

		/* R�cup�ration des champs du formulaire. */

		String agent = request.getParameter( Champagent );
		String intervenant = request.getParameter( Champintervenant );
		String dateIntervention = request.getParameter( ChampdateIntervention );
		String detailIntervention = request.getParameter( ChampdetailIntervention );
		try {
			OrdreMissionBean.create(1,1, agent, intervenant, dateIntervention, detailIntervention);
			DemandesBean.updateState(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* Initialisation du r�sultat global de la validation. */
		if ( erreurs.isEmpty() ) {
			resultat = "Succès de l'émission de l'orde de mission";
		} else {
			resultat = " echec d'ajout de l'ordre de mission";
		}
		/* Stockage du résultat et des messages d'erreur dans l'objet request */
		request.setAttribute( ATT_ERREURS, erreurs );
		request.setAttribute( ATT_RESULTAT, resultat );

	}

}
