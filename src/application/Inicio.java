package application;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
/**
 * clase controladora de la interfaz Inicio
 * @author víctor
 *
 */
public class Inicio {

	@FXML Button btnAdmin, btnCliente;
	@FXML BorderPane bp;
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz Admin
	 * @param event se usa para que el boton se pueda pulsar
	 */
	@FXML private void aAdmin(MouseEvent event) {
		loadpage("Admin");
	}
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz InicioSesion
	 * @param event se usa para que el boton se pueda pulsar
	 */
	@FXML private void aCliente(MouseEvent event) {
		loadpage("InicioSesion");
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
