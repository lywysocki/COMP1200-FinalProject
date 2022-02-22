package application;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		String data = "";
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);

			Data test = new Data();
			String txtFile = test.Data("https://finance.yahoo.com/trending-tickers");
			
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

