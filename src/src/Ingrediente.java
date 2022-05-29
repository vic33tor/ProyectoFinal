package src;
/**
 * clase de los ingredientes 
 * @author víctor
 *
 */
public class Ingrediente {
	
	int id_ingrediente;
	String nombre;
	double cantidad;
	
	public Ingrediente(int id_ingrediente, String nombre, double cantidad) {
		this.id_ingrediente = id_ingrediente;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public int getId_ingrediente() {
		return id_ingrediente;
	}

	public void setId_ingrediente(int id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Ingrediente [id_ingrediente=" + id_ingrediente + ", nombre=" + nombre + ", cantidad=" + cantidad + "]";
	}
	
	
	

}
