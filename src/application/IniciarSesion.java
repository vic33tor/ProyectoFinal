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

public class IniciarSesion {
	
	@FXML Button btnRegistrar, btnInicioSesion, btnVolver;
	@FXML BorderPane bp;
	@FXML TextField txtEmail1, txtContraseña1;
	
	BBDD bd = new BBDD();
	
	@FXML private void goMain(MouseEvent event) {
		if(!txtEmail1.getText().isEmpty() && !txtContraseña1.getText().isEmpty()) {
			if(bd.mostrarEmail(txtEmail1.getText()) && bd.mostrarContraseña(txtEmail1.getText(), txtContraseña1.getText())) {
			Cliente c = new Cliente(bd.mostrarDni(txtEmail1.getText()), txtEmail1.getText(),bd.mostrarDireccion(txtEmail1.getText()), txtContraseña1.getText());
			loadpage("MainCliente");
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
	}
	@FXML private void goRegistrarse(MouseEvent event) {
		loadpage("Registro");
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
