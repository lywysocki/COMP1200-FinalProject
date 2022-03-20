package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @version 1.0.1 2022-02-25 Initial implementation
 */
public class Data {
	String url = "";
			
	/**
	 * reads text to stock file
	 * @param s
	 * @return to Stock File
	 */
	public String Data(String s) {
		try {
			//this.url = s;
			//Document doc = s;

			BufferedWriter  writer = null;
	        try {
	        	//"C:\\Users\\wysockil\\OneDrive - Wentworth Institute of Technology\\Desktop\\Stocks-HTML.txt"
	        	writer = new BufferedWriter( new FileWriter("C:\\Users\\dyere1\\Desktop\\HTML-SS.txt"));
	        	//writer.write(doc.toString());
	        	writer.close(); // prevents data leaks

	        } catch ( IOException ex) {
	            System.out.println("There is a failure during reading, writing, and searching file or directory operations.");
	        }
			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		
		
		
		//"C:\\Users\\wysockil\\OneDrive - Wentworth Institute of Technology\\Desktop\\Stocks-HTML.txt"
		return "C:\\Users\\dyere1\\Desktop\\HTML-SS.txt";
		
	}
	

}

