package src;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import BaseDatos.BBDD;
/**
 * clase del usuario cliente
 * @author víctor
 *
 */
public class Cliente{

	Scanner sc = new Scanner(System.in);

	private String dni_cliente;

	private String email;

	private String direccion;

	private String contraseña;
	/**
	 * una lista de los platos que esta comprando en ese momento
	 */
	public HashMap<Integer, Plato> platos = new HashMap<Integer, Plato>();
	BBDD bd = new BBDD();


	public Cliente(String dni_cliente, String email, String direccion, String contraseña) {
		this.dni_cliente = dni_cliente;
		this.email = email;
		this.direccion = direccion;
		this.contraseña = contraseña;
	}
	
	public String getDni_cliente() {
		return dni_cliente;
	}

	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	

}