package test;



import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.BBDD;

public class Testmostrarcontrase�aAdmin {

BBDD bd = new BBDD();
	
	@Test
	public void  TestmostrarContrase�aAdmin()
	{
		String lista = "";
		
		boolean contrase�aResultado = bd.mostrarContrase�aAdmin(lista);
		
		assertTrue(contrase�aResultado);
	}	


}
