package eSport.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eSport.model.ConnessioneDB;
import eSport.view.Layout;
import eSport.view.RegistratiView;

/**
 * Servlet implementation class RegistratiServlet
 */
@WebServlet("/Registrati")
public class RegistratiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
			RegistratiView.registratiWriter(getServletContext(), writer);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		ConnessioneDB connessione = new ConnessioneDB();
		boolean done=true;
		try {
			connessione.connect();
						
			done = connessione.executeUpdate("INSERT INTO utenti (nome_utente, password) " + "VALUES ('"
					+ request.getParameter("nome_utente") + "', " + "'" + request.getParameter("password")+ "');");

		} catch (SQLException e) {
			System.out.println(done);
			if(done) {
			String refresh = " <meta http-equiv=\"refresh\" content=\"5;url=Registrati\" />"
					+ "<p id=\"countdown\" style=\"color:white;\" target=\"_self\">Nome utente inserito non valido!<br><p>Verrai reindirizzato tra 5 secondi, altrimenti <a href=\"Registrati\"><p>clicca qui!</p></a></p>\r\n";
					
			Layout.doLayout(getServletContext(), writer, refresh,null,false,false);
			e.printStackTrace();
			}
		}
		if(!done) {
		String reload = " <meta http-equiv=\"refresh\" content=\"5;url=Homepage?nome_utente="+request.getParameter("nome_utente")+"\" />"
				+ "<p style=\"color:white;\">Registrazione avvenuta con successo!</p>";
		Layout.doLayout(getServletContext(), writer, reload,request.getParameter("nome_utente"),true,false);
		connessione.close();
		}
		
	}
}
