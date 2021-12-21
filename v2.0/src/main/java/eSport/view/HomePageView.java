package eSport.view;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletContext;

import eSport.model.Punteggio;

public class HomePageView {

	private StringWriter writer;
	
	public HomePageView() {
	
		this.writer=new StringWriter();
	}
	
	/*
	 *Restituisce la Home Page del sito web
	 *
	 * @param: String title, List<Punteggio> punteggi
	 * */
	
	public void writeHomePage(String title, List<Punteggio> punteggi, String nome_utente) {
		
		writer.write("<h1>"+title+"</h1>" );
		
		writer.write("<a href =\"Login\">Sei già registrato? Effettua il login</a><br>");
		
		writer.write("<a href =\"Registrati\">Oppure registrati ora!</a>");
			
		writer.write("<h1>Ultimi punteggi inseriti:</h1><br>");
		
		PunteggiView points = new PunteggiView();
		
		points.writePunteggi(punteggi);
		
		writer.write(points.getString());
		
		writer.write("<form action=\"Punteggi?nome_utente="+nome_utente+"\" method=\"post\">");
		
		writer.write("<button type=\"submit\" name=\"nome_utente\" value=\"nome_utente\" class=\"btn-link\">Punteggi</button></form>");
		
	}
	
	/*
	 * Ritorna una Stringa con al suo interno il contenuto dello StringWriter
	 * 
	 * @return: String
	 * 
	 * @see: StringWriter
	 * */
	public String getString() {
		return writer.toString();
	}
	
	public void write(String file, ServletContext context) {
		
		writer.write(HTMLLoader.load(context, file));
	}
	
	public static void homePageWriter(ServletContext context, PrintWriter writer, List<Punteggio> punteggi, String nome_utente) {
		
		HomePageView home = new HomePageView();
		
		home.writeHomePage("HomePage", punteggi, nome_utente);
		
		Layout.doLayout(context, writer, home.getString());
	}
}