package application;


import java.io.IOException;

import javax.swing.JOptionPane;

import BaseDatos.BBDD;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import src.Cliente;

public class Registrarse {

	@FXML Button btnRegistrar, btnInicioSesion, btnVolver;
	@FXML TextField txtDni, txtEmail, txtContraseña, txtDireccion;
	@FXML BorderPane bp;

	BBDD bd = new BBDD();
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz MainCliente
	 * @param event se usa para que el botón se pueda pulsar
	 */
	@FXML private void goMain(MouseEvent event) {
		if(!txtDni.getText().isEmpty() && !txtEmail.getText().isEmpty() &&
				!txtContraseña.getText().isEmpty() && !txtDireccion.getText().isEmpty()) {
			bd.c = new Cliente(txtDni.getText(), txtEmail.getText(),txtDireccion.getText(), txtContraseña.getText());
			bd.darAltaCliente(bd.c);
			loadpage("MainCliente");
		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
	}
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz InicioSesion
	 * @param event se usa para que el botón se pueda pulsar
	 */
	@FXML private void goInicioSesion(MouseEvent event) {
		loadpage("InicioSesion");
	}
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz Inicio
	 * @param event se usa para que el botón se pueda pulsar
	 */
	@FXML private void goInicio(MouseEvent event) {
		loadpage("Inicio");
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
