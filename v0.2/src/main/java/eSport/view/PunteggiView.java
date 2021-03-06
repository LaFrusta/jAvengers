package eSport.view;

import java.io.StringWriter;
import java.util.List;

import eSport.model.Punteggio;

public class PunteggiView {
	
	
	/*
	 * Ritorna una tabella HTML nella quale, nella prima colonna
	 * ? inserito il nome utente e nella seconda, il suo punteggio
	 * 
	 * @param: StringWriter writer, List<Punteggio> punteggi
	 * */
	
	public static void writePunteggi(StringWriter writer, List<Punteggio> punteggi) {
		
		writer.write("<table>");
		
		for(Punteggio punteggio : punteggi) {
			writer.write("<tr style = \"border: 1px solid black;\"><td style = \"border: 1px solid black;\">"+punteggio.getNomeUtente()+"</td>"
					+ "<td  style = \"border: 1px solid black;\"> "+punteggio.getRisultato()+"</td></tr>");
		}
		writer.write("</table>");
	}
	
}
