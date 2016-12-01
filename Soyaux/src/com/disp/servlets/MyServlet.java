package com.disp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE   = "/WEB-INF/indexMairie.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
		this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		traitement(request, response);
		this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);


	}
	protected void traitement(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("button1") != null) {

			
			RequestDispatcher dispatcher = request.getRequestDispatcher("GetDemande");
			dispatcher.forward(request, response);		} 
		else if (request.getParameter("button2") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("OrdreMission");
			dispatcher.forward(request, response);}
		else if (request.getParameter("button3") != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("OrdreMission");
				dispatcher.forward(request, response);
			System.out.println("2");

		} 
		else if (request.getParameter("button4") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("LoginSoyau");
			dispatcher.forward(request, response);
		System.out.println("2");

	}
	
		// Etape 3 : envoyer la Réponse à l'utilisateur

	}
}
