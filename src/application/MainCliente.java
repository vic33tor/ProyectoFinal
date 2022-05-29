package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import src.BBDD;
/**
 * clase controladora de la interfaz MainCliente
 * @author víctor
 *
 */
public class MainCliente {

	@FXML Button btnHome, btnPedido, btnVerPedido;
	@FXML BorderPane bp;

	BBDD bd = new BBDD();
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz HomeCliente
	 * @param event se usa para que el boton se pueda pulsar
	 */
	@FXML private void goHome(MouseEvent event) {
		loadpage("HomeCliente");
	}
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz RealizarPedido
	 * @param event se usa para que el boton se pueda pulsar
	 */
	@FXML private void goHacerPedido(MouseEvent event) {
		bd.c.platos.clear();
		bd.contador = 1;
		loadpage("RealizarPedido");
	}
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz VerPedidos
	 * @param event se usa para que el boton se pueda pulsar
	 */
	@FXML private void goVerPedido(MouseEvent event) {
		loadpage("VerPedidos");
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


