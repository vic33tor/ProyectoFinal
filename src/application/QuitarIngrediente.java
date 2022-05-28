package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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
		String [] num_plato_pedido = setBoxPlato(event);
		for(int i = 0; i<bd.c.platos.size();i++) {
			if(bd.c.platos.get(i).getNumero_pedido() == Integer.valueOf(num_plato_pedido[0])) {
				bd.c.platos.get(i).ingredientes_borrar.add(String.valueOf(setBoxIngrediente(event))); 
			}
		}
		loadpage("Auxiliar");
	}
	@FXML private String[] setBoxPlato(MouseEvent event) {
		ArrayList<String> aux = new ArrayList<String>();
		for(int i = 0; i<bd.c.platos.size(); i++) {
			if(bd.c.platos.get(i).getTipo().equals("COMIDA")) {
			aux.add(bd.c.platos.get(i).getNumero_pedido()+"-"+bd.c.platos.get(i).getNombre());
			}
		}
		ObservableList<String> list = FXCollections.observableArrayList(aux);
		boxPlato.setItems(list);
		String[] boxplato= String.valueOf(boxPlato.getValue()).split("-");
		return boxplato;
	}

	@FXML private Object setBoxIngrediente(MouseEvent event) {
		String []nom_plato = setBoxPlato(event);
		ObservableList<String> list = FXCollections.observableArrayList(bd.mostrarINGREDIENTES_PLATO(bd.mostrarID_Plato(nom_plato[1])));
			for (int i = 0; i<bd.c.platos.size(); i++) {
				if(bd.c.platos.get(i).ingredientes_borrar.size()>0 && bd.c.platos.get(i).getNumero_pedido() == Integer.valueOf(nom_plato[0])) {
					list.removeAll(bd.c.platos.get(i).ingredientes_borrar);
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