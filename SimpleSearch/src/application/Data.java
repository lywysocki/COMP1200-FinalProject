package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Data {
	String url = "";
			
	public String Data(String s) {
		try {
			url = s;
			Document doc = Jsoup.connect(url).get();
			BufferedWriter  writer = null;
	        try {
	        	writer = new BufferedWriter( new FileWriter("C:\\Users\\wysockil\\OneDrive - Wentworth Institute of Technology\\Desktop\\Stocks-HTML.txt"));
	        	writer.write(doc.toString());

	        } catch ( IOException e) {
	        	
	        }
			 
			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		
		return "C:\\Users\\wysockil\\OneDrive - Wentworth Institute of Technology\\Desktop\\Stocks-HTML.txt";
		
	}

}

