package eSport.view;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletContext;

public class RegistratiView {

private StringWriter writer;
	
	public RegistratiView() {
		
		this.writer = new StringWriter();
		
	}
	
	public void writeRegistrati() {
		
		writer.write("<table>");
		writer.write("<tr>\r\n"
				+ "		<th style=\"text-align: center;\" class=\"tw\">REGISTRAZIONE</th>\r\n"
				+ "	</tr>");
		writer.write("<tr>\r\n<td style=\" padding-top: 20px;\">\r\n<div>");
		writer.write("<form action=\"Registrati\" method=\"post\">\r\n"
				+ "<label for=\"nome_utente\" style=\"font-style: italic;\" "
				+ "class=\"tw\">Scegli il tuo Username:</label><br> \r\n");
		writer.write("<input type=\"text\" id=\"nome_utente\" name=\"nome_utente\" value=\"nome_utente\"><br>");
		writer.write("<label for=\"password\" style=\"font-style: italic;\" class=\"tw\">Scegli Password:</label><br> \r\n"
				+ "<input type=\"password\" id=\"password\" name=\"password\" value=\"password\"><br>\r\n"
				+ "<input type=\"submit\" value=\"Registrati\" ><br>");
		writer.write("</form>\n</div>\n</td>\n</tr>\n</table>\n</div>");
	}
	
	public String getString() {
		
		return writer.toString();
		
	}
	
	public static void registratiWriter(ServletContext context, PrintWriter writer) {
		
		RegistratiView view = new RegistratiView();
		
		view.writeRegistrati();
		
		Layout.doLayout(context, writer, view.getString(), null, false, false);
	}
}
