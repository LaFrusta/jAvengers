package eSport.view;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletContext;

public class LoginView {

	private StringWriter writer;
	
	public LoginView() {
		
		this.writer = new StringWriter();
		
	}
	
	public void writeLogin() {
		
		writer.write("<table>");
		writer.write("<tr>\r\n"
				+ "		<th style=\"text-align: center;\" class=\"tw\">LOGIN</th>\r\n"
				+ "	</tr>");
		writer.write("<tr>\r\n<td style=\" padding-top: 20px;\">\r\n<div>");
		writer.write("<form action=\"Login\" method=\"post\">\r\n"
				+ "<label for=\"nome_utente\" style=\"font-style: italic;\" "
				+ "class=\"tw\">Inserisci il tuo Username:</label><br> \r\n");
		writer.write("<input type=\"text\" id=\"nome_utente\" name=\"nome_utente\" value=\"nome_utente\"><br>");
		writer.write("<label for=\"password\" style=\"font-style: italic;\" class=\"tw\">Inserisci Password:</label><br> \r\n"
				+ "<input type=\"password\" id=\"password\" name=\"password\" value=\"password\"><br>\r\n"
				+ "<input type=\"submit\" value=\"Accedi\" ><br>");
		writer.write("</form>\n</div>\n</td>\n</tr>\n</table>\n</div>");		
	}
	
	public String getString() {
		
		return writer.toString();
		
	}
	
	public static void loginWriter(ServletContext context, PrintWriter writer, String nome_utente, boolean logged, boolean admin) {
		
		LoginView view = new LoginView();
		
		view.writeLogin();
		
		Layout.doLayout(context, writer, view.getString(), nome_utente, logged, admin);
	}
}
