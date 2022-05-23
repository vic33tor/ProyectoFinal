package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ModificarPlato {
	
	@FXML Button btnCambiarIngredientes, btnCambiarPrecio;
	@FXML BorderPane bp;
	
	@FXML private void goCambiarIngredientes(MouseEvent event) {
		loadpage("CambiarIngredientes");
	}
	@FXML private void goCambiarPrecio(MouseEvent event) {
		loadpage("CambiarPrecio");
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
