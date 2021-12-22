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
	
	public void writeHomePage(String title, List<Punteggio> punteggi, String nome_utente, boolean logged) {
		if(logged) {
		writer.write("<h1>"+title+"</h1>" );
		
		writer.write("<h4>Benvenuto, "+ nome_utente+"</h4>");
			
		writer.write("<h1>Ultimi punteggi inseriti:</h1>");
		
		PunteggiView points = new PunteggiView();
		
		points.writePunteggi(punteggi);
		
		writer.write(points.getString());
		
		} else {
			
			writer.write("<h1>"+title+"</h1>" );
			
			writer.write("<h4>Sei già registrato? Effettua il <a href =\"Login\">login</a></h4>");
			
			writer.write("<h4>Oppure <a href =\"Registrati\">registrati ora!</a></h4>");
			
			writer.write("<h1>Ultimi punteggi inseriti:</h1>");
			
			PunteggiView points = new PunteggiView();
			
			points.writePunteggi(punteggi);
			
			writer.write(points.getString());
			
		}
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
	
	public static void homePageWriter(ServletContext context, PrintWriter writer, List<Punteggio> punteggi, String nome_utente, boolean logged, boolean admin) {
		
		HomePageView home = new HomePageView();
		
		home.writeHomePage("HomePage", punteggi, nome_utente, logged);
		
		Layout.doLayout(context, writer, home.getString(), nome_utente, logged, admin);
	}
}