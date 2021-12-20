package eSport.view;

import java.io.PrintWriter;

import javax.servlet.ServletContext;

public class Layout {

	public static void doLayoutOn(ServletContext context, PrintWriter writer,String refFile){ 
		String content=HTMLLoader.load(context, refFile); 
		doLayout(context, writer, content);
	}
	
	public static void doLayout(ServletContext context, PrintWriter writer,String content){

		String full = HTMLLoader.load(context, "files/fulllayout.part.html");
		writer.write(full.replace("$content$", content));
	}
}
