package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @version 1.0.0 2022-02-25 Initial implementation
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
			this.url = s;
			Document doc = Jsoup.connect(url).get();
			BufferedWriter  writer = null;
	        try {
	        	writer = new BufferedWriter( new FileWriter("C:\\Users\\wysockil\\OneDrive - Wentworth Institute of Technology\\Desktop\\Stocks-HTML.txt"));
	        	writer.write(doc.toString());
	        	writer.close(); // prevents data leaks

	        } catch ( IOException ex) {
	            System.out.println("There is a failure during reading, writing, and searching file or directory operations.");
	        }
			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		
		return "C:\\Users\\wysockil\\OneDrive - Wentworth Institute of Technology\\Desktop\\Stocks-HTML.txt";
		
	}

}

