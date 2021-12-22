package eSport.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eSport.model.ConnessioneDB;
import eSport.model.Punteggi;
import eSport.view.HomePageView;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/Homepage")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		ConnessioneDB connessione = new ConnessioneDB();
		String nomeutente=request.getParameter("nome_utente");
		try {
		connessione.connect();
		ResultSet set = connessione.executeQuery("Select * from risultati");
		
		boolean logged=false;
		
		boolean admin = false;
		
		if(nomeutente!=null) {
			
			logged = true;
		
			ResultSet view = connessione.executeQuery("SELECT admin FROM utenti WHERE nome_utente = "+nomeutente);
			
			view.next();
			
			if(view.getInt("admin")==0) {
				admin = true;
			}
		}
		HomePageView.homePageWriter(getServletContext(), writer, Punteggi.getPunteggi(set, connessione), nomeutente, logged, admin);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connessione.close();
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
