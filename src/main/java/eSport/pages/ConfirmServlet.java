package eSport.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eSport.db.Utente;
import eSport.db.Utenti;
import eSport.html.HTMLStringPartLoader;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/Conferma")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter printWriter = response.getWriter();
		String nome_utente = request.getParameter("nome_utente");
		String password = request.getParameter("password");
		
		printWriter.write(HTMLStringPartLoader.loadHTMLStringFromFile(getServletContext(), "files/header.html"));
		
		Utente utente = new Utente(nome_utente, password);
		if (Utenti.Create(utente)) {
			String conferma= HTMLStringPartLoader.loadHTMLStringFromFile(getServletContext(), "files/ConfermaReg.html");
			conferma = conferma.replace("$nome_utente$", nome_utente).replace("$password$", password);
			printWriter.write(conferma);
		} else {
			
			String failure = HTMLStringPartLoader.loadHTMLStringFromFile(getServletContext(), "files/failure.html");
			printWriter.write(failure);
		}
		
		
		printWriter.write(HTMLStringPartLoader.loadHTMLStringFromFile(getServletContext(), "files/Footer.html"));

	}

}
