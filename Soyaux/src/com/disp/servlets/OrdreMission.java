package com.disp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.jms.JMSException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.disp.constants.Const;

import com.disp.dao.SessionBean;
import com.disp.event.EventManager;

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
	public static final String indice = "SignalementID";

	Const cs = new Const();
	com.disp.bean.OrdreDeMission mission = new com.disp.bean.OrdreDeMission();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdreMission() {
        super();
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
		

		/* Récupération des champs du formulaire. */

		String agent = request.getParameter( Champagent );
		String intervenant = request.getParameter( Champintervenant );
		String dateIntervention = request.getParameter( ChampdateIntervention );
		String detailIntervention = request.getParameter( ChampdetailIntervention );
		String ind = request.getParameter(indice); 
		System.out.println("ATTTTTTTRI"+ind);

		String cons_d = request.getParameter(cs.CONSULTER_D  ); 
		String cons_o = request.getParameter( cs.CONSULTER_O ); 
		String create_o = request.getParameter( cs.CREER_O ); 
		String deconnexion = request.getParameter( cs.DECONNEXION ); 
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/ListeSignalement.jsp");
		
		
		if(InputState(agent, intervenant, dateIntervention, detailIntervention)){
			mission.setAgent(agent);
			mission.setIntervenant(intervenant);
			mission.setDateIntervention(dateIntervention);
			mission.setDetailIntervention(detailIntervention);
		}
	
		
		if(agent!=null && !agent.equals("")){
			try {
				EventManager.ConsumeEvent(SessionBean.getDept(), mission,Integer.parseInt(ind));
			} catch (JMSException | SQLException e) {
				e.printStackTrace();
			}
		}

		
		if (cons_d !=null) {
				
				request.setAttribute("dept",SessionBean.getDept());
				dispatcher = request.getRequestDispatcher("/WEB-INF/ListeSignalement.jsp");
		}
		if (cons_o !=null && !cons_o.equals("")) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/listemission.jsp");

		}
		if (create_o != null){
			dispatcher = request.getRequestDispatcher("/WEB-INF/ordremission.jsp");
		}
		
		if (deconnexion != null) {
			SessionBean.InitSession();
			dispatcher = request.getRequestDispatcher("/WEB-INF/login-mairie.jsp");
		}

		dispatcher.forward(request, response);

	}
	private boolean InputState( String agent, String intervenant,String dateIntervention,String detailIntervention) {

		if (agent.isEmpty() && intervenant.isEmpty() && dateIntervention.isEmpty() && detailIntervention.isEmpty() ) 
		{return false;
		}
		else
			return true;

	}
}

