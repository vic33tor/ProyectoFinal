package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Auxiliar {

    @FXML private Button btnNo;
    @FXML private Button btnSi;
    @FXML BorderPane bp;

    @FXML void goPagar(MouseEvent event) {
    	loadpage("Pagar");
    }

    @FXML void goQuitarIngrediente(MouseEvent event) {
    	loadpage("QuitarIngrediente");
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
