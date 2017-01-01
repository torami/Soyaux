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

import com.disp.activmq.Consumer;
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
	public static final String liste = "button1";

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
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

		/* Récupération des champs du formulaire. */

		String agent = request.getParameter( Champagent );
		String intervenant = request.getParameter( Champintervenant );
		String dateIntervention = request.getParameter( ChampdateIntervention );
		String detailIntervention = request.getParameter( ChampdetailIntervention );
		String btn = request.getParameter( liste );
		try {
			OrdreMissionBean.create(1,1, agent, intervenant, dateIntervention, detailIntervention);
			DemandesBean.updateState(1);
			try {
				Consumer.consume("Propreté", agent);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
