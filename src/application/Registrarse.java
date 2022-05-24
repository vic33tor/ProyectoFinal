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
import src.BBDD;
import src.Cliente;

public class Registrarse {

	@FXML Button btnRegistrar, btnInicioSesion, btnVolver;
	@FXML TextField txtDni, txtEmail, txtContraseña, txtDireccion;
	@FXML BorderPane bp;

	BBDD bd = new BBDD();

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
	@FXML private void goInicioSesion(MouseEvent event) {
		loadpage("InicioSesion");
	}

	@FXML private void goInicio(MouseEvent event) {
		loadpage("Inicio");
	}

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
