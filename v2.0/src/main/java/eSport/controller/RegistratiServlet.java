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
		
		try {
		
			connessione.executeQuery("INSERT INTO `utenti` (`id`, `nome_utente`, `password`, `admin`) "
					+ "VALUES (NULL, '"+(String)request.getAttribute("nome_utente")+"', '"+(String)request.getAttribute("password")+"', '0');");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
