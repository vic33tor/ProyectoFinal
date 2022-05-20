package src;
public class Ingrediente {

	private Integer id_ingrediente;

	private String nombre;

	private Double cantidad;
	

	public Ingrediente(Integer id_ingrediente, String nombre, Double cantidad) {
		this.id_ingrediente = id_ingrediente;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}


	public Integer getId_ingrediente() {
		return id_ingrediente;
	}


	public void setId_ingrediente(Integer id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCantidad() {
		return cantidad;
	}


	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}


	public boolean Cantidad_suficiente() {
		if(cantidad<100) {
			return false;
		}
		else {
			return true;
		}
	}

}