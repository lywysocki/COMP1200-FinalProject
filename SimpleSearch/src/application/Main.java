package application;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;



/**
 * @version 1.0.1 2022-02-25 Initial implementation
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		String data = "";
		
		try {
			/*
			 * Constructs java window pane
			 */
			BorderPane root = new BorderPane();

try (/////////////////////////////////////////////////////////////////////////////			
						/**
						 * creates data object & gets txt file url 
						 */
			Scanner p = new Scanner(System.in)) {
				System.out.println("Enter the sock symbol you want: ");
				String y = p.nextLine();
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
				
				System.out.println("price: " + price + " Percent Change: " + percentChange + " Market Change: " + change + " Symbol: " + symbol + " Name: " + name);
			}
			
			
		
			
			/**
			 * returns txt file to a string
			 */
			//Path file = Paths.get(txtFile);
			//InputStream in = null;
			//StringBuffer cBuf = new StringBuffer();
			//try {
			//    in = Files.newInputStream(file);
			//    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			  //  String line = null;

			  //  while ((line = reader.readLine()) != null) {
			       // System.out.println(line);
			  //      cBuf.append("\n");
			  //      cBuf.append(line);
			 //   }
			//} catch (IOException x) {
			//    System.err.println(x);
			//} finally {
			//    if (in != null) in.close();
			//}
			//String txt = cBuf.toString();
			
			/*
			 * creates non-eduble txtArea
			 */
			//TextArea textArea = new TextArea(txt);
			//Scene scene = new Scene(textArea, 1000, 750);
			//textArea.setEditable(true);
///////////////////////////////////////////////////////////////////////////////////////////
			//Label for the stock trends
		    Label label = new Label("Stock Trends:");
		    Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
		    label.setFont(font);
		    
		    //Creating a table view
		    TableView<String> table = new TableView<String>();
		    
		    //Creating columns for each data-field
		    TableColumn symbolCol = new TableColumn("Symbol");
		    TableColumn nameCol = new TableColumn("Name");
		    TableColumn lastPriceCol = new TableColumn("Last Price");
		    TableColumn changeCol = new TableColumn("Change");
		    TableColumn pcentChangeCol = new TableColumn("% Change");
		    nameCol.setPrefWidth(100);
		    
		    //Adding data to the table
		    ObservableList<String> list = FXCollections.observableArrayList();
		    table.setItems(list);
		    table.getColumns().addAll(symbolCol, nameCol, lastPriceCol, changeCol, pcentChangeCol);
		    
		    //Setting the size of the table
		    table.setMaxSize(1000, 1000);
		    Button button2= new Button("Go to scene 1");
		    button2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					//primaryStage.setScene(scene);
					primaryStage.centerOnScreen();
				}
		    });
		    VBox vbox = new VBox();
		    vbox.setSpacing(5);
		    vbox.setPadding(new Insets(10, 50, 50, 60));
		    vbox.getChildren().addAll(label, table, button2);
		    
		    //Setting the scene & the primary stage
		    Scene scene2= new Scene(vbox, 595, 230);
		    primaryStage.setTitle("Simple Search");
		    primaryStage.setScene(scene2);
		    primaryStage.centerOnScreen();
		    primaryStage.show();
			

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	/**
	 * starts launch function
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}

