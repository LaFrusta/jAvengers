package eSport.view;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletContext;

import eSport.model.Utente;
import eSport.model.Utenti;

public class ModificaView {

	private StringWriter writer;
	
	public ModificaView() {
		this.writer = new StringWriter();
		
	}
	
	public void writeModifica(String nome_utente, String target) {
		Utente utente = Utenti.ReadOne(target);
		
		writer.write("<table>"
				+ "<td>\r\n"
				+ "		<div>\r\n"
				+ "			<form action=\"Modifica\" method=\"post\">\r\n"
				+ "				<label for=\"nome_utente\" style=\"font-style: italic;\" class=\"tw\">Inserisci il nuovo UserName</label><br> <input\r\n"
				+ "					type=\"text\" id=\"target\" name=\"target\" value=\""+target+"\"><br> <label\r\n"
				+ "					for=\"password\" style=\"font-style: italic;\" class=\"tw\">Scegli la nuova Password</label><br> <input type=\"password\"\r\n"
				+ "					id=\"password\" name=\"password\" value=\""+utente.getPassword()+"\"><br>\r\n"
				+ "				<input type=\"submit\" value=\"Modifica\" ><input type=\"hidden\" name='nome_utente' value='"+nome_utente+"'>"
						+ "<input type=\"hidden\" name='vecchio_nome_utente' value='"+target+"'><br>\r\n"
				+ "			</form>\r\n"
				+ "			</div>\r\n"
				+ "		</td>\n</table>");
	}
	
	public void writeModificaTrue(String nome_utente, String target) {
		writer.write("<h4>L'utente "+target+" è stato modificato con successo!</h4>");
	}
	public String getString() {
		return writer.toString();
		
	}
	
	public static void modificaWriter(ServletContext context, PrintWriter writer, String nome_utente, String target, boolean logged, boolean admin) {
		
		ModificaView view = new ModificaView();
		view.writeModifica(nome_utente, target);
		Layout.doLayout(context, writer, view.getString(), nome_utente, true, true);
		
	}
}
