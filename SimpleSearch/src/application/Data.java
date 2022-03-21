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
			System.out.printf("Placeholder");
			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		
		return s;
		
	}
	

}

