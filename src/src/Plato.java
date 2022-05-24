package src;

import java.util.ArrayList;

public class Plato {

	private Integer id_plato;

	private String nombre;

	private Double precio;

	private String tipo;


	public Plato(Integer id_plato,String nombre, Double precio, String tipo) {
		this.id_plato = id_plato;
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
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
	
	







}