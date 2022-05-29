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
import src.Plato;
/**
 * clase controladora de la interfaz RealizarPedido
 * @author víctor
 *
 */
public class HacerPedido {
	@FXML private BorderPane bp;
	@FXML private ComboBox boxNombre;
	@FXML private Button btnComprar;
	@FXML private Text txtPrecio;

	BBDD bd = new BBDD();
	int key = 0;

	/**
	 * metodo que se usa en un botón que al pulsarlo se añade el plato seleccionado a una lista si el plato existe
	 * @param event se usa para que el botón se pueda pulsar
	 */
	@FXML private void comprarPlato(MouseEvent event) {

		if(setBox(event)!=null) {
			bd.plato = new Plato(bd.mostrarID_Plato(String.valueOf(setBox(event))), String.valueOf(setBox(event)), bd.mostrarPrecio(String.valueOf(setBox(event))), bd.mostrarTipo(String.valueOf(setBox(event))), bd.contador);
			bd.contador ++;
			bd.c.platos.put(key, bd.plato);
			key++;
		}else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
		}
		txtPrecio.setText("");
		boxNombre.getItems().clear();
	}
	/**
	 * metodo que se usa en un botón que al pulsarlo te lleva a la interfaz Auxiliar si ha comprado mínimo un plato
	 * @param event se usa para que el botón se pueda pulsar
	 */
	@FXML private void goPagar(MouseEvent event) {
		System.out.println(bd.c.platos);
		if (bd.c.platos.size() > 0) {
			loadpage("Auxiliar");

		}else {
			JOptionPane.showMessageDialog(null, "No ha comprado ningun plato");
		}
		txtPrecio.setText("");
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
	/**
	 * se pone el txtPrecio como el precio del plato seleccionado
	 * @param event se usa para que se puedan usar acciones sobre el texto
	 */
	@FXML
	private void setTextPrecio(ActionEvent event) {
		txtPrecio.setText(String.valueOf(bd.mostrarPrecio(String.valueOf(boxNombre.getValue())))+"€");
	}
	/**
	 * metodo para poder cambiar de interfaz
	 * @param page la interfaz a la que se va a cambiar
	 */
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
