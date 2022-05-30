package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import BaseDatos.BBDD;

public class TestmodificarPrecio {
	
	BBDD bd = new BBDD();
	
	@Test
	public void modificarprecio() {
		
		int id_plato = 7;
		Double precio_nuevo = 7.5;
		
		boolean resultado = bd.modificarPrecio(id_plato, precio_nuevo);
		assertTrue(resultado);
		
		
	}

}