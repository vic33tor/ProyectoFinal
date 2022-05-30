package application;

import javax.swing.JOptionPane;

import BaseDatos.BBDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import src.Ingrediente;
import src.Plato;
/**
 * clase controladora de la interfaz BorrarPlato
 * @author víctor
 *
 */
public class BorrarPlato {

	@FXML Button btnBorrar;
	@FXML TextField txtNombre;
	@FXML ComboBox boxTipo;

	BBDD bd = new BBDD();
	/**
	 * metodo que se usa en un botón que al pulsarlo se borra el plato o ingrediente seleccionado si el plato o ingrediente existe,
	 *  depende de lo que el usuario elija en el combobox
	 * @param event se usa para que el botón se pueda pulsar
	 */
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
	/**
	 * metodo que da valores a un combobox
	 * @param event se usa para que el combobox se pueda pulsar
	 * @return devuelve lo seleccionado por el usuario en la combobox
	 */
	@FXML private Object setBox(MouseEvent event) {
		ObservableList<String> list = FXCollections.observableArrayList("Plato","Ingrediente");
		boxTipo.setItems(list);
		Object s = boxTipo.getValue();
		return s;
	}

}
