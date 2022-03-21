package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @version 1.0.3 2022-03-21 GUI
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
		/*
		 * Scene 1 - User input to Search
		 */
			/* 
			 * objects to be placed on stage
			 */
			Label prompt = new Label("What stock overveiw would you like to see?");
			TextField inputSearch = new TextField();
			inputSearch.setPromptText("Enter stock symbol");
			inputSearch.setFocusTraversable(false);
			Label symbl = new Label("Symbol:");
			Button enter = new Button("Search");
			//ActionEvent for button to display results on new scene
			enter.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
				
					String[] data = null;
					try {
						data = new Data(inputSearch.getText()).getData();
					} catch (IOException | InterruptedException e) {
						
						e.printStackTrace();
					}

				/*
				 * Scene 2 - Stock information based on input
				 */
					//Label for the stock trends
				    Label label = new Label("Stock Trends:");
				    Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
				    label.setFont(font);
				    
				    //Creating a table view
				    TableView<TableData> table = new TableView<TableData>();
				    final ObservableList<TableData> theData = FXCollections.observableArrayList(
				    	//table order: sym, name, price, change, percent change
				    	//array order: price, percentChange, change, symbol, name
				    	new TableData(data[3], data[4], data[1], data[2], data[3])
				    );
				    
				    //Creating columns for each data-field
				    TableColumn symbolCol = new TableColumn("Symbol");
				    symbolCol.setCellValueFactory(new PropertyValueFactory("symbol"));
				    symbolCol.setPrefWidth(75);
				    TableColumn nameCol = new TableColumn("Name");
				    nameCol.setCellValueFactory(new PropertyValueFactory("name"));
				    nameCol.setPrefWidth(100);
				    TableColumn lastPriceCol = new TableColumn("Last Price");
				    lastPriceCol.setCellValueFactory(new PropertyValueFactory("price"));
				    lastPriceCol.setPrefWidth(100);
				    TableColumn changeCol = new TableColumn("Change");
				    changeCol.setCellValueFactory(new PropertyValueFactory("change"));
				    changeCol.setPrefWidth(100);
				    TableColumn pcentChangeCol = new TableColumn("% Change");
				    pcentChangeCol.setCellValueFactory(new PropertyValueFactory("percentChange"));
					pcentChangeCol.setPrefWidth(100);
					
					//Adding data to the table
					ObservableList<String> list = FXCollections.observableArrayList();
					table.setItems(theData);
					table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
				    table.getColumns().addAll(symbolCol, nameCol, lastPriceCol, changeCol, pcentChangeCol);
				    
				    //Setting the size of the table
				    table.setMaxSize(1000, 1000);
				    					    
				    VBox vbox = new VBox();
				    vbox.setSpacing(5);
				    vbox.setPadding(new Insets(10, 50, 50, 60));
				    vbox.getChildren().addAll(label, table);
				    //Setting the scene
				    Scene scene2 = new Scene(vbox, 595, 230);
				    primaryStage.setScene(scene2);
					primaryStage.centerOnScreen();				
				}
				
			});
			
			/*
			 * styling & position of elements
			 */
			VBox vbox1 = new VBox(10);
			vbox1.setAlignment(Pos.CENTER);
			vbox1.getChildren().addAll(prompt);
			HBox hbox1 = new HBox(10);
			hbox1.setAlignment(Pos.CENTER);
			hbox1.getChildren().addAll(symbl,inputSearch, enter);

			BorderPane root = new BorderPane();
			root.setTop(vbox1);
			root.setCenter(hbox1);
		  
			//Setting the scene & the primary stage
		    Scene scene1= new Scene(root, 500, 300);
		    primaryStage.setTitle("Simple Search");
		    primaryStage.setScene(scene1);
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

