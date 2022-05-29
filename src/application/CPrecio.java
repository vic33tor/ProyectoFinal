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
/**
 * clase controladora de la interfaz CambiarPrecio
 * @author víctor
 *
 */
public class CPrecio {

	@FXML private ComboBox boxNombre;
	@FXML private Button btnCambiar;
	@FXML private TextField txtPrecio;

	BBDD bd = new BBDD();
	/**
	 * metodo que se usa en un botón que al pulsarlo se le cambia el precio del plato seleccionado si el plato existe
	 * @param event se usa para que el botón se pueda pulsar
	 */
	@FXML private void cambiarPrecio(MouseEvent event) {
		if(!txtPrecio.getText().isEmpty() && setBox(event) != null) {
			bd.modificarPrecio(bd.mostrarID_Plato(String.valueOf(setBox(event))), Double.valueOf(txtPrecio.getText()));

		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
		txtPrecio.clear();
		boxNombre.getItems().clear();
	}
	/**
	 * metodo que da valores a un combobox(todos los platos y bebidas  de la base de datos)
	 * @param event se usa para que el combobox se pueda pulsar
	 * @return devuelve lo seleccionado por el usuario en la combobox
	 */
	@FXML private Object setBox(MouseEvent event) {
		ObservableList<String> list = FXCollections.observableArrayList(bd.mostrarPlatos_Bebidas());
		boxNombre.setItems(list);
		Object s = boxNombre.getValue();
		return s;
	}

}
