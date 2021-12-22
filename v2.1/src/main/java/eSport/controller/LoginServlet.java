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
import eSport.model.Utente;
import eSport.view.Layout;
import eSport.view.LoginView;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		LoginView.loginWriter(getServletContext(), writer);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();

		ConnessioneDB connessione = new ConnessioneDB();
		
		ResultSet set;
		try { 
			connessione.connect();
			
			set = connessione.executeQuery("select nome_utente,password from utenti where nome_utente = "+request.getParameter("nome_utente"));
			
			set.next();
			
			Utente utente = new Utente(request.getParameter("nome_utente"),request.getParameter("password"));
			
			if(utente.getPassword().equals(request.getParameter("password"))) {
				String reload = "<meta http-equiv=\"refresh\" content=\"5;url=Homepage\" /><p id=\"countdown\" style=\"color:white;\" target=\"_self\">Accesso effettuato correttamente!<br><p>Verrai reindirizzato tra 5 secondi, altrimenti <a href=\"HomePage\"><p>clicca qui!</p></a></p>\r\n";
				Layout.doLayout(getServletContext(), writer, reload); 
			}
		} catch(SQLException e) {
			
			String reload = "<meta http-equiv=\"refresh\" content=\"5;url=Login\" /><p id=\"countdown\" style=\"color:white;\" target=\"_self\">Nome utente inserito non valido!<br><p>Verrai reindirizzato tra 5 secondi, altrimenti <a href=\"Login\"><p>clicca qui!</p></a></p>\r\n";
			Layout.doLayout(getServletContext(), writer, reload); 		
			}
		connessione.close();	
		}

}
