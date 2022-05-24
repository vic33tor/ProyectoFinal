package application;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import src.BBDD;

public class CPrecio {
	
	@FXML private ComboBox boxNombre;
    @FXML private Button btnCambiar;
    @FXML private TextField txtPrecio;
    
    BBDD bd = new BBDD();
    
    @FXML private void cambiarPrecio(MouseEvent event) {
    	if(!txtPrecio.getText().isEmpty() && setBox(event) != null) {
			bd.modificarPrecio(bd.mostrarID_Plato(String.valueOf(setBox(event))), Double.valueOf(txtPrecio.getText()));
			
		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
		txtPrecio.clear();
		boxNombre.getItems().clear();
    }
    
    @FXML private Object setBox(MouseEvent event) {
		ObservableList<String> list = FXCollections.observableArrayList(bd.mostrarNombrePlatos());
		boxNombre.setItems(list);
		Object s = boxNombre.getValue();
		return s;
	}

}
