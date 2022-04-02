package application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @version 1.1.0 2022-04-2 Completed
 */
public class Data {
	String symbol;
	
	/**
	 * Takes in stock symbol
	 * @param symbol
	 */
	public Data(String symbol) {
		this.symbol = symbol;
	}
	
	/**
	 * Uses API and JSON parsing to collect stock data
	 * @return theData - an ArrayList
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String[][] getData() throws IOException, InterruptedException {
		/**
		 * creates data object & gets txt file url 
		 */	
			String y = symbol;
			String[] strings = new String[1];
			strings[0] = y;
			if (y.contains(",")) {
				strings = y.split(",");
			}
			String[] price = new String[strings.length];
			String[] name = new String[strings.length];
			String[] percentChange = new String[strings.length];
			String[] change = new String[strings.length];
			String[] symbol = new String[strings.length];
			
			for (int x = 0; x < strings.length; x++) {	
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://yh-finance.p.rapidapi.com/market/v2/get-quotes?region=US&symbols="+strings[x]))
					.header("x-rapidapi-host", "yh-finance.p.rapidapi.com")
					.header("x-rapidapi-key", "0f53f57913msh0ea1556e79c9010p1e00b3jsnedf35e02234d")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			String[] rawData = response.body().split(",");
			for(int i = 0; i < rawData.length; i++) {
				if (rawData[i].contains("regularMarketPrice")) {
					price[x] = rawData[i].split(":")[1];
				}
				if (rawData[i].contains("regularMarketChangePercent")) {
					percentChange[x] = rawData[i].split(":")[1];
				}
				if (rawData[i].contains("regularMarketChange\"")) {
					change[x] = rawData[i].split(":")[1];
				}
				if (rawData[i].contains("symbol")) {
					symbol[x] = (String) rawData[i].split(":")[1].subSequence(1,rawData[i].split(":")[1].length() - 3);
		
				}
				if (rawData[i].contains("shortName")) {
					name[x] = (String) rawData[i].split(":")[1].subSequence(1,rawData[i].split(":")[1].length() - 1);
				}

				
		}
			}
		
		String[][] theData = {symbol, name, price, change, percentChange};
		return theData;
	}


}