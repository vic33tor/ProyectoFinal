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
import src.Aministrador;
import src.BBDD;

public class Admin {
	
	@FXML Button btnIngresar, btnVolver;
	@FXML BorderPane bp;
	@FXML TextField txtContrase�a;
	
	BBDD bd = new BBDD();
	
	@FXML private void goMain(MouseEvent event) {
		if(!txtContrase�a.getText().isEmpty()) {
			if(bd.mostrarContrase�aAdmin(txtContrase�a.getText())) {
			Aministrador a = new Aministrador(bd.mostrarDniAdmin(txtContrase�a.getText()), txtContrase�a.getText());
			loadpage("MainAdmin");
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
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
