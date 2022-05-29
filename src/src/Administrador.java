package src;


/**
 * clase del usuario administrador
 * @author víctor
 *
 */
public class Administrador {
	
	private String dni_admin;

	private String contraseña;


	public Administrador(String dni_admin, String contraseña) {
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

	
	
	





}