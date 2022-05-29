package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import src.Administrador;
import src.BBDD;
/**
 * clase controladora de la interfaz Admin
 * @author v�ctor
 *
 */
public class Admin {

	@FXML Button btnIngresar, btnVolver;
	@FXML BorderPane bp;
	@FXML TextField txtContrase�a;

	BBDD bd = new BBDD();
	/**
	 * metodo que se usa en un bot�n que al pulsarlo te lleva a la interfaz MainAdmin si se ha introducido correctamente la contrase�a
	 * @param event se usa para que el bot�n se pueda pulsar
	 */
	@FXML private void goMain(MouseEvent event) {
		if(!txtContrase�a.getText().isEmpty()) {
			if(bd.mostrarContrase�aAdmin(txtContrase�a.getText())) {
				Administrador a = new Administrador(bd.mostrarDniAdmin(txtContrase�a.getText()), txtContrase�a.getText());
				loadpage("MainAdmin");
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
	}
	/**
	 * metodo que se usa en un bot�n que al pulsarlo te lleva a la interfaz Inicio
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
