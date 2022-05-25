package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import src.BBDD;

public class HacerPedido {
	@FXML private BorderPane bp;
	@FXML private ComboBox boxNombre;
    @FXML private Button btnComprar;
    @FXML private Text txtPrecio;
    
    BBDD bd = new BBDD();
    

    
    @FXML private void comprarPlato(MouseEvent event) {
    	if (setBox(event) != null) {
    		if(bd.mostrarTipo(String.valueOf(setBox(event))).equals("COMIDA")) {
			bd.c.platos.add(String.valueOf(setBox(event)));
			bd.c.precio_platos.add(bd.mostrarPrecio(String.valueOf(setBox(event))));
    		}
    		else {
    			bd.c.bebidas.add(String.valueOf(setBox(event)));
    			bd.c.precio_bebidas.add(bd.mostrarPrecio(String.valueOf(setBox(event))));
    		}
			
		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
		txtPrecio.setText("");
		boxNombre.getItems().clear();
    }
    
    @FXML private void goPagar(MouseEvent event) {
    	if (bd.c.platos.size() > 0 && bd.c.precio_platos.size() > 0) {
			loadpage("Auxiliar");
			
		}else {
			JOptionPane.showMessageDialog(null, "No ha comprado ningun plato");
		}
    	txtPrecio.setText("");
		boxNombre.getItems().clear();
    }
    
    @FXML private Object setBox(MouseEvent event) {
		ObservableList<String> list = FXCollections.observableArrayList(bd.mostrarPlatos_Bebidas());
		boxNombre.setItems(list);
		Object s = boxNombre.getValue();
		return s;
	}
    @FXML
    private void setTextPrecio(ActionEvent event) {
    	txtPrecio.setText(String.valueOf(bd.mostrarPrecio(String.valueOf(boxNombre.getValue())))+"€");
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
