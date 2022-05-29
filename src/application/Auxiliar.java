package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
/**
 * clase controladora de la interfaz Auxiliar
 * @author víctor
 *
 */
public class Auxiliar {

	@FXML private Button btnNo;
	@FXML private Button btnSi;
	@FXML BorderPane bp;
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz Pagar
	 * @param event se usa para que el botón se pueda pulsar
	 */
	@FXML void goPagar(MouseEvent event) {
		loadpage("Pagar");
	}
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz QuitarIngrediente
	 * @param event se usa para que el botón se pueda pulsar
	 */
	@FXML void goQuitarIngrediente(MouseEvent event) {
		loadpage("QuitarIngrediente");
	}
	/**
	 * metodo para poder cambiar de interfaz
	 * @param page la interfaz a la que se va a cambiar
	 */
	void loadpage(String page) {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(page+".fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bp.setCenter(root);

	}

}
