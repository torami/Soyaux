package com.disp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.disp.constants.Const;
import com.disp.dao.SessionBean;

/**
 * Servlet implementation class OrdreMission
 */
@WebServlet("/GetDemande")
public class GetDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE   = "/WEB-INF/ListeSignalement.jsp";
	public static final String CHAMP_STATE  = "state";
	public static final String dept = "depart";
	Const cs = new Const();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDemande() {
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
		String cons_d = request.getParameter(cs.CONSULTER_D  ); 
		String cons_o = request.getParameter( cs.CONSULTER_O ); 
		String create_o = request.getParameter( cs.CREER_O ); 
		String deconnexion = request.getParameter( cs.DECONNEXION ); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ListeSignalement.jsp"); ;
		if (cons_d !=null) {
				
				request.setAttribute("dept",SessionBean.getDept());
				dispatcher = request.getRequestDispatcher("/WEB-INF/ListeSignalement.jsp");
		}
		if (cons_o !=null) {
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

}
