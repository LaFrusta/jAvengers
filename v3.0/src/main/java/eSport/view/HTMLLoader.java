package eSport.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletContext;

public class HTMLLoader {

	public static String load(ServletContext context,String filename) {
		
		String path=context.getRealPath(filename); 

		StringWriter writer = new StringWriter();

		try {
			FileReader reader = new FileReader(path);
			BufferedReader br = new BufferedReader(reader);

			String line = br.readLine();
			while (line != null) {
				writer.write(line+"\n");
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}

		String htmlPart = writer.toString();
		return htmlPart;
	}
}
