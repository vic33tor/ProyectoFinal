package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
import src.Plato;
/**
 * clase controladora de la interfaz Pagar
 * @author víctor
 *
 */
public class Pagar implements Initializable{

	@FXML private BorderPane bp;
	@FXML private Button btnPagar;
	@FXML private Text txtPlatos, txtPrecio, txtPrecioTotal, txtTotal;

	BBDD bd = new BBDD();
	Double precio_total = 0.0;
	int contador_pedidos = 0;

	/**
	 * metodo que quita la cantidad de los ingredientes utilizados en los platos del pedido realizado
	 */
	void cambiarIngredientes() {
		for(int i = 0; i<bd.c.platos.size(); i++) {
			ArrayList <String> ingredientes_out = new ArrayList <String>();
			ArrayList <String> ingredientes = new ArrayList <String>();
			if (bd.c.platos.get(i).ingredientes_borrar.size()>0) {
				for(int j = 0; j<bd.c.platos.get(i).ingredientes_borrar.size(); j++) {
					ingredientes_out.add(bd.c.platos.get(i).ingredientes_borrar.get(j));
				}
				ingredientes = bd.mostrarINGREDIENTES_PLATO(bd.c.platos.get(i).getId_plato());
				ingredientes.removeAll(ingredientes_out);
				for(int z = 0; z<ingredientes.size(); z++) {
					int id_plato = bd.c.platos.get(i).getId_plato();
					int id_ingrediente = bd.mostrarID_Ingrediente(ingredientes.get(z));
					if(bd.mostrarCantidadIngredienteAlmacen(id_ingrediente)<bd.mostrarCantidadIngrediente(id_plato, id_ingrediente)) {
						bd.ComprarIngrediente(bd.mostrarCantidadIngrediente(id_plato, id_ingrediente)*15, id_ingrediente);
					}
					bd.modificarCantidad(bd.mostrarCantidadIngrediente(id_plato, id_ingrediente), id_ingrediente);			
				}
			}else {
				ingredientes = bd.mostrarINGREDIENTES_PLATO(bd.c.platos.get(i).getId_plato());
				for(int z = 0; z<ingredientes.size(); z++) {
					int id_plato = bd.c.platos.get(i).getId_plato();
					int id_ingrediente = bd.mostrarID_Ingrediente(ingredientes.get(z));
					bd.modificarCantidad(bd.mostrarCantidadIngrediente(id_plato, id_ingrediente), id_ingrediente);
				}
			}

		}
	}

	/**
	 * metodo que se usa en un botón que al pulsarlo se añade el pedido a la base de datos, se añaden los platos que llevaba el pedido
	 * y se actualiza el número de pedidos del motorista que ha llevado el pedido. Por último llama al método cambiarIngredientes
	 * @param event se usa para que el botón se pueda pulsar
	 */
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

		}
		bd.modificarNum_pedidos(dni_moto);
		cambiarIngredientes();



		bd.c.platos = new HashMap<Integer, Plato>();
		loadpage("HomeCliente");
		JOptionPane.showMessageDialog(null, "Pedido realizado correctamente");

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
	/**
	 * metodo que hace que al iniciar la interfaz se haga un set de los difentes textos con los valores que les corresponde
	 * txtPlatos con los platos, txtPrecio con los precios y txtPrecioTotal con el precio total
	 */
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
			precio = precio+bd.c.platos.get(i).getPrecio()+"€\n";
			precio_total= precio_total+Double.valueOf(bd.c.platos.get(i).getPrecio());
		}
		platos =platos.replace("[", "");
		platos =platos.replace("]", "");
		txtPlatos.setText(platos);
		txtPrecio.setText(precio);
		txtPrecioTotal.setText(String.valueOf(precio_total)+"€");


	}

}
