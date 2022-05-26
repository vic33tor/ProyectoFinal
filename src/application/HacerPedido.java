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

public class HacerPedido {
	@FXML private BorderPane bp;
	@FXML private ComboBox boxNombre;
    @FXML private Button btnComprar;
    @FXML private Text txtPrecio;
    
    BBDD bd = new BBDD();
    int key = 0;

    
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
    
    @FXML private Object setBox(MouseEvent event) {
		ObservableList<String> list = FXCollections.observableArrayList(bd.mostrarPlatos_Bebidas());
		boxNombre.setItems(list);
		Object s = boxNombre.getValue();
		return s;
	}
    @FXML
    private void setTextPrecio(ActionEvent event) {
    	txtPrecio.setText(String.valueOf(bd.mostrarPrecio(String.valueOf(boxNombre.getValue())))+"€");
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
