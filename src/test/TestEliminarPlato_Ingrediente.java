package test;



import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.BBDD;

public class TestEliminarPlato_Ingrediente {

BBDD bd = new BBDD();
	
	@Test
	public void eliminarplato_ingrediente() {
		
		int p = 7;
		
		boolean resultado = bd.eliminarPlato_Ingrediente(p);
		assertTrue(resultado );
		
	}

}
