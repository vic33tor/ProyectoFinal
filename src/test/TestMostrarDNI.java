package test;



import static org.junit.Assert.assertTrue;

import org.junit.Test;

import BaseDatos.BBDD;

public class TestMostrarDNI{
	
	
	BBDD bd = new BBDD();
	
	@Test
	public void mostrarDni() {
		

		String lista = "hola@gmail.com";
		String dni = "12312312R";
		
		String dniResultado = bd.mostrarDni(lista);
		
		
	assertTrue(dni.equals(dniResultado));
		

	}

}
