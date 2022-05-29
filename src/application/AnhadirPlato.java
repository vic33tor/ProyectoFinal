package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import src.Administrador;
import src.BBDD;
import src.Ingrediente;
import src.Plato;
/**
 * clase controladora de la interfaz AñadirPlato
 * @author víctor
 *
 */
public class AnhadirPlato {

	@FXML Button btnAñadir;
	@FXML TextField txtNombre, txtPrecio;
	@FXML ComboBox boxTipo;

	BBDD bd = new BBDD();
	/**
	 * metodo que se usa en un botón que al pulsarlo se añade a un plato o un ingrediente
	 * si el plato o ingrediente existe, depende de lo seleccionado en la combobox
	 * @param event se usa para que el botón se pueda pulsar
	 */
	@FXML private void Anhadir(MouseEvent event) {
		if(!txtNombre.getText().isEmpty() && !txtPrecio.getText().isEmpty() && setBox(event).equals("Plato")) {
			Double precio = Double.valueOf(txtPrecio.getText());
			Plato p = new Plato(bd.mostrarMAXID_PLATO(), txtNombre.getText(), precio, "COMIDA",0);
			bd.anhadirPlato_Bebida(p);
		}else if(!txtNombre.getText().isEmpty() && !txtPrecio.getText().isEmpty() && setBox(event).equals("Ingrediente")){
			Double cantidad = Double.valueOf(txtPrecio.getText());
			Ingrediente i = new Ingrediente(bd.mostrarMAXID_Ingrediente(), txtNombre.getText(), cantidad);
			bd.anhadirIngrediente(i);
		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
		txtNombre.clear();
		txtPrecio.clear();
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
