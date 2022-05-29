package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * clase que inicia el programa
 * @author victor
 *
 */
public class Main extends Application {
	/**
	 * metodo que inicia el programa en la interfaz Inicios
	 */
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
