package eSport.view;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletContext;

import eSport.model.Punteggio;

public class PunteggiView {
	
	private StringWriter writer;
	
	public PunteggiView() {
		this.writer = new StringWriter();
	}
	/*
	 * Ritorna una tabella HTML nella quale, nella prima colonna
	 * è inserito il nome utente e nella seconda, il suo punteggio
	 * 
	 * @param: StringWriter writer, List<Punteggio> punteggi
	 * */
	
	public void writePunteggi(List<Punteggio> punteggi) {
		
		writer.write("<table>");
		
		for(Punteggio punteggio : punteggi) {
			writer.write("<tr><td>"+punteggio.getNomeUtente()+"</td>"
					+ "<td> "+punteggio.getRisultato()+"</td></tr>");
		}
		writer.write("</table>");
	}
	
	public String getString() {
		return writer.toString();
	}
	
	public static void punteggiWriter(ServletContext context, PrintWriter writer, List<Punteggio> punteggi, String nome_utente, boolean logged, boolean admin) {
		
		PunteggiView points = new PunteggiView();
		
		points.writePunteggi(punteggi);
		
		Layout.doLayout(context, writer, points.getString(), nome_utente, logged, admin);
	}
}
