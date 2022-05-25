package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class Pagar {
	
    @FXML private BorderPane bp;
	@FXML private Button btnPagar;
    @FXML private Text txtPlatos, txtPrecio, txtPrecioTotal, txtTotal;

    
    @FXML
    void pagar(MouseEvent event) {
    	loadpage("HomeCliente");
    	JOptionPane.showMessageDialog(null, "Pedido realizado correctamente");
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
