package com.disp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.disp.constants.Const;

/**
 * Servlet implementation class GetOrdreMission
 */
@WebServlet("/GetOrdreMission")
public class GetOrdreMission extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE   = "/WEB-INF/listemission.jsp";
	Const cs = new Const();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrdreMission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

	}

}
