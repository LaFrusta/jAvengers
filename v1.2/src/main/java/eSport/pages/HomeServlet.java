package eSport.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eSport.db.Punteggi;
import eSport.db.Punteggio;
import eSport.html.HTMLStringPartLoader;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter=response.getWriter();
		
		printWriter.write(HTMLStringPartLoader.loadHTMLStringFromFile(getServletContext(), "files/header.part.html"));
		printWriter.write("<a class=\"insert\" href=\"eSport/create\">Registrati!</a>");

		List<Punteggio> punteggi=Punteggi.ReadAll();
		printWriter.write("<ul>");
		for (Punteggio punteggio : punteggi) {
			printWriter.write("<li><h2>Punteggio di "+punteggio.getId()+" = "+ punteggio.getRisultato() +"</h2></li>");
		}
		printWriter.write("</ul>");
		
		printWriter.write(HTMLStringPartLoader.loadHTMLStringFromFile(getServletContext(), "files/footer.part.html"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
