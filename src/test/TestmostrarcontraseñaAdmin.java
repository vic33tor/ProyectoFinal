package test;



import static org.junit.Assert.assertTrue;

import org.junit.Test;

import BaseDatos.BBDD;

public class TestmostrarcontraseñaAdmin {

BBDD bd = new BBDD();
	
	@Test
	public void  TestmostrarContraseñaAdmin()
	{
		String lista = "";
		
		boolean contraseñaResultado = bd.mostrarContraseñaAdmin(lista);
		
		assertTrue(contraseñaResultado);
	}	


}
