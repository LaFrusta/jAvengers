package eSport.view;

import java.io.StringWriter;

import javax.servlet.ServletContext;

public class Register {

	private StringWriter writer;
	//TODO:
	public Register() {
		this.writer = new StringWriter();
	}
	
	public void writeRegisterPage(ServletContext context) {
		
		writer.write(HTMLLoader.load(context, "FILE DA CARICARE"));
		
	}
}
