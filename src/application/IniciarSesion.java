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
/**
 * clase controladora de la interfaz InicioSesion
 * @author víctor
 *
 */
public class IniciarSesion {

	@FXML Button btnRegistrar, btnInicioSesion, btnVolver;
	@FXML BorderPane bp;
	@FXML TextField txtEmail1, txtContraseña1;

	BBDD bd = new BBDD();
	/**
	 * metodo que se usa en un botón que al pulsarlo te lleva a la interfaz MainCliente si se han introducido correctamente los datos
	 * @param event se usa para que el botón se pueda pulsar
	 */
	@FXML private void goMain(MouseEvent event) {
		if(!txtEmail1.getText().isEmpty() && !txtContraseña1.getText().isEmpty()) {
			if(bd.mostrarEmail(txtEmail1.getText()) && bd.mostrarContraseña(txtEmail1.getText(), txtContraseña1.getText())) {
				BBDD.c = new Cliente(bd.mostrarDni(txtEmail1.getText()), txtEmail1.getText(),bd.mostrarDireccion(txtEmail1.getText()), txtContraseña1.getText());
				loadpage("MainCliente");
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
	}
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz Registro
	 * @param event se usa para que el boton se pueda pulsar
	 */
	@FXML private void goRegistrarse(MouseEvent event) {
		loadpage("Registro");
	}
	/**
	 * metodo que se usa en un boton que al pulsarlo te lleva a la interfaz Inicio
	 * @param event se usa para que el boton se pueda pulsar
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
