package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import src.BBDD;
import src.Plato;

public class QuitarIngrediente {

	@FXML private ComboBox boxIngrediente;
	@FXML private ComboBox boxPlato;
	@FXML private BorderPane bp;
	@FXML private Button btnQuitar;

	BBDD bd = new BBDD();

	@FXML void quitarIngrediente(MouseEvent event) {
		bd.plato = new Plato(bd.mostrarID_Plato(String.valueOf(setBoxPlato(event))), String.valueOf(setBoxPlato(event)), bd.mostrarPrecio(String.valueOf(setBoxPlato(event))), "COMIDA");
		bd.plato.ingredientes_borrar.add(String.valueOf(setBoxIngrediente(event)));
		bd.lista_platos.add(bd.plato);
		loadpage("Auxiliar");
	}
	@FXML private Object setBoxPlato(MouseEvent event) {
		ObservableList<String> list = FXCollections.observableArrayList(bd.c.platos);
		boxPlato.setItems(list);
		Object s = boxPlato.getValue();
		return s;
	}

	@FXML private Object setBoxIngrediente(MouseEvent event) {
		ObservableList<String> list = FXCollections.observableArrayList(bd.mostrarINGREDIENTES_PLATO(bd.mostrarID_Plato(String.valueOf(setBoxPlato(event)))));
		if(bd.lista_platos != null) {
			for (int i = 0; i<bd.lista_platos.size(); i++) {
				if(String.valueOf(setBoxPlato(event)).equals(bd.lista_platos.get(i).getNombre())) {
					list.removeAll(bd.lista_platos.get(i).ingredientes_borrar);
				}
			}
		}
		boxIngrediente.setItems(list);
		Object s = boxIngrediente.getValue();
		return s;
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