package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
/**
 * clase controladora de la interfaz MainAdmin
 * @author víctor
 *
 */
public class MainAdmin {

	@FXML Button btnHome, btnAplato, btnMplato, btnBplato;
	@FXML BorderPane bp;
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz HomeAdmin
	 * @param event se usa para que el boton se pueda pulsar
	 */
	@FXML private void goHome(MouseEvent event) {
		loadpage("HomeAdmin");
	}
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz AñadirPlato
	 * @param event se usa para que el boton se pueda pulsar
	 */
	@FXML private void goAplato(MouseEvent event) {
		loadpage("AñadirPlato");
	}
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz ModificarPlato
	 * @param event se usa para que el boton se pueda pulsar
	 */
	@FXML private void goMplato(MouseEvent event) {
		loadpage("ModificarPlato");
	}
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz BorrarPlato
	 * @param event se usa para que el boton se pueda pulsar
	 */
	@FXML private void goBplato(MouseEvent event) {
		loadpage("BorrarPlato");
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
