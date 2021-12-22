package eSport.view;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletContext;

public class EliminaView {

	private StringWriter writer;
	
	public EliminaView() {
		this.writer =new StringWriter();
		
	}
	
	public String getString() {
		return writer.toString();
		
	}
	
	public void writeElimina(String nome_utente, String target) {
		
		writer.write("<table>\n"
				+ "<tr>Sei sicuro di voler eliminare "+target+" ? L'operazione non &egrave; reversibile!</tr>"
						+ "<tr><td><a href=\"Eliminato?nome_utente="+nome_utente+"&target="+target+"\">Si</a></td>"
						+ "<td><a href=\"Homepage?nome_utente="+nome_utente+"\">No</a></td>"
						+ "<td><a href=\"Elimina?nome_utente="+nome_utente+"&target="+target+"\" target=\"_blank\">Forse?</a></tr></td></td></table>");
	}
	
	public void writeEliminaTrue(String nome_utente, String target) {
		writer.write("<h4>L'utente "+target+" &egrave; stato eliminato con successo!</h4>");
	}
	
	public static void eliminaWriter(ServletContext context, PrintWriter writer, String nome_utente, String target, boolean logged, boolean admin) {
		
		EliminaView view = new EliminaView();
		view.writeElimina(nome_utente, target);
		Layout.doLayout(context, writer, view.getString(), nome_utente, logged, admin);
	}
	public static void eliminatoWriter(ServletContext context, PrintWriter writer, String nome_utente, String target, boolean logged, boolean admin) {
		EliminaView view = new EliminaView();
		view.writeEliminaTrue(nome_utente, target);
		Layout.doLayout(context, writer, view.getString(), nome_utente, logged, admin);
	}
}
