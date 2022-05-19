package src;



public class Aministrador {
	
	private String dni_admin;

	private String contraseña;


	public Aministrador(String dni_admin, String contraseña) {
		this.dni_admin = dni_admin;
		this.contraseña = contraseña;
	}

	public String getDni_admin() {
		return dni_admin;
	}

	public void setDni_admin(String dni_admin) {
		this.dni_admin = dni_admin;
	}
	
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	
	public void comprarIngredientes(Ingrediente x) {
		if(x.Cantidad_suficiente() == false) {
			x.setCantidad(2000.00);
		}
	}
	
	





}