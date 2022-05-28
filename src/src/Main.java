package src;
public class Main {
	public static void main(String[] args) {
		BBDD bbdd = new BBDD();
		System.out.println(bbdd.mostrarPedido("12312312R"));
		System.out.println(bbdd.mostrarPlato(1).get(0));
		
	}

}
