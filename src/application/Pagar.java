package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
import src.Pedido;

public class Pagar implements Initializable{

	@FXML private BorderPane bp;
	@FXML private Button btnPagar;
	@FXML private Text txtPlatos, txtPrecio, txtPrecioTotal, txtTotal;

	BBDD bd = new BBDD();
	Double precio_total = 0.0;
	int contador_pedidos = 0;


	@FXML
	void pagar(MouseEvent event) {
		String dni_moto = bd.mostrarDni_motorista();
		bd.p = new Pedido(bd.mostrarMAXID_PEDIDO(), LocalDate.now(), precio_total, bd.mostrarDni_motorista(), bd.c.getDni_cliente());
		bd.anhadirPedido(bd.p);
		int contador = 1;
		for(int i = 0; i<bd.c.platos.size(); i++) {
			contador = 1;
			for(int j = 0; j<bd.c.platos.size(); j++) {
				if(i!=j && bd.c.platos.get(i).getId_plato() == bd.c.platos.get(j).getId_plato()) {
					contador++;
				}
			}
			bd.anhadirPedido_Plato(bd.p.getId_pedido(), bd.c.platos.get(i).getId_plato(), contador);
			bd.modificarNum_pedidos(bd.mostrarNum_pedidos(dni_moto), dni_moto);
		}
		//TE FALTA MODIFICAR LA CANTIDAD DE INGREDIENTES

		bd.c.platos = null;
		loadpage("HomeCliente");
		JOptionPane.showMessageDialog(null, "Pedido realizado correctamente");
		
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
		precio_total = 0.0;
		String ingredientes_out = "";

		for(int i = 0; i<bd.c.platos.size(); i++) {
			if(bd.c.platos.get(i).ingredientes_borrar.size()!=0) {
				for(int j = 0; j<bd.c.platos.get(i).ingredientes_borrar.size(); j++) {
					ingredientes_out = ingredientes_out + bd.c.platos.get(i).ingredientes_borrar;
				}
				platos = platos+bd.c.platos.get(i).getNombre()+" sin "+ingredientes_out+" \n";
				ingredientes_out = "";

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
