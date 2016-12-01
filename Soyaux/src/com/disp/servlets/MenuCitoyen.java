package com.disp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuCitoyen
 */
@WebServlet("/MenuCitoyen")
public class MenuCitoyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE   = "/WEB-INF/signalement.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuCitoyen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
		this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
		this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
	}
	protected void traitement(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("button1") != null) {

			
			RequestDispatcher dispatcher = request.getRequestDispatcher("GetDemande");
			dispatcher.forward(request, response);		} 
		else if (request.getParameter("button2") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Signalement");
			dispatcher.forward(request, response);}
		else if (request.getParameter("button3") != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Login");
				dispatcher.forward(request, response);
			System.out.println("2");

		} 
	

	}
}
