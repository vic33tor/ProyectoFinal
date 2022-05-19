package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class MainAdmin {
	
	@FXML Button btnHome, btnAplato, btnMplato, btnBplato;
	@FXML BorderPane bp;
	
	@FXML private void goHome(MouseEvent event) {
		loadpage("HomeAdmin");
	}
	@FXML private void goAplato(MouseEvent event) {
		loadpage("AñadirPlato");
	}
	@FXML private void goMplato(MouseEvent event) {
		loadpage("ModificarPlato");
	}
	@FXML private void goBplato(MouseEvent event) {
		loadpage("BorrarPlato");
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
