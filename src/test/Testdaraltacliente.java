package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.BBDD;
import src.Cliente;

public class Testdaraltacliente {
		
		BBDD bd = new BBDD();
		
		@Test
		public void daralataCliente () {
			
			Cliente c = new Cliente("12312312C", "hola@gmail.com", "calle dios", "12345");
			boolean resultado = bd.darAltaCliente(c);
			assertTrue(resultado);
			
		}
}
