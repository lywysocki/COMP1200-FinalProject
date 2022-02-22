package application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Data {
	final String URL = "https://finance.yahoo.com/trending-tickers"
	
	try {
		Document doc = Jsoup.connect(URL).get();

		for (Element row : ) {
			
		}


	} catch (Exception ex) {
		
	}

}
