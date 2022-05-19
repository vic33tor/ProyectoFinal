package src;


import java.util.Scanner;

public class Cliente{

	Scanner sc = new Scanner(System.in);

	private String dni_cliente;

	private String email;

	private String direccion;

	private String contraseña;
	
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

	public void realizarPedido() {
		System.out.println("Estos son los platos de la carta:");
		bd.mostrarPlatos();
		System.out.println("Estos son las bebidas de la carta:");
		bd.mostrarBebidas();
		String nombre_plato;
		do {
			System.out.println("Seleccione un plato o una bebida escribiendo su nombre(Presione 0 para salir)");
			nombre_plato = sc.next();
			

		}while(!nombre_plato.equals(0));
		//DUDA CON COMO OBTENER EL OBJETO CON EL ID
	}
	public void Oferta() {

	}

}