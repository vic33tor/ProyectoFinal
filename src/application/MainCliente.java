package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class MainCliente {
	
	@FXML Button btnHome, btnPedido, btnVerPedido;
	@FXML BorderPane bp;
	
	@FXML private void goHome(MouseEvent event) {
		loadpage("HomeCliente");
	}
	@FXML private void goHacerPedido(MouseEvent event) {
		loadpage("HacerPedido");
	}
	@FXML private void goVerPedido(MouseEvent event) {
		loadpage("VerPedidos");
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


