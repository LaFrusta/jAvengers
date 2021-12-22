package eSport.view;

import java.io.PrintWriter;

import javax.servlet.ServletContext;

public class Layout {

	public static void doLayoutOn(ServletContext context, PrintWriter writer,String refFile, String nome_utente, boolean logged, boolean admin){ 
		String content=HTMLLoader.load(context, refFile); 
		doLayout(context, writer, content, nome_utente,logged,admin);
	}
	
	public static void doLayout(ServletContext context, PrintWriter writer,String content, String nome_utente, boolean logged, boolean admin){

		if(!logged) {
			String full = HTMLLoader.load(context, "files/fulllayout.part.html")+"\n<div align=\"center\">\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "<table>\r\n"
				+ "  <tr>\r\n"
				+ "    <th style=\"border: 1px solid yellow; background-color: yellow\"><a href=\"Homepage?nome_utente="+nome_utente+"\" style=\"background-color: yellow; color: red;\">HOME</a></th>\r\n"
				+ "    <th style=\"border: 1px solid yellow; background-color: yellow\"><a href=\"Punteggi?nome_utente="+nome_utente+"\" style=\"background-color: yellow; color: red\">PUNTEGGI</a></th>\r\n"
				+ "    <th style=\"border: 1px solid yellow; background-color: yellow\"><a href=\"Login\" style=\"background-color: yellow; color: red\">LOGIN</a></th>\r\n"
				+ "    <th style=\"border: 1px solid yellow; background-color: yellow\"><a href=\"Registrati\" style=\"background-color: yellow; color: red\">REGISTRATI</a></th>\r\n"
				+ "    \r\n"
				+ "  </tr>\r\n"
				+ "\r\n"
				+ "</table>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</div>"
				+ "<div align=\"center\">"+
				HTMLLoader.load(context, "files/footer.html");
		writer.write(full.replace("$content$", content));
		} else if(logged&&!admin){
			String full = HTMLLoader.load(context, "files/fulllayout.part.html")+"\n<div align=\"center\">\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "<table>\r\n"
					+ "  <tr>\r\n"
					+ "    <th style=\"border: 1px solid yellow; background-color: yellow\"><a href=\"Homepage?nome_utente="+nome_utente+"\" style=\"background-color: yellow; color: red;\">HOME</a></th>\r\n"
					+ "    <th style=\"border: 1px solid yellow; background-color: yellow\"><a href=\"Punteggi?nome_utente="+nome_utente+"\" style=\"background-color: yellow; color: red\">PUNTEGGI</a></th>\r\n"
					+ "    <th style=\"border: 1px solid yellow; background-color: yellow\"><a href=\"Profilo?nome_utente="+nome_utente+"\" style=\"background-color: yellow; color: red\">PROFILO</a></th>\r\n"
					+ "    \r\n"
					+ "  </tr>\r\n"
					+ "\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "</div>"
					+ "<div align=\"center\">"+
					HTMLLoader.load(context, "files/footer.html");
			writer.write(full.replace("$content$", content));
		} else if(logged&&admin) {
			String full = HTMLLoader.load(context, "files/fulllayout.part.html")+"\n<div align=\"center\">\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "<table>\r\n"
					+ "  <tr>\r\n"
					+ "    <th style=\"border: 1px solid yellow; background-color: yellow\"><a href=\"Homepage?nome_utente="+nome_utente+"\" style=\"background-color: yellow; color: red;\">HOME</a></th>\r\n"
					+ "    <th style=\"border: 1px solid yellow; background-color: yellow\"><a href=\"Punteggi?nome_utente="+nome_utente+"\" style=\"background-color: yellow; color: red\">PUNTEGGI</a></th>\r\n"
					+ "    <th style=\"border: 1px solid yellow; background-color: yellow\"><a href=\"Profilo?nome_utente="+nome_utente+"\" style=\"background-color: yellow; color: red\">PROFILO</a></th>\r\n"
					+ "	   <th style=\"border: 1px solid yellow; background-color: yellow\"><a href=\"Admin?nome_utente="+nome_utente+"\" style=\"background-color: yellow; color: red\">ADMIN</a></th>\r\n"
					+ "    \r\n"
					+ "  </tr>\r\n"
					+ "\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "</div>"
					+ "<div align=\"center\">"+
					HTMLLoader.load(context, "files/footer.html");
			writer.write(full.replace("$content$", content));
		}
	}
}
