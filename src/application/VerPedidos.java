package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BaseDatos.BBDD;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
/**
 * clase controladora de la interfaz VerPedidos
 * @author víctor
 *
 */
public class VerPedidos implements Initializable{

	@FXML
	private Text txtPedido;

	BBDD bd = new BBDD();
	/**
	 * metodo que al inicar la interfaz seteea el texto txtPedido con todos los pedidos del cliente
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList <String> lista_pedidos = new ArrayList <String>();
		ArrayList <String> lista_platos = new ArrayList <String>();
		String textofinal="";
		int contador = 0;
		if(bd.mostrarPedido(bd.c.getDni_cliente()).size()<=0) {
			txtPedido.setText("No hay pedidos realizados en este momento");
		}else {
			lista_pedidos = bd.mostrarPedido(bd.c.getDni_cliente());
			while(contador<lista_pedidos.size()) {
				String[]un_pedido = lista_pedidos.get(contador).split(",");
				textofinal = textofinal +un_pedido[1]+"\n";
				lista_platos = bd.mostrarPlato(Integer.valueOf(un_pedido[0]));
				for(int i = 0; i<lista_platos.size(); i++) {
					String[]un_plato = lista_platos.get(i).split(",");
					textofinal = textofinal + un_plato[0]+"    "+un_plato[1]+"€\n";
				}
				textofinal = textofinal + "Total:    "+un_pedido[2]+"€\n";
				contador++;
				textofinal = textofinal + "---------------------------------------------------------\n";
			}
			txtPedido.setText(textofinal);
		}

	}

}