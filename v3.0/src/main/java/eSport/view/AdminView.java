package eSport.view;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletContext;

import eSport.model.Utente;
import eSport.model.Utenti;

public class AdminView {

	private StringWriter writer;
	
	public AdminView() {
		this.writer = new StringWriter();
		
	}
	
	public void writeAdmin(String nome_utente) {
		List<Utente> utenti = Utenti.ReadAll();
		writer.write("<table>");
		for(Utente utente : utenti) {
			writer.write("<tr><td>"+utente.getNome_utente()+"</td><td><a href=\"Modifica?nome_utente="+nome_utente+"&target="+utente.getNome_utente()+"\">Modifica Utente</a></td>"
					+ "<td><a href=\"Elimina?nome_utente="+nome_utente+"&target="+utente.getNome_utente()+"\">Elimina Utente</a></td>"
					+ "<td><a href=\"Records?nome_utente="+nome_utente+"&target="+utente.getNome_utente()+"\">Modifica Punteggi</a></td></tr>");
		}
	}
	
	public String getString() {
		return writer.toString();
		
	}
	
	public static void adminWriter(ServletContext context, PrintWriter writer, String nome_utente, boolean logged, boolean admin) {
		AdminView view = new AdminView();
		view.writeAdmin(nome_utente);
		Layout.doLayout(context, writer, view.getString(), nome_utente, logged, admin);
	}
}
