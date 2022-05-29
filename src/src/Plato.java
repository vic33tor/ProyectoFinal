package src;

import java.util.ArrayList;
/**
 * clase de los platos
 * @author víctor
 *
 */
public class Plato {

	private Integer id_plato;

	private String nombre;

	private Double precio;

	private String tipo;
	
	private int numero_pedido;
	/**
	 * lista que indica los ingredientes que no se van a utilizar en este plato en un pedido determinado
	 */
	public ArrayList<String> ingredientes_borrar = new ArrayList<String>();


	public Plato(Integer id_plato,String nombre, Double precio, String tipo, int numero_pedido) {
		this.id_plato = id_plato;
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
		this.numero_pedido = numero_pedido;
	}

	public Integer getId_plato() {
		return id_plato;
	}

	public void setId_plato(Integer id_plato) {
		this.id_plato = id_plato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(int numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	@Override
	public String toString() {
		return "Plato [id_plato=" + id_plato + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo
				+ ", numero_pedido=" + numero_pedido + "]";
	}


	







}