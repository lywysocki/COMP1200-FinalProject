package application;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		String data = "";
		
		try {
			/*
			 * Constructs java window pane
			 */
			BorderPane root = new BorderPane();

/////////////////////////////////////////////////////////////////////////////			
			/**
			 * creates data object & gets txt file url 
			 */
			Data test = new Data();
			String txtFile = test.Data("https://finance.yahoo.com/trending-tickers");
			
			/**
			 * returns txt file to a string
			 */
			Path file = Paths.get(txtFile);
			InputStream in = null;
			StringBuffer cBuf = new StringBuffer();
			try {
			    in = Files.newInputStream(file);
			    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			    String line = null;

			    while ((line = reader.readLine()) != null) {
			        System.out.println(line);
			        cBuf.append("\n");
			        cBuf.append(line);
			    }
			} catch (IOException x) {
			    System.err.println(x);
			} finally {
			    if (in != null) in.close();
			}
			String txt = cBuf.toString();
			
			/*
			 * creates non-eduble txtArea
			 */
			TextArea textArea = new TextArea(txt);
			Scene scene = new Scene(textArea);
			textArea.setEditable(true);
///////////////////////////////////////////////////////////////////////////////////////////			
			
			//Label for education
		      Label label = new Label("Stock Trends:");
		      Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
		      label.setFont(font);
		      //Creating a table view
		      TableView<String> table = new TableView<String>();
		      //Creating columns
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
		      button2.setOnAction(e -> primaryStage.setScene(scene));
		      
		      VBox vbox = new VBox();
		      vbox.setSpacing(5);
		      vbox.setPadding(new Insets(10, 50, 50, 60));
		      vbox.getChildren().addAll(label, table, button2);
		      //Setting the scene
		      Scene scene2= new Scene(vbox, 595, 230);
		      primaryStage.setTitle("Simple Search");
		      primaryStage.setScene(scene2);
			
			

			primaryStage.show();
			
	

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

