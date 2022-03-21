package application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @version 1.0.1 2022-02-25 Initial implementation
 */
public class Data {
	String symbol;
	/**
	 * reads text to stock file
	 * @param s
	 * @return to Stock File
	 */
	public Data(String symbol) {
		this.symbol = symbol;
	}
	
	public String[] getData() throws IOException, InterruptedException {
		/**
		 * creates data object & gets txt file url 
		 */	
			String y = symbol;
			String price = "";
			String name = "";
			String percentChange = "";
			String change = "";
			String symbol = "";
			
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://yh-finance.p.rapidapi.com/market/v2/get-quotes?region=US&symbols="+y))
					.header("x-rapidapi-host", "yh-finance.p.rapidapi.com")
					.header("x-rapidapi-key", "0f53f57913msh0ea1556e79c9010p1e00b3jsnedf35e02234d")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			String[] rawData = response.body().split(",");
			for(int i = 0; i < rawData.length; i++) {
				if (rawData[i].contains("regularMarketPrice")) {
					price = rawData[i].split(":")[1];
				}
				if (rawData[i].contains("regularMarketChangePercent")) {
					percentChange = rawData[i].split(":")[1];
				}
				if (rawData[i].contains("regularMarketChange\"")) {
					change = rawData[i].split(":")[1];
				}
				if (rawData[i].contains("symbol")) {
					symbol = (String) rawData[i].split(":")[1].subSequence(1,rawData[i].split(":")[1].length() - 3);
		
				}
				if (rawData[i].contains("shortName")) {
					name = (String) rawData[i].split(":")[1].subSequence(1,rawData[i].split(":")[1].length() - 1);
				}

				
		}
		
		String[] theData = {symbol, name, price, change, percentChange};
		return theData;
	}


}

