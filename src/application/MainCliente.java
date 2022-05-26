package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import src.BBDD;

public class MainCliente {
	
	@FXML Button btnHome, btnPedido, btnVerPedido;
	@FXML BorderPane bp;
	
	BBDD bd = new BBDD();
	
	@FXML private void goHome(MouseEvent event) {
		loadpage("HomeCliente");
	}
	@FXML private void goHacerPedido(MouseEvent event) {
		bd.c.platos.clear();
		bd.contador = 1;
		loadpage("RealizarPedido");
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


