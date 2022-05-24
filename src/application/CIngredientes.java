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
import src.Ingrediente;
import src.Plato;

public class CIngredientes {
	
	@FXML private ComboBox boxNombre;
    @FXML private Button btnCambiar;
    @FXML private TextField txtIngredientes, txtCantidad;
    
    BBDD bd = new BBDD();
    
    @FXML private void cambiarIngredientes(MouseEvent event) {
    	if(!txtIngredientes.getText().isEmpty() && !txtCantidad.getText().isEmpty() && setBox(event) != null) {
			String[] ingredientes = txtIngredientes.getText().split(",");
			String[] cantidad = txtCantidad.getText().split(",");
			bd.eliminarPlato_Ingrediente(bd.mostrarID_Plato(String.valueOf(setBox(event))));
			for(int i = 0; i<ingredientes.length; i++) {
			bd.darAltaPLATO_INGRED(bd.mostrarID_Ingrediente(ingredientes[i]), bd.mostrarID_Plato(String.valueOf(setBox(event))), cantidad[i]);
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
		txtIngredientes.clear();
		txtCantidad.clear();
		boxNombre.getItems().clear();
    }
    
    @FXML private Object setBox(MouseEvent event) {
		ObservableList<String> list = FXCollections.observableArrayList(bd.mostrarNombrePlatos());
		boxNombre.setItems(list);
		Object s = boxNombre.getValue();
		return s;
	}

}
