package src;
public class Main {
	public static void main(String[] args) {
		BBDD bbdd = new BBDD();
		System.out.println(bbdd.mostrarEmail("hola@gmail.com"));
		System.out.println(bbdd.mostrarContraseña("hola@gmail.com", "12345"));
		
	}

}
