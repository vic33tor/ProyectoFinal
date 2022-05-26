package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import src.BBDD;

public class Pagar implements Initializable{

	@FXML private BorderPane bp;
	@FXML private Button btnPagar;
	@FXML private Text txtPlatos, txtPrecio, txtPrecioTotal, txtTotal;

	BBDD bd = new BBDD();


	@FXML
	void pagar(MouseEvent event) {
		loadpage("HomeCliente");
		JOptionPane.showMessageDialog(null, "Pedido realizado correctamente");
		//Hacer todos los cambios de pedidos, ingredientes y motoristas en la base de datos
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String platos = "";
		String precio = "";
		Double precio_total = 0.0;
		String ingredientes_out = "";
		
		for(int i = 0; i<bd.c.platos.size(); i++) {
			if(bd.c.platos.get(i).ingredientes_borrar.size()!=0) {
				ingredientes_out = ingredientes_out + bd.c.platos.get(i).ingredientes_borrar;
				platos = platos+bd.c.platos.get(i).getNombre()+" sin "+ingredientes_out+" \n";
			
			}else {
				platos = platos+bd.c.platos.get(i).getNombre()+" \n";
			}
			precio = precio+bd.c.platos.get(i).getPrecio()+" \n";
			precio_total= precio_total+Double.valueOf(bd.c.platos.get(i).getPrecio());
		}
		platos =platos.replace("[", "");
		platos =platos.replace("]", "");
		txtPlatos.setText(platos);
		txtPrecio.setText(precio);
		txtPrecioTotal.setText(String.valueOf(precio_total));


	}

}
