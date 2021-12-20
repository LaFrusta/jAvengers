package eSport.view;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletContext;

import eSport.model.Punteggio;

public class HomePage {

	private StringWriter writer;
	
	public HomePage() {
	
		this.writer=new StringWriter();
	}
	
	/*
	 *Restituisce la Home Page del sito web
	 *
	 * @param: String title, List<Punteggio> punteggi
	 * */
	
	public void writeHomePage(String title, List<Punteggio> punteggi) {
		
		writer.write("<h1>"+title+"</h1>" );
		
		writer.write("<a href =\"Login\">Sei già registrato? Effettua il login</a><br>");
		
		writer.write("<a href =\"Registrati\">Oppure registrati ora!</a>");
			
		writer.write("<h1>Ultimi punteggi inseriti:</h1><br>");
		
		PunteggiView.writePunteggi(writer, punteggi);
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
	
	public static void homePageWriter(ServletContext context, PrintWriter writer, List<Punteggio> punteggi) {
		
		HomePage home = new HomePage();
		
		home.writeHomePage("HomePage", punteggi);
		
		Layout.doLayout(context, writer, home.getString());
	}
}


