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

public class BorrarPlato {
	
	@FXML Button btnBorrar;
	@FXML TextField txtNombre;
	@FXML ComboBox boxTipo;
	
	BBDD bd = new BBDD();
	
	@FXML private void Borrar(MouseEvent event) {
		if(!txtNombre.getText().isEmpty() && setBox(event).equals("Plato")) {
			bd.eliminarPlato_Ingrediente(bd.mostrarID_Plato(txtNombre.getText()));
			bd.eliminarPlato_Bebida(txtNombre.getText());
		}else if(!txtNombre.getText().isEmpty() &&  setBox(event).equals("Ingrediente")){
			bd.eliminarIngrediente(txtNombre.getText());
		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
		txtNombre.clear();
		boxTipo.getItems().clear();
	}
	
	@FXML private Object setBox(MouseEvent event) {
		ObservableList<String> list = FXCollections.observableArrayList("Plato","Ingrediente");
		boxTipo.setItems(list);
		Object s = boxTipo.getValue();
		return s;
	}

}
