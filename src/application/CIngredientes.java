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
/**
 * clase controladora de la interfaz CambiarIngredientes
 * @author víctor
 *
 */
public class CIngredientes {

	@FXML private ComboBox boxNombre;
	@FXML private Button btnCambiar;
	@FXML private TextField txtIngredientes, txtCantidad;

	BBDD bd = new BBDD();
	/**
	 * metodo que se usa en un botón que al pulsarlo se le eliminan los ingredientes que tenía un plato y se le añaden los nuevos puestos por el usuario
	 *  si el plato y los ingredientes existen
	 * @param event se usa para que el botón se pueda pulsar
	 */
	@FXML private void cambiarIngredientes(MouseEvent event) {
		if(!txtIngredientes.getText().isEmpty() && !txtCantidad.getText().isEmpty() && setBox(event) != null) {
			String[] ingredientes = txtIngredientes.getText().split(",");
			String[] cantidad = txtCantidad.getText().split(",");
			bd.eliminarPlato_Ingrediente(bd.mostrarID_Plato(String.valueOf(setBox(event))));
			for(int i = 0; i<ingredientes.length; i++) {
				if(bd.mostrarID_Ingrediente(ingredientes[i])>0) {
					bd.darAltaPLATO_INGRED(bd.mostrarID_Ingrediente(ingredientes[i]), bd.mostrarID_Plato(String.valueOf(setBox(event))), cantidad[i]);
				}else {
					JOptionPane.showMessageDialog(null, "Ingrediente no existente en la base de datos");
				}

			}

		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
		txtIngredientes.clear();
		txtCantidad.clear();
		boxNombre.getItems().clear();
	}
	/**
	 * metodo que da valores a un combobox(todos los platos de la base de datos)
	 * @param event se usa para que el combobox se pueda pulsar
	 * @return devuelve lo seleccionado por el usuario en la combobox
	 */
	@FXML private Object setBox(MouseEvent event) {
		ObservableList<String> list = FXCollections.observableArrayList(bd.mostrarNombrePlatos());
		boxNombre.setItems(list);
		Object s = boxNombre.getValue();
		return s;
	}

}
