package src;



public class Aministrador {
	
	private String dni_admin;

	private String contrase�a;


	public Aministrador(String dni_admin, String contrase�a) {
		this.dni_admin = dni_admin;
		this.contrase�a = contrase�a;
	}

	public String getDni_admin() {
		return dni_admin;
	}

	public void setDni_admin(String dni_admin) {
		this.dni_admin = dni_admin;
	}
	
	
	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	
	public void comprarIngredientes(Ingrediente x) {
		if(x.Cantidad_suficiente() == false) {
			x.setCantidad(2000.00);
		}
	}
	
	





}