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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/eSport/create")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();

		printWriter.write(HTMLStringPartLoader.loadHTMLStringFromFile(getServletContext(), "files/header.part.html"));

		printWriter.write(HTMLStringPartLoader.loadHTMLStringFromFile(getServletContext(), "files/createform.part.html"));

		printWriter.write(HTMLStringPartLoader.loadHTMLStringFromFile(getServletContext(), "files/footer.part.html"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String nome_utente = request.getParameter("nome_utente");
		String password = request.getParameter("password");
		printWriter.write(HTMLStringPartLoader.loadHTMLStringFromFile(getServletContext(), "files/header.part.html"));
		Utente utente = new Utente(nome_utente, password);
		if(Utenti.Create(utente)) {

			String conferma=HTMLStringPartLoader.loadHTMLStringFromFile(getServletContext(), "files/confirmcreate.part.html");
			conferma = conferma.replace("$nome_utente$", nome_utente).replace("$password$", password);
			printWriter.write(conferma);	
		}
	}

}
