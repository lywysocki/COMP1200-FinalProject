package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);

			Data test = new Data();
			String txt = test.Data("https://finance.yahoo.com/trending-tickers");
			
			TextArea textArea = new TextArea(txt);
			primaryStage.setScene(new Scene(textArea));
			textArea.setEditable(false);
			primaryStage.show();
			
	

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

