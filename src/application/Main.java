package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public void start(Stage primaryStage) throws IOException {

		Parent root=FXMLLoader.load(getClass().getResource("Inicio.fxml"));

		primaryStage.setTitle("Classic Food");
		primaryStage.setScene(new Scene(root,800,450));
		primaryStage.show();

		}

		public static void main(String[] args) {
		launch(args);
		}
}
