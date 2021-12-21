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
		
	}
	
	public String getString() {
		
		return writer.toString();
		
	}
	
	public static void loginWriter(ServletContext context, PrintWriter writer) {
		
		LoginView view = new LoginView();
		
		view.writeLogin();
		
		Layout.doLayout(context, writer, view.getString());
	}
}
